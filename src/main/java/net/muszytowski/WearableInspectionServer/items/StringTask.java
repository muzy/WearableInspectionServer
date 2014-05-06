package net.muszytowski.WearableInspectionServer.items;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@Table(name = "StringTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "100")
public class StringTask extends GenericTask {
	private String value;

	public StringTask(){}
	public StringTask(String name, String description, String author, Date date, String value){
		super(name,description,author,date);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
