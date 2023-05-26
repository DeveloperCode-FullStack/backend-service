package com.sena.backedservice.Dto;

public interface IModuleDto {
	
	/**
     * Obtiene el código del modulo.
     *
     * @return el estado del modulo
     */
    String getCode();
    
    /**
     * Obtiene la ruta del modulo.
     *
     * @return la ruta del modulo
     */
    String getRoute();
    
    /**
     * Obtiene la etiqueta del modulo.
     *
     * @return la etiqueta del modulo
     */
    String getLabel();
    
    /**
     * Obtiene la cantidad del modulo.
     *
     * @return la cantidad del modulo
     */
    Integer getQuantity();
}
