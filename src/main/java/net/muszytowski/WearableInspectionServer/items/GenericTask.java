package net.muszytowski.WearableInspectionServer.items;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
public abstract class GenericTask {
	@Id 
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long resourceIdentifier;
	
	@Size(min=2, max=255)
	@NotNull
	private String name;
	
	private String description;
	
	private String author;
	
	private Date date;
	
	private int weight;
	
	@ManyToOne
	@JsonBackReference
    private GenericTask parent;
	
	@OneToMany(mappedBy="resourceIdentifier",targetEntity=Attachment.class,
		       fetch=FetchType.EAGER)
	private List<Attachment> attachments;
	
	/**
	 * Empty constructor (POJO)
	 */
	public GenericTask(){}
	
	public GenericTask(String name, String description, String author, Date date, GenericTask parent){
		this.name = name;
		this.description = description;
		this.author = author;
		this.date = date;
		this.parent = parent;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the parent
	 */
	public GenericTask getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(GenericTask parent) {
		this.parent = parent;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
