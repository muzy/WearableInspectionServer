package net.muszytowski.WearableInspectionServer.Items;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
public class Task extends GenericTask{
	
	@OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
	private Collection<GenericTask> children;
			
}
