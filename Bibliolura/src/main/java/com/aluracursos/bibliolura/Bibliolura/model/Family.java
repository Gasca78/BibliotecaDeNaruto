package com.aluracursos.bibliolura.Bibliolura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Family(
        @JsonAlias("father") String padre,
        @JsonAlias("mother") String madre,
        @JsonAlias("son") String hijo,
        @JsonAlias("daughter") String hija,
        @JsonAlias("wife") String esposa,
        @JsonAlias("husband") String esposo,
        @JsonAlias("adoptive son") String hijoAdoptivo,
        @JsonAlias("godfather") String abuelo,
        @JsonAlias("grandmother") String abuela,
        @JsonAlias("godson") String nieto
) {
    @Override
    public String toString() {
        return  "Padre='" + padre + '\'' +
                ", Madre='" + madre + '\'' +
                ", Hijo='" + hijo + '\'' +
                ", Hija='" + hija + '\'' +
                ", Esposa='" + esposa + '\'' +
                ", Esposo='" + esposo + '\'' +
                ", HijoAdoptivo='" + hijoAdoptivo + '\'' +
                ", Abuelo='" + abuelo + '\'' +
                ", Abuela='" + abuela + '\'' +
                ", Nieto/a='" + nieto;
    }
}
