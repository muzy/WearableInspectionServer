package net.muszytowski.WearableInspectionServer.items;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@Table(name = "DateTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "106")
public class DateTask extends GenericTask {

	private DateTime value;

	public DateTask(){}
	
	public DateTime getValue() {
		return value;
	}

	public void setValue(DateTime value) {
		this.value = value;
	}
	
	
}
