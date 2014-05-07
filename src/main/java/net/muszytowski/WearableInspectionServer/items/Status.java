package net.muszytowski.WearableInspectionServer.items;

/**
 * Status beans for server return codes. 
 * 
 * Status objects should be used whenever an error occurs.
 * A standardized definition which maps a status onto an error
 * condition must be introduced.
 * 
 * @author Sebastian Muszytowski
 */
public class Status {

	private int code;
	private String message;
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Status(){}
	
	public Status(int code, String message){
		this.code = code;
		this.message = message;
	}
	
}
