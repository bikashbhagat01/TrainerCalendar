package com.trainer;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Driver  {

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
			this.trainer = new Trainer(i);
			//this.trainer.setTrainerID(i);
		}
		
		// Getters and Setters
		public Trainer getTrainer(){
			return this.trainer;
		}
		
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println("Enter Trainer ID [ INTEGER ] to proceed : ");
		
		int trainerID = sc.nextInt();
		
				
		Driver driver = new Driver(trainerID); // Driver instance returned where trainer ID is set
		
		String choice; 	CDate[] dateArray; 	String course; 	String client; 	String sortCriteria;
		
		System.out.println("Set -> Trainer ID : " + driver.trainer.getTrainerID());
		
		driver.initiator(); // Initiated Default values on trainer -> TrainingMap -> Trainer's list in Map
		
		System.out.println("\nLaunched Training Data Initiator \n ");
		
		boolean exCode = false;
		
		System.out.println("\n Welcome Trainer : ");
		
		int lever = 0;
		
		while(exCode == false){
			
			driver.loadScreen();

			driver.showMenu();
			choice = sc.next().trim().toLowerCase();
			
			driver.lineSpace();


			switch(choice){
			
			case "a":	
				
				dateArray = driver.getDates();
				System.out.println("Count of Training within dates - " + dateArray[0] + " & " + dateArray[1]);
				driver.lineSpace();

				System.out.println(driver.trainer.getTrainingCountWithinDates(dateArray[0], dateArray[1]));

				break;
				
			case "b":
				dateArray = driver.getDates();
				driver.lineSpace();

				System.out.println(driver.trainer.getTotalCostOfTrainingWithinDates(dateArray[0], dateArray[1]));

				break;
				
			case "c":
				course = driver.getCourse();

				System.out.println("Total Cost of training for technology : " + course);
				driver.lineSpace();

				System.out.println(driver.trainer.getTotalCostOfTrainingWithCourseName(course));

				break;
				
			case "d":
				dateArray = driver.getDates();
				driver.lineSpace();

				course = driver.getCourse();
				driver.lineSpace();

				driver.trainer.displayTrainingInfoWithinDates(dateArray[0], dateArray[1], course);

				break;
				
			case "e":
				client = driver.getClient();
				driver.lineSpace();

				driver.trainer.displayTotalCountOfTrainingsForClient(client);

				break;
				
			case "f":
				driver.lineSpace();

				driver.trainer.displayPendingCostOnCompletedTrainings();

				break;
				
			case "g":
				sortCriteria = driver.getCriteria();
				driver.lineSpace();

				driver.trainer.sortAllTrainings(sortCriteria);

				break;
				
			case "h":

				driver.trainer.displayPlannedTrainings();

				driver.lineSpace();

				break;
				
			case "i":
				course = driver.getCourse();
				driver.lineSpace();

				driver.trainer.displayPlannedTrainings(course);

				break;
			
			case "q":
				exCode = true;
				driver.lineSpace();

				break;
				
			default:
				System.out.println("Incorrect Option Entered ");
				break;
				
			}
			driver.lineSpace();

		}
		
		System.out.println(" Application Exit Success. ");
	
	}
	
	void initiator(){

		this.trainer.addTraining( "C++", "VISA", 45000, new CDate(10,7,2019),MACROS.CONFIRMED ,MACROS.DUE, 4);
		this.trainer.addTraining( "SOLID", "Amazon", 50000, new CDate(1,12,2019),MACROS.PLANNED , MACROS.DUE, 6 );
		this.trainer.addTraining( "DataStructures", "Google", 76000, new CDate(14,2,2018), MACROS.CONFIRMED, MACROS.DUE,3 );
		this.trainer.addTraining( "Java", "Flipkart", 29000, new CDate(24,11,2018), MACROS.COMPLETED, MACROS.RECEIVED, 4 );
		
		this.trainer.addTraining( "C++", "wipro", 28000, new CDate(12,9,2019), MACROS.COMPLETED, MACROS.DUE, 2 );
		
		this.trainer.addTraining( "DataStructures", "Google", 76000, new CDate(14,2,2018), MACROS.CONFIRMED, MACROS.DUE,3 );
		this.trainer.addTraining( "Java", "Oracle", 21999, new CDate(2,2,2020), MACROS.PLANNED, MACROS.DUE, 4 );
		this.trainer.addTraining( "Python", "Pentagon", 66000, new CDate(23,12,2019), MACROS.COMPLETED, MACROS.DUE, 2 );
		
		this.trainer.addTraining( "C++", "Amazon", 44440, new CDate(12,8,2019), MACROS.COMPLETED, MACROS.RECEIVED,3 );
		this.trainer.addTraining( "Java", "Apple", 88888, new CDate(27,11,2019), MACROS.COMPLETED, MACROS.DUE, 4 );
		this.trainer.addTraining( "SOLID", "DELL-EMC", 33000, new CDate(30,12,2019), MACROS.PLANNED, MACROS.DUE, 2 );
		
	}
	
	void showMenu(){
		
		System.out.println("\n \n     [You may enter below commands]");
		System.out.println("-------------------------------------------------------\n");
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
		
		System.out.println("\n Date Formats :: \n dd/mm/yyyy or dd-mm-yyyy "
				+ "or dd:mm:yyyy \n dd/mm/yy or dd-mm-yy or dd:mm:yy\n");
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
	
	void loadScreen(){
		int del = 0;
		while(del !=8){
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int k = del;
			while(k!=0){
			System.out.print("....");
			k--;
			}
			del++;
		}
	}
	
	void lineSpace(){
		System.out.println();
	}
	
	
} // End of Driver Class
