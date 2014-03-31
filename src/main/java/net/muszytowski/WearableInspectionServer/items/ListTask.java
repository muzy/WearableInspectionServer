package net.muszytowski.WearableInspectionServer.items;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@Table(name = "ListTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "102")
public class ListTask extends GenericTask {

	@OneToOne(optional=true)
	private ListOption value;
	
	@OneToMany(mappedBy="resourceIdentifier",targetEntity=ListOption.class,
		       fetch=FetchType.EAGER)
	private List<ListOption> options;

	public ListOption getValue() {
		return value;
	}

	public void setValue(ListOption value) {
		this.value = value;
	}
	
}
