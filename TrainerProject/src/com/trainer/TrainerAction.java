package com.trainer;

// Interface to Implement all Actions that a Trainer can take on their calendar
public interface TrainerAction {
	int getTrainingCountWithinDates(CDate start, CDate end);
	double getTotalCostOfTrainingWithinDates(CDate start, CDate end);
	double getTotalCostOfTrainingWithCourseName(String courseName);
	void displayTrainingInfoWithinDates(CDate start, CDate end, String course);
	void displayTotalCountOfTrainingsForClient(String client);
	void displayPendingCostOnCompletedTrainings();
	void sortAllTrainings(String criteria);
	void displayPlannedTrainings();
	void displayPlannedTrainings(String courseName);
	void addTraining(String courseName, String clientName, int cost, CDate date, String status, String payState, int duration);
}




/*1. Display how many trainings were delivered in a certain duration (e.g. 3
months)
2. Display cost of trainings within a certain duration (e.g. income per month or
6 months)
3. Display total cost of trainings related to a specific technology (e.g. all C++
trainings)
4. Display all trainings of a particular technology within a certain duration (e.g.
all Java trainings between April & July
5. Display total no. (count only) of trainings conducted for a client (irrespective
of the technology)
6. Display total cost of trainings that have completed but not paid yet.
7. Sort all trainings based on name, cost & date.
8. Display a list of planned trainings irrespective of the technology
9. Display a list of planned trainings for a specific technology
Every training will be identified through a unique no that will be generated
automatically.
*/