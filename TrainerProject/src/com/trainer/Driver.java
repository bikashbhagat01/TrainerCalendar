package com.trainer;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Driver  {

	private Trainer trainer;

	static Scanner sc = new Scanner(System.in);

	public Driver() {
		this.trainer = new Trainer();
	}

	public Driver(int i) {
		this.trainer = new Trainer(i);
	}

	public Trainer getTrainer(){
		return this.trainer;
	}

	static void showMessage(String message) {
		System.out.println("========" + message + "=========");
	}

	static Map<String, SORT_TYPE> commandToSortMap = new HashMap<String, SORT_TYPE>() {
		{
			put("course", SORT_TYPE.COURSE_NAME);
			put("cost", SORT_TYPE.COST);
			put("date", SORT_TYPE.DATE);
			put("client", SORT_TYPE.CLIENT_NAME);
		}
	};

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

	public static void addTrack() {
		System.out.println("=======================================================================");
	}

	public void startMenu() {
		boolean exCode = false;
		CDate[] dates = {};
		String course = "", client;
		double cost;
		while (!exCode) {
			this.showMenu();
			addTrack();
			String choice = sc.next();
			addTrack();

			switch (choice.trim().toLowerCase()) {
				case "a":
					dates = getDates();
					if(dates.length == 0){
						break;
					}
					this.trainer.displayTrainingCount(dates[0], dates[1]);
					break;
				case "b":
					dates = getDates();
					if(dates.length == 0){
						break;
					}
					cost = this.trainer.getTotalCostOfTraining(dates[0], dates[1]);
					System.out.println("Total cost in duration is : " + cost);
					break;
				case "c":
					course = getCourse();
					cost = this.trainer.getTotalCostOfTraining(course);
					System.out.println("Total cost for course is : " + cost);
					break;
				case "d":
					course = getCourse();
					dates = getDates();
					if (dates.length == 0) {
						break;
					}
					this.trainer.displayTrainings(dates[0], dates[1], course);
					break;
				case "e":
					client = getClient();
					this.trainer.displayTrainingCount(client);
					break;

				case "f":
					this.trainer.displayCost(PAYMENT_STATE.DUE, TRAINING_STATUS.COMPLETED);
					break;
				case "g":
					String criteria = getCriteria();
					if(!commandToSortMap.containsKey(criteria)) {
						System.out.println("Incorrect criteria entered");
						break;
					}
					SORT_TYPE sort_type = commandToSortMap.get(criteria);
					this.trainer.displayTrainings(sort_type);
					break;
				case "h":
					this.trainer.displayTrainings(TRAINING_STATUS.PLANNED);
					break;
				case "i":
					course = getCourse();
					this.trainer.displayTrainings(TRAINING_STATUS.PLANNED, course);
					break;

			}

		}
	}



		
	public static void main(String[] args) {

		int trainerId = 45;
		Driver driver = new Driver(trainerId); // Driver instance returned where trainer ID is set
		driver.initiator();
		driver.startMenu();

	}

	Training.TrainingBuilder getBuilderForTraining(String courseName, String clientName, double cost, CDate d, TRAINING_STATUS status, PAYMENT_STATE payState, int duration) {
		Training.TrainingBuilder tb = new Training.TrainingBuilder();
		tb.setTrainerId(this.trainer.getId());
		tb.setDate(d);
		tb.setCourseDetail(clientName, courseName);
		tb.setCostAndDuration(cost, duration);
		tb.setStatuses(status, payState);
		return tb;
	}
	
	void initiator(){
		Training.TrainingBuilder tb1 = getBuilderForTraining ("SOLID", "Amazon", 50000, new CDate(1,12,2019),TRAINING_STATUS.PLANNED , PAYMENT_STATE.DUE, 6 );
		Training.TrainingBuilder tb2 = getBuilderForTraining("C++", "VISA", 45000, new CDate(10,7,2019),TRAINING_STATUS.CONFIRMED ,PAYMENT_STATE.DUE, 4);
		Training.TrainingBuilder tb3 = getBuilderForTraining("DataStructures", "Google", 76000, new CDate(14,2,2018), TRAINING_STATUS.CONFIRMED, PAYMENT_STATE.DUE,3 );
		Training.TrainingBuilder tb4 = getBuilderForTraining( "Java", "Flipkart", 29000, new CDate(24,11,2018), TRAINING_STATUS.COMPLETED, PAYMENT_STATE.RECEIVED, 4 );
		Training.TrainingBuilder tb5 = getBuilderForTraining( "C++", "wipro", 28000, new CDate(12,9,2019), TRAINING_STATUS.COMPLETED, PAYMENT_STATE.DUE, 2 );
		Training.TrainingBuilder tb6 = getBuilderForTraining( "DataStructures", "Google", 76000, new CDate(14,2,2018), TRAINING_STATUS.CONFIRMED, PAYMENT_STATE.DUE,3 );
		Training.TrainingBuilder tb7 = getBuilderForTraining( "Java", "Oracle", 21999, new CDate(2,2,2020),TRAINING_STATUS.PLANNED, PAYMENT_STATE.DUE, 4 );
		Training.TrainingBuilder tb8 = getBuilderForTraining( "Python", "Pentagon", 66000, new CDate(23,12,2019), TRAINING_STATUS.COMPLETED, PAYMENT_STATE.DUE, 2 );
		Training.TrainingBuilder tb9 = getBuilderForTraining( "C++", "Amazon", 44440, new CDate(12,8,2019), TRAINING_STATUS.COMPLETED, PAYMENT_STATE.RECEIVED,3 );
		Training.TrainingBuilder tb10 = getBuilderForTraining( "Java", "Apple", 88888, new CDate(27,11,2019), TRAINING_STATUS.COMPLETED, PAYMENT_STATE.DUE, 4 );
		Training.TrainingBuilder tb11 = getBuilderForTraining( "SOLID", "DELL-EMC", 33000, new CDate(30,12,2019), TRAINING_STATUS.PLANNED, PAYMENT_STATE.DUE, 2 );

		this.trainer.addTraining(tb1 );
		this.trainer.addTraining( tb2);
		this.trainer.addTraining( tb3);
		this.trainer.addTraining( tb4);
		this.trainer.addTraining( tb5);
		this.trainer.addTraining( tb6);
		this.trainer.addTraining( tb7);
		this.trainer.addTraining( tb8);
		this.trainer.addTraining( tb9);
		this.trainer.addTraining( tb10);
		this.trainer.addTraining( tb11);
	}
	

	
	CDate[] getDates(){
		CDate[] cDates = {};
		System.out.println("\n Date Formats :: \n dd/mm/yyyy or dd-mm-yyyy "
				+ "or dd:mm:yyyy \n dd/mm/yy or dd-mm-yy or dd:mm:yy\n");
		CDate start, end;

		try {
			System.out.println("Enter Start Date : ");
			start = new CDate(sc.next());
			System.out.println("Enter End Date : ");
			end = new CDate(sc.next());
		} catch (NumberFormatException e) {
			System.out.println("Invalid format");
			return cDates;
		}
		cDates = new CDate[]{start, end};
		return cDates;
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
