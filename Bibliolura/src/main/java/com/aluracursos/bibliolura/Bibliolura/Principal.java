package com.aluracursos.bibliolura.Bibliolura;

import com.aluracursos.bibliolura.Bibliolura.model.Character;
import com.aluracursos.bibliolura.Bibliolura.model.CharactersData;
import com.aluracursos.bibliolura.Bibliolura.service.ConsumoAPI;
import com.aluracursos.bibliolura.Bibliolura.service.ConvierteDatos;
import com.aluracursos.bibliolura.Bibliolura.services.Busqueda;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Principal {
	Scanner scanner = new Scanner(System.in);
	ConsumoAPI consumoAPI = new ConsumoAPI();
	ConvierteDatos conversor = new ConvierteDatos();
	private final String url = "https://dattebayo-api.onrender.com/characters";

    public void muestraMenu() {
		var json = consumoAPI.construirURL(url);
		var datos = conversor.obtenerDatos(json, CharactersData.class);
		System.out.println("Escribe tu nombre, por favor: ");
		String name = scanner.nextLine();
		String intro = """
				¡Bienvenido %s a la biblioteca del mundo de Naruto!
				Aquí encontrarás a muchos de tus personajes favoritos del anime de Naruto
				solo debes de escribir el nombre o el apellido de este y nosotros te brindaremos
				información como...
				Su familia, qué jutsus conoce, fecha de cumpleaños, que edad tenian cuando... y más.""".formatted(name);
		System.out.println(intro);
		String menu = """
				Elige que te gustaría hacer:
				1. Buscar un personaje por su nombre
				2. Buscar personajes que hayan nacido 'X' mes
				3. Dato curioso
				4. Salir""";
		boolean salir = true;

		while (salir) {
			System.out.println(menu);
			String eleccionstr = scanner.nextLine();
			if (!esEntero(eleccionstr)) {
				do {
					System.out.println("No se ingreso un número, ingresa un valor aceptable: ");
					eleccionstr = scanner.nextLine();
				} while (!esEntero(eleccionstr));
			}
			int eleccion = Integer.parseInt(eleccionstr);
			while (eleccion < 0 || eleccion > 4){
				if (!esEntero(eleccionstr)) {
					do {
						System.out.println("No se ingreso un número, ingresa un valor aceptable: ");
						eleccionstr = scanner.nextLine();
					} while (!esEntero(eleccionstr));
				}
				do {
					System.out.println("Número no válido, ingrese otro: ");
					eleccionstr = scanner.nextLine();
				} while (!esEntero(eleccionstr));
				eleccion = Integer.parseInt(eleccionstr);
			}
			switch (eleccion) {
				case 1:
					System.out.println("Escribe el nombre o apellido del personaje");
					String persona = scanner.nextLine();
					String personaje = URLEncoder.encode(persona, StandardCharsets.UTF_8);
					List<Character> personajeBuscado = Busqueda.PorNombre(datos,personaje);
					if (personajeBuscado.isEmpty()) {
						System.out.println("Personaje no encontrado");
					} else {
						System.out.println("Se encontró " + personajeBuscado.size() + " personaje(s):");
						for (Character p : personajeBuscado) {
							System.out.println(p);
						}
					}
					break;
				case 2:
					System.out.println("Escribe un mes (en inglés): ");
					String mes = scanner.nextLine();
					List<Character> personajePorMes = Busqueda.porMesDeCumple(datos,mes);
					if (personajePorMes.isEmpty()) {
						System.out.println("No hay personajes que hayan nacido en ese mes.");
					} else {
						System.out.println("Se encontró " + personajePorMes.size() + " personaje(s)" +
								" que cumple(n) en ese mes: ");
						for (Character pM : personajePorMes) {
							System.out.println(pM.nombre() + ", " + pM.datosPersonales().cumple());
						}
					}
					break;
				case 3:
					System.out.println("Top 5 ninjas con menos jutsus:");
					List<Character> menosJutsus = Busqueda.topJutsus(datos);
					for (Character mJ : menosJutsus) {
						System.out.println(mJ.nombre() + ", cantidad de jutsus que conoce: " + mJ.jutsu().size());
					}
					System.out.println("Top 5 ninjas con más herramientas:");
					List<Character> masHerramientas = Busqueda.topTools(datos);
					for (Character mH : masHerramientas) {
						System.out.println(mH.nombre() + ", cantidad de herramientas que utilizó: " + mH.herramientas().size());
					}
					break;
				case 4:
					salir = false;
					break;
                default:
                    throw new IllegalStateException("Unexpected value: " + eleccion);
            }
		}
	}

	public boolean esEntero(String text) {
		int v;
		try {
			v=Integer.parseInt(text);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}

