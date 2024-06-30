package com.Wilmer.Screenmatch.Interfaces;

public interface IConvierteDatos {
    <T> T convierteDatos(String json, Class<T> tClass);
}
