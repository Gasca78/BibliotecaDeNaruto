package com.aluracursos.bibliolura.Bibliolura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Character(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String nombre,
        @JsonAlias("family") Family familia,
        @JsonAlias("jutsu") List<String> jutsu,
        @JsonAlias("personal") Personal datosPersonales,
//        @JsonAlias("rank") List<String> ranking,
        @JsonAlias("tools") List<String> herramientas
) {
    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nSexo: " + datosPersonales.sexo()
                + "\nFecha de Cumpleaños: " + datosPersonales.cumple()
                + "\nFamilia: " + familia
                + "\n\nDatos personales"
                + "\n" + datosPersonales.edad()
                + "\n" + datosPersonales.estatura()
                + "\n" + datosPersonales.peso()
                + "\n\nJutsus que conoce: " + jutsu()
                + "\nHerramientas que ha utilizado: " + herramientas();
    }
}
