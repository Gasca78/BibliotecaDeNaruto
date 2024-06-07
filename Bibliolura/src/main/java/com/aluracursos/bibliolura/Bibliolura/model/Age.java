package com.aluracursos.bibliolura.Bibliolura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Age(
        @JsonAlias("Part I") String edad,
        @JsonAlias("Part II") String edadShippuden
) {
    @Override
    public String toString() {
        return  "Edad: '" + edad + '\'' +
                ", EdadShippuden: '" + edadShippuden + '\'';
    }
}
