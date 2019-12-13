# TrainerCalendar
A trainer Calendar Project to implement OOPs and SOLID Principles


#CDate - Class which defined state and behaviour of Date Entries.
#MACROS - Constant Class. Stores constants used by other classes.
#TrainerAction - Interface for actions which can be performed by trainer.
#Trainer - Class which implements TrainerAction Interface, and interacts with TrainingManager to perform operations on its Map.
#Training - Class containing information regarding each training entry
#TrainingManager -  Defines a Map of training lists identified by trainer ID [ the key ]. Can only have one instance [Singleton]. 
                    The Map acts as DB, where each key has a value [ Each Trainer has access to a list of Training entries for their TrainerID]
