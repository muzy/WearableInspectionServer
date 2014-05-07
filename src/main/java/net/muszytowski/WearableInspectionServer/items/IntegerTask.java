package net.muszytowski.WearableInspectionServer.items;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * IntegerTask is a bean for integer return types.
 * @author Sebastian Muszytowski
 */
@Entity
@Table(name = "IntegerTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "103")
public class IntegerTask extends GenericTask {
	private Integer value;

	public IntegerTask(){}
	public IntegerTask(String name, String description, String author, Date date, Integer value){
		super(name,description,author,date);
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
