package net.muszytowski.WearableInspectionServer.Items;

import javax.persistence.Entity;

@Entity
public class BooleanTask extends GenericTask {

	private Boolean value;

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}
	
	public BooleanTask(){}
	
}
