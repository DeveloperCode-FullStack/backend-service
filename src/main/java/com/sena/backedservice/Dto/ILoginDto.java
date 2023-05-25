package com.sena.backedservice.Dto;

/**
 * Interfaz que define los métodos para acceder a los atributos de un objeto LoginDto.
 */
public interface ILoginDto {

    /**
     * Obtiene el estado del login.
     *
     * @return el estado del login
     */
    Boolean getState();

    /**
     * Obtiene el nombre de usuario.
     *
     * @return el nombre de usuario
     */
    String getUser();
}