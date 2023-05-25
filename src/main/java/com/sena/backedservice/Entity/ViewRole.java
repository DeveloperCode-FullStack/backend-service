package com.sena.backedservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_role")
public class ViewRole extends BaseModel{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "view_id", nullable = false)
    private View viewId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role roleId;

	public View getViewId() {
		return viewId;
	}

	public void setViewId(View viewId) {
		this.viewId = viewId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
}
