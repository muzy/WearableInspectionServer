package net.muszytowski.WearableInspectionServer.Items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ListOption {

	@Id 
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long resourceIdentifier;
	private String value;
	
	public ListOption(){};
		
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	
	
}
