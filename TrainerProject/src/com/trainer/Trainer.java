package com.trainer;
import java.util.*;

public class Trainer implements TrainerAction{
	
	private TrainingManager trainingManager;
	private int trainerID;
	private List<Training> trainingList;
	
	
	
	// Received instance from Training Manager
	Trainer() {
		this.trainingManager = TrainingManager.getInstance();
		this.trainingList = trainingManager.getTrainingMap().get(trainerID);

	}

	/*
	Trainer(int tid) {
		this.trainingManager = TrainingManager.getInstance();
		this.trainerID = tid;
		this.trainingList = trainingManager.getTrainingMap().get(trainerID);
	} */

	
	
	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public List<Training> getTrainingList() {
		return trainingList;
	}

	public void setTrainingList(int trainerID) {
		this.trainingList = trainingManager.getTrainingMap().get(trainerID);
	}

	

	@Override
	public int getTrainingCountWithinDates(CDate start, CDate end) {
		// TODO Auto-generated method stub
			int countOfTrainings = 0;
		for (Training tEntry : this.trainingList){
			
			boolean flagStart = tEntry.getDate().compareTo(start) >= 0; //Checks if current date is greater than start or not
			boolean flagEnd = tEntry.getDate().compareTo(end) <= 0; //Checks if current date is less than end date or not
			
			if(flagStart && flagEnd){
				countOfTrainings++;
			}
		}
		return countOfTrainings;
		
	}
	

	@Override
	public double getTotalCostOfTrainingWithinDates(CDate start, CDate end) {
		// TODO Auto-generated method stub
			
			double costOfTrainings = 0;
			
			for (Training tEntry : trainingList){
			
			boolean flagStart = tEntry.getDate().compareTo(start) >= 0; //Checks if current date is greater than start or not
			boolean flagEnd = tEntry.getDate().compareTo(end) <= 0; //Checks if current date is less than end date or not
			
			if(flagStart && flagEnd){
				costOfTrainings += tEntry.getCost();
			}
		}
		return costOfTrainings;
	}

	@Override
	public double getTotalCostOfTrainingWithCourseName(String courseName) {
		// TODO Auto-generated method stub
		double costOfTrainings = 0;
		
		for (Training tEntry : trainingList){
		
		if(tEntry.getCourseName().equalsIgnoreCase(courseName)){
			costOfTrainings += tEntry.getCost();
		}
	}
	return costOfTrainings;
}

	@Override
	public void displayTrainingInfoWithinDates(CDate start, CDate end, String course) {
		// TODO Auto-generated method stub
			
		System.out.println("Trainings between " + start + " and " + end + "\n");
		
		boolean nFlag = false;
		
		for (Training tEntry : trainingList){
		
		boolean flagStart = tEntry.getDate().compareTo(start) >= 0; //Checks if current date is greater than start or not
		boolean flagEnd = tEntry.getDate().compareTo(end) <= 0; //Checks if current date is less than end date or not
		
		if(flagStart && flagEnd && tEntry.getCourseName().equalsIgnoreCase(course.trim())){
			System.out.println(tEntry + "\n");
			nFlag = true;
		}
	}
		if(!nFlag)
			System.out.println("No Results found!");
}

	@Override
	public void displayTotalCountOfTrainingsForClient(String client) {
		// TODO Auto-generated method stub
		int countOfTraining = 0;
		
		for (Training tEntry : trainingList){
		
		if(tEntry.getClientName().equalsIgnoreCase(client)){
			countOfTraining++;
		}
	}
			System.out.println("Total count of Trainings done for Client : "+ client + " is : " + countOfTraining);
	}

	@Override
	public void displayPendingCostOnCompletedTrainings() {
		// TODO Auto-generated method stub
		
		double pendingCostOnCompletedTrainings = 0;
		
		for (Training tEntry : trainingList){
			
			if(tEntry.getStatus().equalsIgnoreCase(MACROS.COMPLETED) && tEntry.getPayState().equalsIgnoreCase(MACROS.DUE))
				pendingCostOnCompletedTrainings += tEntry.getCost();
		}
		
		System.out.println("Total Payement due ton Completed Trainings : " + pendingCostOnCompletedTrainings);
	}

	@Override
	public void sortAllTrainings(String criteria) {
		// TODO Auto-generated method stub
		// Use Collections.Sort Library to implement sorting based on criteria as set on constants.
		// CompareTo defined in Training Class
		// Use Switch Case
					
			String criteriaFlag = criteria.toLowerCase().trim();
			
			
				switch(criteriaFlag){
				case "trainingid":
					Training.setCriteria(MACROS.TRAININGIDBASE);
					break;
					
				case "course":
					Training.setCriteria(MACROS.COURSEBASE);
					break;
					
				case "client":
					Training.setCriteria(MACROS.CLIENTBASE);
					break;
					
				case "cost":
					Training.setCriteria(MACROS.COSTBASE);
					break;
					
				case "status":
					Training.setCriteria(MACROS.STATUSBASE);
					break;
					
				case "payementstatus":
					Training.setCriteria(MACROS.PAYSTATEBASE);
					break;
					
				case "date":
					Training.setCriteria(MACROS.DATEBASE);
					break;
					
				case "duration":
					Training.setCriteria(MACROS.DURATIONBASE);
					break;
					
				default:
					System.out.println("Previous criteria remains as incorrect criteria entered ");
					break;
			}
		
		System.out.println("Sorted Based on Criteria : " + Training.getCriteria() + " | " + criteriaFlag);
			
		Collections.sort(trainingList);
		
		for(Training tEntry : trainingList){
			
			System.out.println(tEntry + "\n");
			
		}
		
	}

	@Override
	public void displayPlannedTrainings() {
		// TODO Auto-generated method stub
		
		boolean pFlag = false;
		
		for (Training tEntry : trainingList){
			
			if(tEntry.getStatus().equalsIgnoreCase(MACROS.PLANNED)){
					System.out.println(tEntry + "\n");
					pFlag = true;
			}
		}
		
		if(!pFlag)
			System.out.println("No Planned Training Found!!!");
	}

	@Override
	public void displayPlannedTrainings(String courseName) {
		// TODO Auto-generated method stub
		
		boolean pFlag = false;
		
		for (Training tEntry : trainingList){
			
			if(tEntry.getStatus().equalsIgnoreCase(MACROS.PLANNED) && tEntry.getClientName().equalsIgnoreCase(courseName)){
					System.out.println(tEntry + "\n");
					pFlag = true;
			}
		}
		
		if(!pFlag)
			System.out.println("No Planned Training Found for course : " + courseName);
		
	}

	@Override
	public void addTraining(String courseName, String clientName, int cost,
			CDate date, String status, String payState, int duration) {
		// TODO Auto-generated method stub
		
		this.trainingManager.addTraining(this.trainerID, courseName, clientName, cost, date, status, payState, duration);
		
	}	
	
}
