import java.util.Scanner;


public class AJ {

    private final static String DOTTED_LINE="***********************(^‿^)***************************";
    private final static String AJ_TEXT_INDENTATION = " ".repeat(7);
    //to provide indentation when bot replies


    //used to segregate user and bot text
    public static void getDottedLine(){
        System.out.println(DOTTED_LINE+"\n");
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
                String [] currentList = taskList.getTaskList();

                for(int i = 0; i < currentList.length; i++){
                    System.out.print(AJ_TEXT_INDENTATION + (i+1)+"] "+currentList[i]); //because indexing starts from 0
                    System.out.println(AJ_TEXT_INDENTATION +(taskList.taskList.get(i).isDone ? "{completed}" :""));
                    //the taskList has a protected attribute taskList(mention in file TaskList,
                    // I'm accessing the index of that attribute)
                }
            }else{
                String[] userCommandSplitArray = userCommand.split(" ");
                String targetWord = userCommandSplitArray[0].toLowerCase();

                switch (targetWord){
                case "mark":
                case "unmark":
                    int taskListIndex = Integer.parseInt(userCommandSplitArray[1]) - 1;
                    //because we had shifted +1 when writing
                    taskList.toggleTasks(taskListIndex, (userCommand.contains("unmark ") ? false : true));
                    if(userCommand.contains("unmark ")){
                        System.out.println(AJ_TEXT_INDENTATION +"Got it. No worries! you will do it soon.");
                        System.out.println(AJ_TEXT_INDENTATION + "I have unmarked task: " +taskList.taskList.get(taskListIndex).taskDescription);
                        // taskList.taskList because I gave the same name in this file and TaskList file
                    }else{ //in the above line, .taskDescription gives the name, otherwise we get memory address
                        System.out.println(AJ_TEXT_INDENTATION +"Let's gooo!! Keep up the productivity.");
                        System.out.println(AJ_TEXT_INDENTATION +"I have marked task: " + taskList.taskList.get(taskListIndex).taskDescription);
                    }
                    break;

                default:
                    taskList.addTask(task);
                    System.out.println(AJ_TEXT_INDENTATION + "Done!, added: "+userCommand);
                    break;
                }

            }
            getDottedLine(); // the lower dotted line
        }
    }
}
