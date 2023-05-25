package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="module")
public class Module extends BaseModel{
	
	@Column (name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "route", length = 150, unique = true)
	private String route;
	
	@Column (name = "label", nullable = false, length = 100, unique = true)
	private String label;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
