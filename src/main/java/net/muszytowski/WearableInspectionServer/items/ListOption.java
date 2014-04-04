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
public class ListOption {

	@Id 
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resourceIdentifier;
	private String value;
	
	public ListOption(){};
	public ListOption(String value){
		this.value = value;
	}
		
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	
}
