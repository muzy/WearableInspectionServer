package net.muszytowski.WearableInspectionServer.Items;

import javax.persistence.Entity;

@Entity
public class IntegerTask extends GenericTask {
	private Integer value;

	public IntegerTask(){}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
