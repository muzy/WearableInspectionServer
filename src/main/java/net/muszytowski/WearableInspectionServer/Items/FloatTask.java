package net.muszytowski.WearableInspectionServer.Items;

import javax.persistence.Entity;

@Entity
public class FloatTask extends GenericTask {

	private Float value;
	
	public FloatTask(){}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
}
