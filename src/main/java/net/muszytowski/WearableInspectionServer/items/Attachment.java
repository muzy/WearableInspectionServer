package net.muszytowski.WearableInspectionServer.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
public class Attachment {

	@Id 
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long resourceIdentifier;
	private String name;
	private String type;
	private byte[] content;
	
	public Attachment(){}
	
	public Long getResourceIdentifier(){
		return this.resourceIdentifier;
	}
	
	public void setResourceIdentifier(Long id) {
		this.resourceIdentifier = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}
	
}
