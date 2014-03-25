package net.muszytowski.WearableInspectionServer.Items;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class DateTask extends GenericTask {

	private Date value;

	public DateTask(){}
	
	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}
	
	
}
