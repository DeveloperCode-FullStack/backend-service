package com.sena.backedservice.Dto;

/**
 * Interfaz que define los métodos para acceder a los atributos de un objeto UserDto.
 */
public interface IUserDto {

    /**
     * Obtiene el estado del usuario.
     *
     * @return el estado del usuario
     */
    Boolean getStatu();

    /**
     * Obtiene el nombre de usuario.
     *
     * @return el nombre de usuario
     */
    String getUser();

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return la contraseña del usuario
     */
    String getPassword();
}
