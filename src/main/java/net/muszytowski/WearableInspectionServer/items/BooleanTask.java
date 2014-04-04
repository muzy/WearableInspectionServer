package net.muszytowski.WearableInspectionServer.items;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@Table(name = "BooleanTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "107")
public class BooleanTask extends GenericTask {

	private Boolean value;

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}
	
	public BooleanTask(){}
	public BooleanTask(String name, String description, String author, Date date, Boolean value){
		super(name,description,author,date);
		this.value = value;
	}
	
}
