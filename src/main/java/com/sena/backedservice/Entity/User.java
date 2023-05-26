package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa a una usuario en el sistema.
 * Extiende la clase BaseModel que proporciona los campos comunes.
 */
@Entity
@Table(name = "user")
@Schema(description = "Entidad que representa un usuario en el sistema")
public class User extends BaseModel {
	
	@Column(name = "user", nullable = false, unique = true, length = 100)
	@Schema(description = "Nombre de usuario")
	private String user;
	
	@Column(name = "password", nullable = false, length = 100)
	@Schema(description = "Contraseña del usuario")
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    @Schema(description = "Identificador de la persona asociada al usuario")
    private Person personId;

	/**
	 * Retorna el nombre de usuario.
	 *
	 * @return el nombre de usuario
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Establece el nombre de usuario.
	 *
	 * @param user el nombre de usuario a establecer
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Retorna la contraseña del usuario.
	 *
	 * @return la contraseña del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la contraseña del usuario.
	 *
	 * @param password la contraseña del usuario a establecer
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retorna la persona asociada al usuario.
	 *
	 * @return la persona asociada al usuario
	 */
	public Person getPersonId() {
		return personId;
	}

	/**
	 * Establece la persona asociada al usuario.
	 *
	 * @param personId la persona asociada al usuario a establecer
	 */
	public void setPersonId(Person personId) {
		this.personId = personId;
	}
}