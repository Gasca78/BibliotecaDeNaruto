package com.aluracursos.bibliolura.Bibliolura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Height(
        @JsonAlias("Part I") String estatura,
        @JsonAlias("Part II") String estaturaShippuden
) {
    @Override
    public String toString() {
        return  "Estatura: '" + estatura + '\'' +
                ", EstaturaShippuden: '" + estaturaShippuden + '\'';
    }
}
