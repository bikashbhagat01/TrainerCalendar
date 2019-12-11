package com.trainer;

import java.util.*;

public class TrainingManager {
	static int trainingId = 0; // Creates new Training IDs
	
	//  List of Training for each Integer Trainer ID
	
	private TreeMap<Integer, List<Training>> trainingMap;
	
	
	private static TrainingManager instance;
	
	static int getNextTrainingId() {
		return TrainingManager.trainingId++;
	}

	// Setters and Getters for Training map [Trainer ID, Training List]
	public void setTrainingMap(TreeMap<Integer, List<Training>> trainingMap) {
		this.trainingMap = trainingMap;
	}
	
	public TreeMap<Integer, List<Training>> getTrainingMap() {
		return trainingMap;
	}

	
	
	// Established Singleton Relationship
	
	private TrainingManager(){}
	
	static TrainingManager getInstance() {
		if (TrainingManager.instance != null) {
			return TrainingManager.instance;
		}
		TrainingManager tm = new TrainingManager();
		TreeMap<Integer,List<Training>> x = new TreeMap<Integer, List<Training>>();
		tm.setTrainingMap(x); //trainingMap for object created
		TrainingManager.instance = tm;
		return tm; // Instance of trainingMap returned as a Singleton object
	}
	
	
	Training addTraining(int trainerId, String courseName, String clientName, int cost,
			CDate date, String status, String payState, int duration){
		// Adding Training
		
		Training t = new Training();
		
		t.setTrainingId(TrainingManager.getNextTrainingId());
		t.setTrainerID(trainerId);
		t.setClientName(clientName);
		t.setCourseName(courseName);
		t.setCost(cost);
		t.setDate(date);
		t.setPayState(payState);
		t.setStatus(status);
		t.setDuration(duration);
		 
		if (this.trainingMap.containsKey(trainerId)) {
			this.trainingMap.get(trainerId).add(t);
		}
		else {
			List<Training> train = new ArrayList<Training>();
			train.add(t);
			this.trainingMap.put(trainerId, train);
		}
	
		return t;
	}
}
