package com.trainer;
import java.util.*;

public class Driver implements MACROS {

	private Trainer trainer;
	static Scanner sc = new Scanner(System.in);
	
	// Default Constructor
		public Driver() {
			// TODO Auto-generated constructor stub		
			this.trainer = new Trainer();

		} 
		
		// Parameterized Constructor
		public Driver(int i) {
			// TODO Auto-generated constructor stub
			this.trainer = new Trainer();
			this.setTrainer(i);
		}
		
		
		// Getters and Setters
		public Trainer getTrainer(){
			return this.trainer;
		}
		
		public  void setTrainer(int trainerID){
			
			this.trainer.setTrainerID(trainerID);
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println("Enter Trainer ID to proceed : ");
		
		int trainerID = sc.nextInt();
		
		
		// Trainer trainer = new Driver(trainerID).getTrainer(); // To get only trainer Instance
		
		Driver driver = new Driver(trainerID); // Driver instance returned
		Trainer trainer = driver.getTrainer();
		String choice;
		CDate[] dateArray;
		String course;
		String client;
		String sortCriteria;
		
		System.out.println("Set -> Trainer ID : " + trainer.getTrainerID());
		
		trainer = driver.initiator();
		
		System.out.println("\n Launched Training Data Initiator \n ");
		
		boolean exCode = false;
		
		
		
		while(exCode == false){
			
			driver.showMenu();
			choice = sc.next().trim().toLowerCase();

			switch(choice){
			
			
			case "a":	
				
				dateArray = driver.getDates();
				System.out.println("Count of Training within dates - " + dateArray[0] + " & " + dateArray[1]);
				System.out.println(trainer.getTrainingCountWithinDates(dateArray[0], dateArray[1]));
				
				break;
				
			case "b":
				dateArray = driver.getDates();
				System.out.println(trainer.getTotalCostOfTrainingWithinDates(dateArray[0], dateArray[1]));
				
				break;
				
			case "c":
				course = driver.getCourse();
				System.out.println("Total Cost of training for technology : " + course);
				System.out.println(trainer.getTotalCostOfTrainingWithCourseName(course));
				break;
				
			case "d":
				dateArray = driver.getDates();
				course = driver.getCourse();
				trainer.displayTrainingInfoWithinDates(dateArray[0], dateArray[1], course);
				break;
				/*
				void displayPlannedTrainings(String courseName);
				*/
			case "e":
				client = driver.getClient();
				trainer.displayTotalCountOfTrainingsForClient(client);
				break;
				
			case "f":
				trainer.displayPendingCostOnCompletedTrainings();
				break;
				
			case "g":
				sortCriteria = driver.getCriteria();
				trainer.sortAllTrainings(sortCriteria);
				break;
				
			case "h":
				trainer.displayPlannedTrainings();
				break;
				
			case "i":
				course = driver.getCourse();
				trainer.displayPlannedTrainings(course);
				break;
			
			case "q":
				exCode = true;
				break;
				
			default:
				System.out.println("Incorrect Option Entered ");
				break;
				
			}
		}
		
		System.out.println(" Application Exit Success. ");
	
	}
	
	Trainer initiator(){

		this.trainer.addTraining( "C++", "wipro", 28000, new CDate(12,9,2019),CONFIRMED ,DUE, 4);
		this.trainer.addTraining( "SOLID", "Amazon", 50000, new CDate(1,12,2019),PLANNED , DUE, 6 );
		this.trainer.addTraining( "DataStructures", "Google", 76000, new CDate(14,2,2018), CONFIRMED, DUE,3 );
		this.trainer.addTraining( "Java", "Flipkart", 29000, new CDate(24,11,2018), COMPLETED, RECEIVED, 4 );
		this.trainer.addTraining( "C++", "wipro", 28000, new CDate(12,9,2019), COMPLETED, DUE, 2 );
		
		this.trainer.addTraining( "Data Structures", "Google", 76000, new CDate(14,2,2018), CONFIRMED, DUE,3 );
		this.trainer.addTraining( "Java", "Oracle", 21999, new CDate(2,2,2020), PLANNED, DUE, 4 );
		this.trainer.addTraining( "Python", "Pentagon", 66000, new CDate(23,12,2019), COMPLETED, DUE, 2 );
		
		this.trainer.addTraining( "C++", "Amazon", 44440, new CDate(12,8,2019), COMPLETED, RECEIVED,3 );
		this.trainer.addTraining( "Java", "Apple", 88888, new CDate(27,11,2019), COMPLETED, DUE, 4 );
		this.trainer.addTraining( "SOLID", "DELL-EMC", 33000, new CDate(30,12,2019), PLANNED, DUE, 2 );
		
		return trainer;
	}
	
	void showMenu(){
		
		System.out.println("\n Welcome Trainer : \n [You may enter below commands]\n");
		System.out.println("-------------------------------------------------------");
		System.out.println("A. Display how many trainings were delivered within certain duration");
		System.out.println("B. Display cost of trainings within a certain duration");
		System.out.println("C. Display total cost of trainings related to a specific technology");
		System.out.println("D. Display all training information of a particular technology within a certain duration ");
		System.out.println("E. Display total no. (count only) of trainings conducted for a client");
		System.out.println("F. Display total cost of trainings that have completed but not paid yet.");
		System.out.println("G. Sorted list of all trainings based on CourseName, cost or date.");
		System.out.println("H. Display a list of planned trainings irrespective of the technology");
		System.out.println("I. Display a list of planned trainings for a specific technology");
		
		System.out.println("Q. Quit ");
	}
	
	CDate[] getDates(){
		
		System.out.println("Date Format : dd/mm/yyyy | 04/09/2019");
		System.out.println("Enter Start Date : ");
		CDate start = new CDate(sc.next());
		System.out.println("Enter End Date : ");
		CDate end = new CDate(sc.next());
		
		CDate[] dArr = {start,end};
		
		return dArr;
		
	}
	
	String getCourse(){
		System.out.println("Enter CourseName");
		String c = sc.next();
		return c;
	}
	
	String getClient(){
		System.out.println("Enter ClientName");
		String c = sc.next();
		return c;
	}
	
	String getCriteria(){
		System.out.println("Enter Criteria without [] brackets");
		System.out.println("Available criteria - [course] | [date] | [cost] | [duration] | [client]");
		String c = sc.next();
		return c;
	}
	
	
} // End of Driver Class
