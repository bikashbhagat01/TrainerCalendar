package com.trainer;

enum SORT_TYPE {
	TRAINING_ID,
	COURSE_NAME,
	CLIENT_NAME,
	COST,
	STATUS,
	PAYMENT_STATUS,
	DATE,
	DURATION
}
enum PAYMENT_STATE {
	DUE("DUE"), RECEIVED("RECEIVED");
	private String state;

	public String getState(){
		return this.state;
	}

	PAYMENT_STATE(String s){
		this.state = s;
	}
}

enum TRAINING_STATUS {
	PLANNED("PLANNED"),
	CONFIRMED("CONFIRMED"),
	COMPLETED("COMPLETED");

	private String state;

	public String getState(){
		return this.state;
	}

	TRAINING_STATUS(String s){
		this.state = s;
	}
}