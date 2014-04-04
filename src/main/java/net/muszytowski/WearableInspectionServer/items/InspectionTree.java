package net.muszytowski.WearableInspectionServer.items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


@Entity
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
public class InspectionTree {
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity=InspectionTree.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "inspectionParentId")
	private List<InspectionTree> children = new ArrayList<InspectionTree>();
			
	@Id 
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long resourceIdentifier;
	
	@OneToOne(fetch=FetchType.EAGER, targetEntity=Task.class, cascade = CascadeType.ALL)
	private Task data;
	
	private String name;
	
	private String author;
	
	public InspectionTree(){};
	
	public InspectionTree(List<InspectionTree> children,Task data, String name, String author){
		this.children = children;
		this.data = data;
		this.name = name;
		this.author = author;
	}


	public void setChildren(final List<InspectionTree> children) {
		this.children = children;
	}
	
	public void addChild(InspectionTree child){
		if(children == null)
			children = new ArrayList<InspectionTree>();
		children.add(child);
	}
	
	public List<InspectionTree> getChildren() {
		return this.children;
	}

	/**
	 * @return the resourceIdentifier
	 */
	public Long getResourceIdentifier() {
		return resourceIdentifier;
	}

	/**
	 * @param resourceIdentifier the resourceIdentifier to set
	 */
	public void setResourceIdentifier(Long resourceIdentifier) {
		this.resourceIdentifier = resourceIdentifier;
	}

	/**
	 * @return the data
	 */
	public Task getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Task data) {
		this.data = data;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
