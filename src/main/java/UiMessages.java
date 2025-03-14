/**
 * this class contains the most common messages that appear throughout the code like initial greeting, exit message,
 * file creation, file creation error etc.
 * NOTE:- we do NOT include all text that is displayed on CLI because some print statements have strings +
 * information printed from other files to which UiMessages does not have direct access.
 * Ex: Many times we print the task info and to get the updated tasklist in this class would be more difficult than
 * excluding those print statements from this class and directly printing them from the class in which they are being
 * manipulated 
 */


public class UiMessages {

    //Messages in AJ
    public static void getInitialGreeting() {
        AJ.getDottedLine();
        System.out.println("Hi there! I'm AJ, always happy to help :) ");
        System.out.println("What's on your mind?");
        AJ.getDottedLine();
        System.out.println("PS:In case I don't see you later, good afternoon, good evening, and good night");
        AJ.getDottedLine();
    }

    public static void AJExitMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Bye,take care! May your device's battery never run out.");
        AJ.getDottedLine();
    }

    public static void RequestSerialNumber() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Sorry, I would need the serial number of the task");
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Please try again!");
    }

    public static void TaskUnmarkMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION +"Got it. No worries! you will do it soon.");
    }

    public static void TaskMarkMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION +"Let's gooo!! Keep up the productivity.");
    }

    public static void NotEnoughTaskMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION+"Mr. overachiever, you dont have that many tasks!, if only I could be like you");
    }

    public static void RequestPositiveSerialNumber() {
        System.out.println(AJ.AJ_TEXT_INDENTATION+"Sorry but that serial number was not recognised, please try again!");
        System.out.println(AJ.AJ_TEXT_INDENTATION+"Please try to input a non-zero positive serial number");
    }

    public static void WrongCommandInDefaultCase(){
        System.out.println(AJ.AJ_TEXT_INDENTATION + "That command could not be recognised " +
                "for this instance." );
        System.out.println(AJ.AJ_TEXT_INDENTATION+"Please try adding the task again. Thanks!");
    }

    public static void NoCommand(){
        System.out.println("No command to process....ouch :(");
    }


    //Messages in TaskList for storage
    public static void DirectoryCreation() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Directory 'UserData' has been created for you");
    }

    public static void FailedDirectoryCreation() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Failed to create 'UserData' directory.");
    }

    public static void FileCreation() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "I will also create a new file to save your tasks ;)");
        System.out.println(AJ.AJ_TEXT_INDENTATION + "You can access it via UserData -> SavedTasks.txt");
        System.out.println(AJ.DOTTED_LINE);
    }

    public static void FailedFileCreation() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Failed to create tasks file.");
    }


}
