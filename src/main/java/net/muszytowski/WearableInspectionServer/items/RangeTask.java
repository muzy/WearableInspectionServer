package net.muszytowski.WearableInspectionServer.items;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
public class RangeTask extends GenericTask {

	private float start;
	private float stop;
	private float step;
	private float value;
	
	public RangeTask(){}
	
	/**
	 * @return the start
	 */
	public float getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(float start) {
		this.start = start;
	}
	/**
	 * @return the stop
	 */
	public float getStop() {
		return stop;
	}
	/**
	 * @param stop the stop to set
	 */
	public void setStop(float stop) {
		this.stop = stop;
	}
	/**
	 * @return the step
	 */
	public float getStep() {
		return step;
	}
	/**
	 * @param step the step to set
	 */
	public void setStep(float step) {
		this.step = step;
	}
	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		if(Float.compare(value, this.start) > 0 && 
				Float.compare(value, this.stop) < 0 )
			this.value = value;
	}
}
