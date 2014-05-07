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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * A ListTask bean has one or more options the user can choose from.
 * 
 * @author Sebastian Muszytowski
 *
 */
@Entity
@Table(name = "ListTask")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorValue(value = "102")
public class ListTask extends GenericTask {

	private String value;
	
	@OneToMany(targetEntity=ListOption.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "listTask")
	private List<ListOption> options = new ArrayList<ListOption>();
	
	public ListTask(){}
	public ListTask(String name, String description, String author, Date date, String value, List<ListOption> options){
		super(name,description,author,date);
		this.value = value;
		this.options = options;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void addOption(ListOption option) {
		options.add(option);
	}

	public List<ListOption> getOptions() {
		return options;
	}

	public void setOptions(List<ListOption> options) {
		this.options = options;
	}
	
}
