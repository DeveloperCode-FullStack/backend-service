package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends BaseModel{
	
	public enum DocumentType{CE, CC, TI, PP, DNI}
	
	@Column(name= "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "second_name", nullable = false, length = 50)
	private String secondName;
	
	@Column (name = "first_last_name", nullable = false, length = 50)
	private String firstLastName;
	
	@Column (name = "second_last_name", nullable = false, length = 50)
	private String secondLastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", nullable = false)
    private DocumentType documentType;
	
	@Column(name = "document", nullable = false, unique = true, length = 12)
    private String document;
	
	@Column (name = "age", nullable = false)
	private Byte age;
	
	@Column (name = "gender")
	private Boolean gender;
	
	@Column (name = "mail", nullable = false, length = 30)
	private String mail;
	
	@Column(name = "phone_number", nullable = false, length = 10)
	private String phoneNumber;
	
	@Column (name = "address", nullable = false, length = 30, unique = true)
	private String address;	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
