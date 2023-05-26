package com.sena.backedservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa a una persona en el sistema.
 * Extiende la clase BaseModel que proporciona los campos comunes.
 */
@Entity
@Table(name = "person")
@Schema(description = "Entidad que representa un persona en el sistema")
public class Person extends BaseModel {

	public enum DocumentType { CE, CC, TI, PP, DNI }

	@Column(name = "first_name", nullable = false, length = 50)
	@Schema(description = "Primer nombre de la persona", required = true, maxLength = 50)
	private String firstName;

	@Column(name = "second_name", nullable = false, length = 50)
	@Schema(description = "Segundo nombre de la persona", required = true, maxLength = 50)
	private String secondName;

	@Column(name = "first_last_name", nullable = false, length = 50)
	@Schema(description = "Primer apellido de la persona", required = true, maxLength = 50)
	private String firstLastName;

	@Column(name = "second_last_name", nullable = false, length = 50)
	@Schema(description = "Segundo apellido de la persona", required = true, maxLength = 50)
	private String secondLastName;

	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", nullable = false)
	@Schema(description = "Tipo de documento de la persona", required = true)
	private DocumentType documentType;

	@Column(name = "document", nullable = false, unique = true, length = 12)
	@Schema(description = "Número de documento de la persona", required = true, maxLength = 12)
	private String document;

	@Column(name = "age", nullable = false)
	@Schema(description = "Edad de la persona", required = true)
	private Byte age;

	@Column(name = "gender")
	@Schema(description = "Género de la persona")
	private Boolean gender;

	@Column(name = "mail", nullable = false, length = 30, unique = true)
	@Schema(description = "Correo electrónico de la persona", required = true, maxLength = 30)
	private String mail;

	@Column(name = "phone_number", nullable = false, length = 10)
	@Schema(description = "Número de teléfono de la persona", required = true, maxLength = 10)
	private String phoneNumber;

	@Column(name = "address", nullable = false, length = 30)
	@Schema(description = "Dirección de la persona", required = true, maxLength = 30)
	private String address;

	/**
	 * Retorna el primer nombre de la persona.
	 *
	 * @return el primer nombre de la persona
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Establece el primer nombre de la persona.
	 *
	 * @param firstName el primer nombre de la persona a establecer
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retorna el segundo nombre de la persona.
	 *
	 * @return el segundo nombre de la persona
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * Establece el segundo nombre de la persona.
	 *
	 * @param secondName el segundo nombre de la persona a establecer
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * Retorna el primer apellido de la persona.
	 *
	 * @return el primer apellido de la persona
	 */
	public String getFirstLastName() {
		return firstLastName;
	}

	/**
	 * Establece el primer apellido de la persona.
	 *
	 * @param firstLastName el primer apellido de la persona a establecer
	 */
	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	/**
	 * Retorna el segundo apellido de la persona.
	 *
	 * @return el segundo apellido de la persona
	 */
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * Establece el segundo apellido de la persona.
	 *
	 * @param secondLastName el segundo apellido de la persona a establecer
	 */
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	/**
	 * Retorna el tipo de documento de la persona.
	 *
	 * @return el tipo de documento de la persona
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}

	/**
	 * Establece el tipo de documento de la persona.
	 *
	 * @param documentType el tipo de documento de la persona a establecer
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	/**
	 * Retorna el número de documento de la persona.
	 *
	 * @return el número de documento de la persona
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * Establece el número de documento de la persona.
	 *
	 * @param document el número de documento de la persona a establecer
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * Retorna la edad de la persona.
	 *
	 * @return la edad de la persona
	 */
	public Byte getAge() {
		return age;
	}

	/**
	 * Establece la edad de la persona.
	 *
	 * @param age la edad de la persona a establecer
	 */
	public void setAge(Byte age) {
		this.age = age;
	}

	/**
	 * Retorna el género de la persona.
	 *
	 * @return el género de la persona
	 */
	public Boolean getGender() {
		return gender;
	}

	/**
	 * Establece el género de la persona.
	 *
	 * @param gender el género de la persona a establecer
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	/**
	 * Retorna el correo electrónico de la persona.
	 *
	 * @return el correo electrónico de la persona
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Establece el correo electrónico de la persona.
	 *
	 * @param mail el correo electrónico de la persona a establecer
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Retorna el número de teléfono de la persona.
	 *
	 * @return el número de teléfono de la persona
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Establece el número de teléfono de la persona.
	 *
	 * @param phoneNumber el número de teléfono de la persona a establecer
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Retorna la dirección de la persona.
	 *
	 * @return la dirección de la persona
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Establece la dirección de la persona.
	 *
	 * @param address la dirección de la persona a establecer
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}