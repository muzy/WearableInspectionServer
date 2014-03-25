package net.muszytowski.WearableInspectionServer.Items;

import javax.persistence.Entity;

@Entity
public class StringTask extends GenericTask {
	private String value;

	public StringTask(){}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
