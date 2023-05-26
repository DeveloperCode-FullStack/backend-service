package com.sena.backedservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa a una roles de los usuarios en el sistema.
 * Extiende la clase BaseModel que proporciona los campos comunes.
 */
@Entity
@Table(name = "user_role")
@Schema(description = "Entidad que representa la relación entre un usuario y un rol")
public class UserRole extends BaseModel {
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "Identificador del usuario asociado al rol")
    private User userId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @Schema(description = "Identificador del rol asociado al usuario")
    private Role roleId;
	
	/**
	 * Retorna el usuario asociado al rol.
	 *
	 * @return el usuario asociado al rol
	 */
	public User getUserId() {
		return userId;
	}

	/**
	 * Establece el usuario asociado al rol.
	 *
	 * @param userId el usuario asociado al rol a establecer
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}

	/**
	 * Retorna el rol asociado al usuario.
	 *
	 * @return el rol asociado al usuario
	 */
	public Role getRoleId() {
		return roleId;
	}

	/**
	 * Establece el rol asociado al usuario.
	 *
	 * @param roleId el rol asociado al usuario a establecer
	 */
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
}