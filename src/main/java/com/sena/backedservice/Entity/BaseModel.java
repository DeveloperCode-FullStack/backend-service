package com.sena.backedservice.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import io.swagger.v3.oas.annotations.media.Schema;

@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "ID del registro")
	private Long id;
	
	@Column(name = "state", nullable = false)
	@Schema(description = "Estado del registro")
	private Boolean state;
	
	@Column(name = "user_creation_id", nullable = false)
	@Schema(description = "ID del usuario creador")
	private Long userCreationId;
	
	@Column(name = "user_modification_id", nullable = true)
	@Schema(description = "ID del usuario que modificó")
	private Long userModificationId;
	
	@Column(name = "date_creation", nullable = false)
	@Schema(description = "Fecha de creación del registro")
	private LocalDateTime dateCreation;
	
	@Column(name = "date_modification", nullable = true)
	@Schema(description = "Fecha de modificación del registro")
	private LocalDateTime dateModification;
	
	/**
	 * Retorna el ID del registro.
	 *
	 * @return el ID del registro
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el ID del registro.
	 *
	 * @param id el ID del registro a establecer
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna el estado del registro.
	 *
	 * @return el estado del registro
	 */
	public Boolean getState() {
		return state;
	}

	/**
	 * Establece el estado del registro.
	 *
	 * @param state el estado del registro a establecer
	 */
	public void setState(Boolean state) {
		this.state = state;
	}

	/**
	 * Retorna el ID del usuario creador.
	 *
	 * @return el ID del usuario creador
	 */
	public Long getUserCreationId() {
		return userCreationId;
	}

	/**
	 * Establece el ID del usuario creador.
	 *
	 * @param userCreationId el ID del usuario creador a establecer
	 */
	public void setUserCreationId(Long userCreationId) {
		this.userCreationId = userCreationId;
	}

	/**
	 * Retorna el ID del usuario que modificó.
	 *
	 * @return el ID del usuario que modificó
	 */
	public Long getUserModificationId() {
		return userModificationId;
	}

	/**
	 * Establece el ID del usuario que modificó.
	 *
	 * @param userModificationId el ID del usuario que modificó a establecer
	 */
	public void setUserModificationId(Long userModificationId) {
		this.userModificationId = userModificationId;
	}

	/**
	 * Retorna la fecha de creación del registro.
	 *
	 * @return la fecha de creación del registro
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	/**
	 * Establece la fecha de creación del registro.
	 *
	 * @param dateCreation la fecha de creación del registro a establecer
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Retorna la fecha de modificación del registro.
	 *
	 * @return la fecha de modificación del registro
	 */
	public LocalDateTime getDateModification() {
		return dateModification;
	}

	/**
	 * Establece la fecha de modificación del registro.
	 *
	 * @param dateModification la fecha de modificación del registro a establecer
	 */
	public void setDateModification(LocalDateTime dateModification) {
		this.dateModification = dateModification;
	}
}
