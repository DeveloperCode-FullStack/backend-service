package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa un módulo en el sistema.
 * Extiende la clase BaseModel que proporciona los campos comunes.
 */
@Entity
@Table(name = "module")
@Schema(description = "Entidad que representa un modulo en el sistema")
public class Module extends BaseModel {

	@Column(name = "code", nullable = false, unique = true)
	@Schema(description = "Código del módulo", required = true)
	private String code;

	@Column(name = "route", length = 150, unique = true)
	@Schema(description = "Ruta del módulo", maxLength = 150)
	private String route;

	@Column(name = "label", nullable = false, length = 100)
	@Schema(description = "Etiqueta del módulo", required = true, maxLength = 100)
	private String label;

	/**
	 * Retorna el código del módulo.
	 *
	 * @return el código del módulo
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Establece el código del módulo.
	 *
	 * @param code el código del módulo a establecer
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Retorna la ruta del módulo.
	 *
	 * @return la ruta del módulo
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * Establece la ruta del módulo.
	 *
	 * @param route la ruta del módulo a establecer
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * Retorna la etiqueta del módulo.
	 *
	 * @return la etiqueta del módulo
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Establece la etiqueta del módulo.
	 *
	 * @param label la etiqueta del módulo a establecer
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}