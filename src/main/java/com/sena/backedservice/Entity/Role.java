package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa un rol en el sistema.
 * Extiende la clase BaseModel que proporciona los campos comunes.
 */
@Entity
@Table(name = "role")
@Schema(description = "Entidad que representa un rol en el sistema")
public class Role extends BaseModel {
		
	@Column(name = "code", nullable = false, unique = true)
	@Schema(description = "Código del rol")
	private String code;
	
	@Column(name = "description", nullable = false, unique = true)
	@Schema(description = "Descripción del rol")
	private String description;

	/**
	 * Retorna el código del rol.
	 *
	 * @return el código del rol
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Establece el código del rol.
	 *
	 * @param code el código del rol a establecer
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Retorna la descripción del rol.
	 *
	 * @return la descripción del rol
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripción del rol.
	 *
	 * @param description la descripción del rol a establecer
	 */
	public void setDescription(String description) {
		this.description = description;
	}	
}
