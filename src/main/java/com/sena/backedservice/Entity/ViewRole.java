package com.sena.backedservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa a una vistas roles en el sistema.
 * Extiende la clase BaseModel que proporciona los campos comunes.
 */
@Entity
@Table(name = "view_role")
@Schema(description = "Entidad que representa la relación entre una vista y un rol en el sistema")
public class ViewRole extends BaseModel{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "view_id", nullable = false)
    @Schema(description = "Identificador de la vista")
    private View viewId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @Schema(description = "Identificador del rol")
    private Role roleId;

	/**
	 * Retorna la vista asociada a la relación.
	 *
	 * @return la vista asociada a la relación
	 */
	public View getViewId() {
		return viewId;
	}

	/**
	 * Establece la vista asociada a la relación.
	 *
	 * @param viewId la vista a establecer
	 */
	public void setViewId(View viewId) {
		this.viewId = viewId;
	}

	/**
	 * Retorna el rol asociado a la relación.
	 *
	 * @return el rol asociado a la relación
	 */
	public Role getRoleId() {
		return roleId;
	}

	/**
	 * Establece el rol asociado a la relación.
	 *
	 * @param roleId el rol a establecer
	 */
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
}