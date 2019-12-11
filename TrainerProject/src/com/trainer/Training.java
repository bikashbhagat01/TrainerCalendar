package com.trainer;

public class Training implements Comparable<Training> {
	private int trainingId;
	private int trainerID;
	private String courseName;
	private String clientName;
	private double cost;
	private CDate date;
	private String status;
	private String payState;
	private int duration;
	
	
	private static int criteria;
	
	public int compareTo(Training cmp){

		switch(criteria){
		case MACROS.TRAININGIDBASE:
			return (int)(this.trainingId - cmp.getTrainingId());
		
		case MACROS.COURSEBASE:
			return (int)(this.courseName.compareToIgnoreCase(cmp.getCourseName()));
		
		case MACROS.CLIENTBASE:
			return (int) (this.clientName.compareToIgnoreCase(cmp.getClientName()));
			
		case MACROS.COSTBASE:
			return (int) (this.cost - cmp.getCost());
			
		case MACROS.STATUSBASE:
			return (int) (this.status.compareToIgnoreCase(cmp.getStatus()));
			
		case MACROS.PAYSTATEBASE:
			return (int) (this.payState.compareToIgnoreCase(cmp.getPayState()));
		
		case MACROS.DATEBASE:
			return (int)(this.date.compareTo(cmp.getDate()));

		case MACROS.DURATIONBASE:
			return (int)(this.duration - cmp.getDuration());
			
		default:
			return 0;
	}
}
	public String toString(){
		
		return "Training ID : " + trainingId + "| Trainer ID : " + trainerID + "| Course Name : " + courseName +
				"| Client Name : " + clientName + "| Cost : " + cost + "| Date : " + date + "| Status : " + status +
				"| PayState : " + payState + "| Duration : " + duration;
		
	}
	
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int t) {
		this.trainingId = t;
	}
	public int getTrainerID() {
		return trainerID;
	}
	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public CDate getDate() {
		return date;
	}
	public void setDate(CDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
	public static int getCriteria() {
		return criteria;
	}
	public static void setCriteria(int criteria) {
		Training.criteria = criteria;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
