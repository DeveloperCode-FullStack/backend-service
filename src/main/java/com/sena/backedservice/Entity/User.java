package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseModel{
	
	@Column(name = "user", nullable = false, unique = true, length = 100)
	private String user;
	
	@Column (name = "password", nullable = false, length = 100)
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person personId;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}
}
