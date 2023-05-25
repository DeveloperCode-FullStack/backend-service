package com.sena.backedservice.Dto;

/**
 * Interfaz que define los métodos para acceder a los atributos de un objeto PermissionDto.
 */
public interface IPermissionDto {

    /**
     * Obtiene la ruta de vista asociada al permiso.
     *
     * @return la ruta de vista
     */
    String getViewRoute();

    /**
     * Obtiene la etiqueta de vista asociada al permiso.
     *
     * @return la etiqueta de vista
     */
    String getViewLabel();

    /**
     * Obtiene la ruta del módulo asociado al permiso.
     *
     * @return la ruta del módulo
     */
    String getModuleRoute();

    /**
     * Obtiene la etiqueta del módulo asociado al permiso.
     *
     * @return la etiqueta del módulo
     */
    String getModuleLabel();
}