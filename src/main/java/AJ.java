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

    public static String[] userCommandParser(String[] command){
        ArrayList<String> output= new ArrayList<String>();
        for(int i=0; i<command.length; i++){
            if(command[i].equals("")){continue;}
            output.add(command[i]);
        }
        return output.toArray(new String[output.size()]);
    }

    private static void getInitialGreeting() {
        getDottedLine();
        System.out.println("Hi there! I'm AJ, always happy to help :) ");
        System.out.println("What's on your mind?");
        getDottedLine();
        System.out.println("PS:In case I don't see you later, good afternoon, good evening, and good night");
        getDottedLine();
    }

    private static String getUserCommand() {
        String userCommand;
        Scanner input = new Scanner(System.in);
        userCommand = input.nextLine();
        return userCommand;
    }


    public static void main(String[] args) {

        getInitialGreeting();

        TaskList taskList = new TaskList();

        int defaultCaseTurn =0; //used in the default case when task type not identified



        while(true){
            String userCommand = getUserCommand(); //string version
            userCommand = userCommand.strip(); //remove leading and trailing whitespaces

            Task task = new Task(userCommand); // Task version


            getDottedLine(); //the upper dotted line

            if(userCommand.equals("bye")){
                System.out.println(AJ_TEXT_INDENTATION + "Bye,take care! May your device's battery never run out.");
                getDottedLine();
                break;
            }else if(userCommand.equals("list")){
                taskList.printTaskList();
//                String [] currentList = taskList.getTaskList();
//
//                for(int i = 0; i < currentList.length; i++){
//                    System.out.print(AJ_TEXT_INDENTATION + (i+1)+"] "+currentList[i]); //because indexing starts from 0
//                    System.out.println(AJ_TEXT_INDENTATION +(taskList.taskList.get(i).isDone ? "{completed}" :""));
//                    //the taskList has a protected attribute taskList(mention in file TaskList,
//                    // I'm accessing the index of that attribute)
//
//                }
            }else{
                String[] userCommandSplitArray = userCommandParser(userCommand.split(" "));
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
                        System.out.println(AJ.AJ_TEXT_INDENTATION+"Sorry, I would need the serial number of the task");
                        System.out.println(AJ.AJ_TEXT_INDENTATION+"Please try again!");
                        break;
                    }
                    try {
                        taskList.toggleTasks(taskListIndex, targetWord.toLowerCase().equals("unmark") ? false : true);
                        if(targetWord.toLowerCase().equals("unmark")){
                            System.out.println(AJ_TEXT_INDENTATION +"Got it. No worries! you will do it soon.");
                            System.out.println(AJ_TEXT_INDENTATION + "I have unmarked task: " +taskList.taskList.get(taskListIndex).taskDescription);
                            // taskList.taskList because I gave the same name in this file and TaskList file
                        }else{ //in the above line, .taskDescription gives the name, otherwise we get memory address
                            System.out.println(AJ_TEXT_INDENTATION +"Let's gooo!! Keep up the productivity.");
                            System.out.println(AJ_TEXT_INDENTATION +"I have marked task: " + taskList.taskList.get(taskListIndex).taskDescription);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        if(taskListIndex >=0){
                            System.out.println("Mr. overachiever, you dont have that many tasks!, if only I could be like you");
                        }else{
                            System.out.println("Sorry but that serial number was not recognised, please try again!");
                        }
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
//                    taskList.addTask(task);
//                    System.out.println(AJ_TEXT_INDENTATION + "Done!, added: "+userCommand);
//                    break;
                }

            }

            getDottedLine(); // the lower dotted line
        }
    }
}
