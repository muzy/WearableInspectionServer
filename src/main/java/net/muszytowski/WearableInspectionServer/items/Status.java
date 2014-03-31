package net.muszytowski.WearableInspectionServer.items;


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
