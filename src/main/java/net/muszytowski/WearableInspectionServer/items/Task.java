package net.muszytowski.WearableInspectionServer.items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


@Entity
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "1")
public class Task extends GenericTask {
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=GenericTask.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "parentId")
	private List<GenericTask> children = new ArrayList<GenericTask>();
			
	
	public void setChildren(final List<GenericTask> children) {
		this.children = children;
	}
	
	public List<GenericTask> getChildren() {
		return this.children;
	}
}
