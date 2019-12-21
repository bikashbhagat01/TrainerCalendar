package com.trainer;

// Interface to Implement all Actions that a Trainer can take on their calendar
public interface TrainerAction {

	/* Get total cost */
	double getTotalCostOfTraining(CDate start, CDate end);
	double getTotalCostOfTraining(String courseName);

	/* Displays training based on different criteria */
	void displayTrainings(TRAINING_STATUS state);
	void displayTrainings(TRAINING_STATUS state, String courseName);
	void displayTrainings(CDate start, CDate end, String courseName);
	void displayTrainings(SORT_TYPE sorType);

	/* Count training with different parameters */
	void displayTrainingCount(CDate start, CDate end);
	void displayTrainingCount(String client);
	void displayTrainingCount();

	/* Display total cost */
	void displayCost(PAYMENT_STATE payState, TRAINING_STATUS trainingStatus);


	/* dekhte h */
	void addTraining(Training.TrainingBuilder tb);
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