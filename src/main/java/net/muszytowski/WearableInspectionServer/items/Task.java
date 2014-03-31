package net.muszytowski.WearableInspectionServer.items;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


@Entity
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "1")
public class Task extends GenericTask {
	
	@OneToMany(mappedBy="parent", fetch=FetchType.EAGER, targetEntity=GenericTask.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Collection<GenericTask> children;
			
}
