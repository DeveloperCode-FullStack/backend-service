package com.sena.backedservice.Dto;

public interface IPersonDto {
	
	public enum DocumentType { CE, CC, TI, PP, DNI }
	
	String getFirstname();
	
	String getSecondname();
	
	String getFirstlastname();
	
	String getSecondlastname();
	
	DocumentType getDocumenttype();
	
	String getDocument();
	
	Byte getAge();
	
	Boolean getGender();
	
	String getMail();
	
	String getPhonenumber();
	
	String getAddress();
	
	Integer getQuantity();
}
