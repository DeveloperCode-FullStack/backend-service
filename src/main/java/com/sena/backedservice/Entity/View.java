package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "view")
public class View extends BaseModel{
	
	@Column (name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "route", nullable = false, length = 150, unique = true)
	private String route;
	
	@Column (name = "label", nullable = false, length = 100, unique = true)
	private String label;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "module_id", nullable = false)
    private Module moduleId;
	
		
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

	public Module getModuleId() {
		return moduleId;
	}

	public void setModuleId(Module moduleId) {
		this.moduleId = moduleId;
	}
}
