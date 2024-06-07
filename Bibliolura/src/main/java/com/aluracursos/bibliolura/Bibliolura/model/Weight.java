package com.aluracursos.bibliolura.Bibliolura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weight(
        @JsonAlias("Part I") String peso,
        @JsonAlias("Part II") String pesoShippuden
) {
    @Override
    public String toString() {
        return  "Peso: '" + peso + '\'' +
                ", PesoShippuden: '" + pesoShippuden + '\'';
    }
}
