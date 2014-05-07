package net.muszytowski.WearableInspectionServer.items;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * A Range task bean is for ranges. 
 * @author Sebastian Muszytowski
 */
@Entity
@Table(name = "RangeTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "101")
public class RangeTask extends GenericTask {

	private float start;
	private float stop;
	private float step;
	private float value;
	
	public RangeTask(){}
	
	public RangeTask(String name, String description, String author, Date date, Float start, Float stop, Float step, Float value){
		super(name,description,author,date);
		this.start = start;
		this.stop = stop;
		this.step = step;
		this.value = value;
	}
	
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
