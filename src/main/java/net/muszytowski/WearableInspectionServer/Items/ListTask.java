package net.muszytowski.WearableInspectionServer.Items;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.mapping.Collection;

@Entity
public class ListTask extends GenericTask {

	@OneToOne(optional=true)
    @JoinColumn(name = "option") 
	private long value;
	
	@OneToMany(mappedBy="option",targetEntity=ListOption.class,
		       fetch=FetchType.EAGER)
	private Collection options;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
	
}
