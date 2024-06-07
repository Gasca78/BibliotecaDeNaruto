package com.aluracursos.bibliolura.Bibliolura.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
