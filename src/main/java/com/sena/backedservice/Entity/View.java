package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa a una vista en el sistema.
 * Extiende la clase BaseModel que proporciona los campos comunes.
 */
@Entity
@Table(name = "view")
@Schema(description = "Entidad que representa una vista en el sistema")
public class View extends BaseModel{
	
	@Column (name = "code", nullable = false, unique = true)
	@Schema(description = "Código de la vista")
	private String code;
	
	@Column (name = "icon", nullable = false)
	@Schema(description = "Ícono de la vista")
	private String icon;
	
	@Column(name = "route", nullable = false, length = 150, unique = true)
	@Schema(description = "Ruta de la vista")
	private String route;
	
	@Column (name = "label", nullable = false, length = 100)
	@Schema(description = "Etiqueta de la vista")
	private String label;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "module_id", nullable = false)
    @Schema(description = "Identificador del módulo al que pertenece la vista")
    private Module moduleId;
	
		
	/**
	 * Retorna el código de la vista.
	 *
	 * @return el código de la vista
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Establece el código de la vista.
	 *
	 * @param code el código de la vista a establecer
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Retorna el ícono de la vista.
	 *
	 * @return el ícono de la vista
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * Establece el ícono de la vista.
	 *
	 * @param code el ícono de la vista a establecer
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * Retorna la ruta de la vista.
	 *
	 * @return la ruta de la vista
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * Establece la ruta de la vista.
	 *
	 * @param route la ruta de la vista a establecer
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * Retorna la etiqueta de la vista.
	 *
	 * @return la etiqueta de la vista
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Establece la etiqueta de la vista.
	 *
	 * @param label la etiqueta de la vista a establecer
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Retorna el módulo al que pertenece la vista.
	 *
	 * @return el módulo al que pertenece la vista
	 */
	public Module getModuleId() {
		return moduleId;
	}

	/**
	 * Establece el módulo al que pertenece la vista.
	 *
	 * @param moduleId el módulo al que pertenece la vista a establecer
	 */
	public void setModuleId(Module moduleId) {
		this.moduleId = moduleId;
	}
}