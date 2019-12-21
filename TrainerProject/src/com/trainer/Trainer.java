package com.trainer;
import java.util.*;

public class Trainer implements TrainerAction{

	private int id;
	private TrainingManager tm;

	/* Constructor */

	Trainer() {
		this.tm = TrainingManager.getInstance();
	}

	Trainer(int tid) {
		this.id = tid;
		this.tm = TrainingManager.getInstance();
	}

	/* Getter and Setter Methods */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/* Member Methods */

	public List<Training> getMyTrainingList(){
		return this.tm.getTrainingMap().get(this.id);
	}


	@Override
	public double getTotalCostOfTraining(CDate start, CDate end) {
		List<Training> trainings = this.getMyTrainingList();
		double totalCost = 0;
		for (Training training: trainings) {
			CDate tDate = training.getDate();
			if(tDate.compareTo(start) >= 0 && tDate.compareTo(end) <= 0) {
				totalCost += training.getCost();
			}
		}
		return totalCost;
	}

	@Override
	public double getTotalCostOfTraining(String courseName) {
		List<Training> trainings = this.getMyTrainingList();
		double totalCost = 0;
		for (Training training: trainings) {
			if(training.getCourseName().equalsIgnoreCase(courseName)){
				totalCost += training.getCost();
			}
		}
		return totalCost;
	}

	@Override
	public void displayTrainings(TRAINING_STATUS state) {
		List<Training> trainings = this.getMyTrainingList();
		boolean isFound = false;
		for (Training training: trainings) {
			if(training.getStatus() == state) {
				isFound = true;
				System.out.println(training);
			}
		}

		if(!isFound) {
			System.out.println("No trainings found");
		}

	}

	@Override
	public void displayTrainings(TRAINING_STATUS state, String courseName) {
		List<Training> trainings = this.getMyTrainingList();
		boolean isFound = false;
		for (Training training: trainings) {
			if(training.getStatus() == state && training.getCourseName().equalsIgnoreCase(courseName)){
				isFound = true;
				System.out.println(training);
			}
		}
		if (!isFound) {
			System.out.println("No trainings found");
		}
	}

	@Override
	public void displayTrainings(CDate start, CDate end, String courseName) {
		List<Training> trainings = this.getMyTrainingList();
		boolean isFound = false;
		for (Training training: trainings) {
			CDate date = training.getDate();
			boolean isInRange = date.compareTo(start) >= 0 && date.compareTo(end) <= 0;
			boolean isCourseMatched = training.getCourseName().equalsIgnoreCase(courseName);

			if(isInRange && isCourseMatched) {
				isFound = true;
				System.out.println(training);
			}
		}

		if (!isFound) {
			System.out.println("Training not found");
		}
	}

	@Override
	public void displayTrainings(SORT_TYPE sortType) {

	}

	@Override
	public void displayTrainingCount(CDate start, CDate end) {
		List<Training> trainings = this.getMyTrainingList();
		int trainingCount = 0;
		for (Training training: trainings) {
			CDate date = training.getDate();
			boolean isInRange = date.compareTo(start) >= 0 && date.compareTo(end) <=0;
			if (isInRange) {
				trainingCount++;
			}
		}

		System.out.println("Training count for dates are: " + trainingCount);
	}

	@Override
	public void displayTrainingCount(String client) {
		List<Training> trainings = this.getMyTrainingList();
		int trainingCount = 0;
		for (Training training: trainings) {
			if(training.getClientName().equalsIgnoreCase(client)){
				trainingCount++;
			}
		}

		System.out.println("Training count for client are: " + trainingCount);
	}

	@Override
	public void displayTrainingCount() {
		List<Training> trainings = this.getMyTrainingList();

		System.out.println("Total trainings are: " + trainings.size());
	}

	@Override
	public void displayCost(PAYMENT_STATE payState, TRAINING_STATUS trainingStatus) {
		List<Training> trainings = this.getMyTrainingList();
		double totalCost = 0;
		for (Training training: trainings) {
			if (training.getPayState() == payState && training.getStatus() == trainingStatus) {
				totalCost += training.getCost();
			}
		}

		System.out.println("Total Cost for states: " + totalCost);
	}

	@Override
	public void addTraining(Training.TrainingBuilder tb) {
		tb.setTrainerId(this.id);
		this.tm.addTraining(tb);
	}
}
