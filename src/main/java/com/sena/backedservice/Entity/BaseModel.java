package com.sena.backedservice.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "state", nullable = false)
	private Boolean state;
	
	@Column (name = "user_creation_id", nullable = false)
	private Long userCreationId;
	
	@Column (name = "user_modification_id", nullable = true)
	private Long userModificationId;
	
	@Column (name = "date_creation", nullable = false)
	private LocalDateTime dateCreation;
	
	@Column (name = "date_modification", nullable = true)
	private LocalDateTime dateModification;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Long getUserCreationId() {
		return userCreationId;
	}

	public void setUserCreationId(Long userCreationId) {
		this.userCreationId = userCreationId;
	}

	public Long getUserModificationId() {
		return userModificationId;
	}

	public void setUserModificationId(Long userModificationId) {
		this.userModificationId = userModificationId;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateModification() {
		return dateModification;
	}

	public void setDateModification(LocalDateTime dateModification) {
		this.dateModification = dateModification;
	}
}
