package com.aluracursos.bibliolura.Bibliolura.services;

import com.aluracursos.bibliolura.Bibliolura.model.Character;
import com.aluracursos.bibliolura.Bibliolura.model.CharactersData;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Busqueda {

    public static List<Character> PorNombre(CharactersData datos, String personaje) {
        return datos.characterList().stream()
                .filter(p -> p.nombre().toUpperCase().contains(personaje.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static List<Character> porMesDeCumple(CharactersData datos, String mes) {
        return datos.characterList().stream()
                .filter(p -> {
                    String fechaCumple = p.datosPersonales().cumple();
                    if (fechaCumple != null) {
                        String[] mesCumple = fechaCumple.split(" ");
                        return mesCumple[0].equalsIgnoreCase(mes);
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public static List<Character> topJutsus(CharactersData datos) {
        return datos.characterList().stream()
                .sorted(Comparator.comparing(d -> d.jutsu().size()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<Character> topTools(CharactersData datos) {
        return datos.characterList().stream()
                .filter(Objects::nonNull)
                .filter(character -> character.herramientas() != null && !character.herramientas().isEmpty())
                .sorted(Comparator.comparingInt(d -> d.herramientas().size()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
