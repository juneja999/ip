import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;



public class AJ {
    
    public final static String DOTTED_LINE="***********************(^‿^)***************************";
    public final static String AJ_TEXT_INDENTATION = " ".repeat(7);
    //to provide indentation when bot replies


    //used to segregate user and bot text
    public static void getDottedLine(){
        System.out.println(DOTTED_LINE+"\n");
    }


    public static void main(String[] args) {

        UiMessages.getInitialGreeting();

        TaskList taskList = new TaskList();

        int defaultCaseTurn =0; //used in the default case when task type not identified



        while(true){
            String userCommand = UserCommands.getUserCommand(); //string version

            Task task = new Task(userCommand); // Task version


            getDottedLine(); //the upper dotted line

            if(userCommand.equals("bye")){
                UiMessages.AJExitMessage();
                taskList.GetSaveTasksToFile();
                //save the updated file once the user has exited
                break;
            }else if(userCommand.equals("list")){
                taskList.printTaskList();
//                    //the taskList has a protected attribute taskList(mention in file TaskList,
//                    // I'm accessing the index of that attribute)
//
            }else{
                String[] userCommandSplitArray = Parser.userCommandParser(userCommand.split(" "));
                // array containing only user words, no whitespaces
                //to tackle edge cases - when extra white spaces between words
                String targetWord = userCommandSplitArray[0].toLowerCase();
                if(defaultCaseTurn==1){targetWord="make sure user doesnt put in mark/unmark etc at this stage";}

                switch (targetWord.toLowerCase()){ //<------feature
                case "mark":
                case "unmark":
                    int taskListIndex = 0;
                    try {
                        taskListIndex = Integer.parseInt(userCommandSplitArray[1]) - 1;
                        //because we had shifted +1 when writing
                    } catch (NumberFormatException e) {
                        UiMessages.RequestSerialNumber();
                        break;
                    }
                    try {
                        taskList.toggleTasks(taskListIndex, targetWord.toLowerCase().equals("unmark") ? false : true);
                        if(targetWord.toLowerCase().equals("unmark")){
                            UiMessages.TaskUnmarkMessage();
                            System.out.println(AJ_TEXT_INDENTATION + "I have unmarked: "+ "["+taskList.taskList.get(taskListIndex).taskTypeChar+"] "
                                    +taskList.taskList.get(taskListIndex).taskDescription);
                            // taskList.taskList because I gave the same name in this file and TaskList file
                        }else{ //in the above line, .taskDescription gives the name, otherwise we get memory address
                            UiMessages.TaskMarkMessage();
                            System.out.println(AJ_TEXT_INDENTATION +"I have marked: " +"["+taskList.taskList.get(taskListIndex).taskTypeChar+"] "
                                    + taskList.taskList.get(taskListIndex).taskDescription);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        if(taskListIndex >=0){
                            UiMessages.NotEnoughTaskMessage();
                        }else{
                            UiMessages.RequestPositiveSerialNumber();
                        }
                    }
                    break;

                case "delete":
                    int indexToBeDeleted=0;
                    try{
                        indexToBeDeleted = Integer.parseInt(userCommandSplitArray[1]) - 1;
                        if((taskList.getSize()>= indexToBeDeleted+1) && (indexToBeDeleted > -1)){
                            System.out.println(AJ_TEXT_INDENTATION+"Okay, no problem! ;)");
                        }
                        //this if statement insures that if user inputs index out of bounds the above statement is not
                        //printed , because that catch is will be triggered in the below line
                        System.out.println(AJ_TEXT_INDENTATION+"I have \"avada kedavra'd\": "
                                +"["+taskList.taskList.get(indexToBeDeleted).taskTypeChar+"] "+
                                taskList.taskList.get(indexToBeDeleted).taskDescription);
                        taskList.taskList.remove(indexToBeDeleted);
                    }catch(IndexOutOfBoundsException e){
                        if(indexToBeDeleted >=0){
                            UiMessages.NotEnoughTaskMessage();
                        }else{
                            UiMessages.RequestPositiveSerialNumber();
                        }
                    }catch(NumberFormatException e){
                        UiMessages.RequestSerialNumber();
                    }
                    break;

                case "todo":
                    ToDos taskToDos = new ToDos(userCommand);
                    taskList.addTask(taskToDos);
                    System.out.println(AJ_TEXT_INDENTATION + "Done!, added: " + taskToDos.getTaskInfo());
                    break;

                case "deadline":
                    Deadlines taskDeadlines = new Deadlines(Deadlines.getDeadlinesData(userCommandSplitArray)[0],
                            Deadlines.getDeadlinesData(userCommandSplitArray)[1] );
                    taskList.addTask(taskDeadlines);
                    System.out.println(AJ_TEXT_INDENTATION + "Done!, added: " + taskDeadlines.getTaskInfo());
                    break;

                case "event":
                    Events taskEvents = new Events(Events.getEventsData(userCommandSplitArray)[0],
                            Events.getEventsData(userCommandSplitArray)[1],
                            Events.getEventsData(userCommandSplitArray)[2] );
                    taskList.addTask(taskEvents);
                    System.out.println(AJ_TEXT_INDENTATION + "Done!, added: " + taskEvents.getTaskInfo());
                    break;

                default: //if user doesn't mention any of  the above

                    if(defaultCaseTurn == 0){
                        AJExceptions.taskTypeNotFound(userCommand);
                        ToDos tempDefaultCase = new ToDos(userCommand);
                        taskList.addTask(tempDefaultCase);
                        defaultCaseTurn = 1;
                    }else{
                        if(userCommand.equals("yes")){
                            System.out.println(AJ_TEXT_INDENTATION + "Done!, added: "+
                                    taskList.taskList.get(taskList.getSize()-1).getTaskInfo());
                            //taskList has its own taskList(from class TaskList)
                        } else if (userCommand.equals("no")) {
                            System.out.println(AJ_TEXT_INDENTATION + "Okay, got it boss!");
                            taskList.removeTask(taskList.getSize()-1);
                        }else{
                            System.out.println(AJ_TEXT_INDENTATION + "That command could not be recognised " +
                                    "for this instance." );
                            System.out.println(AJ.AJ_TEXT_INDENTATION+"Please try adding the task again. Thanks!");
                            taskList.removeTask(taskList.getSize()-1);
                        }
                        defaultCaseTurn = 0;

                    }
                    break;
                }

            }

            getDottedLine(); // the lower dotted line
        }
    }
}
