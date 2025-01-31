import java.util.Scanner;


public class AJ {

    private final static String DOTTED_LINE="***********************(^‿^)***************************";
    private final static int AJ_TEXT_INDENTATION = 7; //will use with " ".repeat(#)

    //used to segregate user and bot text
    public static void getDottedLine(){
        System.out.println(DOTTED_LINE+"\n");
    }


    public static void main(String[] args) {
        getDottedLine();
        System.out.println("Hi there! I'm AJ, always happy to help :) ");
        System.out.println("What's on your mind?");
        getDottedLine();
        System.out.println("PS:In case I don't see you later, good afternoon, good evening, and good night");
        getDottedLine();

        String userCommand;
        TaskList taskList = new TaskList();
        while(true){
            Scanner input = new Scanner(System.in);
            userCommand = input.nextLine();
            userCommand = userCommand.strip(); //remove leading and trailing whitespaces
            Task task = new Task(userCommand);
            getDottedLine();
            if(!userCommand.equals("bye") && !userCommand.equals("list")
                    && !userCommand.contains("mark ") && !userCommand.contains("unmark ")){
                //Task task = new Task(userCommand);
                taskList.addTask(task);
                System.out.println(" ".repeat(AJ_TEXT_INDENTATION)+ "Done!, added: "+userCommand);
            } else if (userCommand.equals("list")) {
                String [] currentList = taskList.getTaskList();

                for(int i = 0; i < currentList.length; i++){
                    System.out.print(" ".repeat(AJ_TEXT_INDENTATION)+ (i+1)+"] "+currentList[i]); //because indexing starts from 0
                    System.out.println(" ".repeat(AJ_TEXT_INDENTATION)+(taskList.taskList.get(i).isDone ? "{completed}" :""));//the taskList has a protected attribute taskList(mention in file TaskList, I'm accesing the index of that attribute)
                }
            } else if (userCommand.contains("unmark ") || userCommand.contains("mark ")) { //the whitespace is intentional because tasks like market also contain mark
                String[] userCommandSplitArray = userCommand.split(" ");
                int taskListIndex = Integer.parseInt(userCommandSplitArray[1]) - 1; //because we had shifted +1 when writing
                taskList.toggleTasks(taskListIndex, (userCommand.contains("unmark ") ? false : true));
                if(userCommand.contains("unmark ")){
                    System.out.println(" ".repeat(AJ_TEXT_INDENTATION)+"Got it. No worries! you will do it soon.");
                    System.out.println(" ".repeat(AJ_TEXT_INDENTATION)+ "I have unmarked task: " +taskList.taskList.get(taskListIndex).taskDescription); // taskList.taskList because I gave the same name in this file and TaskList file
                }else{ //in the above line, .taskDescription gives the name, otherwise we get memory address
                    System.out.println(" ".repeat(AJ_TEXT_INDENTATION)+"Let's gooo!! Keep up the productivity.");
                    System.out.println(" ".repeat(AJ_TEXT_INDENTATION)+"I have marked task: " + taskList.taskList.get(taskListIndex).taskDescription);
                }
            }else{
                System.out.println(" ".repeat(AJ_TEXT_INDENTATION) + "Bye,take care! May your device's battery never run out.");
                getDottedLine();
                break;
            }
            getDottedLine();
        }
    }
}
