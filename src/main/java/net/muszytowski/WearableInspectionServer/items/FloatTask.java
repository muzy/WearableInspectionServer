package net.muszytowski.WearableInspectionServer.items;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@Table(name = "FloatTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "105")
public class FloatTask extends GenericTask {

	private Float value;
	
	public FloatTask(){}
	public FloatTask(String name, String description, String author, Date date, Float value){
		super(name,description,author,date);
		this.value = value;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
}
