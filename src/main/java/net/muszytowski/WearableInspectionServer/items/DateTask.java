package net.muszytowski.WearableInspectionServer.items;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


/**
 * Date task for specifying a date in the format
 * yyyy-MM-dd HH:mm:ss. To be used with date related tasks.
 * 
 * @author Sebastian Muszytowski
 */
@Entity
@Table(name = "DateTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "106")
public class DateTask extends GenericTask {

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC")
	private Date value;

	public DateTask(){}
	public DateTask(String name, String description, String author, Date date, Date value){
		super(name,description,author,date);
		this.value = value;
	}
	
	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}
	
	
}
