package com.aluracursos.bibliolura.Bibliolura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Personal(
        @JsonAlias("birthdate") String cumple,
        @JsonAlias("sex") String sexo,
        @JsonAlias("age") Age edad,
        @JsonAlias("height") Height estatura,
        @JsonAlias("weight") Weight peso
//        @JsonAlias("kekkeiGenkai") List<String> kekkeiGenkai
//        @JsonAlias("classification") List<String> clasificacion
//        @JsonAlias("tailedBeast") String bestiaConCola,
//        @JsonAlias("occupation") List<String> ocupacion
//        @JsonAlias("team") List<String> equipo
//        @JsonAlias("clan") List<String> clan
) {
}
