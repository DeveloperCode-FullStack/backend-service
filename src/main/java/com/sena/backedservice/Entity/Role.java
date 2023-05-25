package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseModel{
		
	@Column (name = "code", nullable = false, unique = true)
	private String code;
	
	@Column (name = "description", nullable = false, unique = true)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
