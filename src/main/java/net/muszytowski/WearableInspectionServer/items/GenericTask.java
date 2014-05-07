package net.muszytowski.WearableInspectionServer.items;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


/**
 * Generic Task bean with attributes that every task
 * should have.
 * @author Sebastian Muszytowski
 *
 */
@Entity
@Table(name = "Tasks")
@JsonTypeInfo(use=com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include=As.PROPERTY, property="class")
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class GenericTask {
	@Id 
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long resourceIdentifier;
	
	@Column(updatable = false, insertable = false)
	private int type;
	
	@Size(min=2, max=255)
	@NotNull
	private String name;
	
	private String description;
	
	private String author;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="UTC")
	private Date date;
	
	private int weight;
	
	private Long testExecution;
		
	@OneToMany(mappedBy="resourceIdentifier",targetEntity=Attachment.class,
		       fetch=FetchType.EAGER)
	private List<Attachment> attachments;
	
	/**
	 * Empty constructor (POJO)
	 */
	public GenericTask(){}
	
	public GenericTask(String name, String description, String author, Date date){
		this.name = name;
		this.description = description;
		this.author = author;
		this.date = date;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Long getTestExecution() {
		return testExecution;
	}

	public void setTestExecution(Long testExecution) {
		this.testExecution = testExecution;
	}
}
