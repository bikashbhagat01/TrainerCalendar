package com.trainer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Training {
	private int id;
	private int trainerId;
	private double cost;
	private int duration;

	/* Tag  */
	private String courseName;
	private String clientName;

	/* Dates */
	private CDate date;

	/* Statuses */
	private TRAINING_STATUS status;
	private PAYMENT_STATE payState;

	public static Map<SORT_TYPE, Comparator<Training>> sortMap = new HashMap<SORT_TYPE, Comparator<Training>>() {{
		put(SORT_TYPE.PAYMENT_STATUS, new SortByPaymentState());
		put(SORT_TYPE.TRAINING_ID, new SortByTrainingId());
		put(SORT_TYPE.COURSE_NAME, new SortByCourseName());
		put(SORT_TYPE.CLIENT_NAME, new SortByClientName());
		put(SORT_TYPE.COST, new SortByClientName());
		put(SORT_TYPE.STATUS, new SortByStatus());
		put(SORT_TYPE.DATE, new SortByDate());
		put(SORT_TYPE.DURATION, new SortByDuration());
	}};

	/* Constructor */

	public Training (TrainingBuilder tb) {
		this.id = tb.id;
		this.trainerId = tb.trainerId;
		this.cost = tb.cost;
		this.duration = tb.duration;
		this.courseName = tb.courseName;
		this.clientName = tb.clientName;
		this.status = tb.status;
		this.payState = tb.payState;
		this.date = tb.date;
	}

	/* Builder Class */

	public static class TrainingBuilder {
		public int id;
		public int trainerId;
		public double cost;
		public int duration;
		public TRAINING_STATUS status;
		public PAYMENT_STATE payState;
		public CDate date;
		public String clientName;
		public String courseName;

		public TrainingBuilder setBasicInfo(int id) {
			this.id = id;
			return this;
		}

		public TrainingBuilder setTrainerId(int id){
			this.trainerId = id;
			return this;
		}

		public TrainingBuilder setCostAndDuration(double cost, int duration) {
			this.cost = cost;
			this.duration = duration;
			return this;
		}

		public TrainingBuilder setStatuses(TRAINING_STATUS training_status, PAYMENT_STATE payment_state) {
			this.status = training_status;
			this.payState = payment_state;
			return this;
		}

		public TrainingBuilder setCourseDetail(String clientName, String courseName) {
			this.clientName = clientName;
			this.courseName = courseName;
			return this;
		}

		public TrainingBuilder setDate(CDate date) {
			this.date = date;
			return this;
		}

	}

	public String toString(){

		return "Training ID : " + id + "| Trainer ID : " + trainerId + "| Course Name : " + courseName +
				"| Client Name : " + clientName + "| Cost : " + cost + "| Date : " + date + "| Status : " + status.getState() +
				"| PayState : " + payState.getState() + "| Duration : " + duration;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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

	public CDate getDate() {
		return date;
	}

	public void setDate(CDate date) {
		this.date = date;
	}

	public TRAINING_STATUS getStatus() {
		return status;
	}

	public void setStatus(TRAINING_STATUS status) {
		this.status = status;
	}

	public PAYMENT_STATE getPayState() {
		return payState;
	}

	public void setPayState(PAYMENT_STATE payState) {
		this.payState = payState;
	}
}
