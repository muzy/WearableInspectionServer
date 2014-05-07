package net.muszytowski.WearableInspectionServer.items;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * Task tree bean for grouping tasks in a hierarchy.
 * 
 * @author Sebastian Muszytowski
 */
@Entity
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "1")
public class Task extends GenericTask {
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=GenericTask.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "parentId")
	private List<GenericTask> children = new ArrayList<GenericTask>();
			
	public Task(){}
	
	public Task(List<GenericTask> children,String name, String description, String author, Date date){
		super(name,description,author,date);
		this.children = children;
	}
	
	public void setChildren(final List<GenericTask> children) {
		this.children = children;
	}
	
	public List<GenericTask> getChildren() {
		return this.children;
	}
	
	public void addChildren(GenericTask child){
		children.add(child);
	}
}
