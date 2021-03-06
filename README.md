# TrainerCalendar
A Trainer Calendar Manager which implement OOPs and SOLID Principles


# CDate - 
Class which defined state and behaviour of Date Entries. No Validation , as of now.
# MACROS - 
Set of Enum Classes. Stores constants used by other classes.
# TrainerAction - 
Interface for actions which can be performed by trainer.
# Trainer - 
Class which implements TrainerAction Interface, and interacts with TrainingManager to perform operations on its Map.
# Training - 
Class containing information regarding each training entry. Kind of like, POJO
# TrainingManager - 
Acts as a DB.
Defines a Map of training lists identified by trainer ID [ the key ]. Can only have one instance [Singleton]. 
Uses Map of Lists. [ Each Trainer has access to a list of Training entries for their TrainerID]
# Driver -
Application is run using the instance of a trainer defined in driver.


# Problem Statement : Training Calendar

Create a training calendar for trainers. The application will be used to store
information about upcoming trainings, their cost, clients, etc. It will help the
trainers manage their trainings from different sources.

After the training is over, the trainer will mark the training as complete.


The trainer will be able to perform the following operations:
1. Display how many trainings were delivered in a certain duration (e.g. 3
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

Important Points
1. Date is in the format dd/mm/yyyy 
2. For date, use the following class and add any missing features that are
required for the program. Assume all dates are valid dates, so validation code
is not required.
class Date{
int m_Day;
int m_Month ;
int m_Year ;
public:
Constructor
Other necessary member functions
3. No need to write code for accepting user input. You may specify hardcoded
values as input in the code. Changing the input values should give valid
results.
Example output:

You can display in any form you want.
Note: Usage of Collection is encouraged.
