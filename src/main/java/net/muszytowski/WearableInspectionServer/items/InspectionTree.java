package net.muszytowski.WearableInspectionServer.items;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@ManyToOne
	@JsonBackReference
    private InspectionTree parent;
		
	@OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
	@JsonManagedReference
	private Collection<InspectionTree> children;
			
	@Id 
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long resourceIdentifier;
	
	@OneToOne
	private Task data;
	
	private String name;
	
	private String author;

	/**
	 * @return the parent
	 */
	public InspectionTree getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(InspectionTree parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public Collection<InspectionTree> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Collection<InspectionTree> children) {
		this.children = children;
	}
	
	public void addChild(InspectionTree child){
		if(children == null)
			children = new LinkedList<InspectionTree>();
		children.add(child);
	}

	/**
	 * @return the resourceIdentifier
	 */
	public long getResourceIdentifier() {
		return resourceIdentifier;
	}

	/**
	 * @param resourceIdentifier the resourceIdentifier to set
	 */
	public void setResourceIdentifier(long resourceIdentifier) {
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
