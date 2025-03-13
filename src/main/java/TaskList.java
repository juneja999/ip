import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * this class creates a tasklist which is an arraylist consisting of type 'task'
 * it also contains methods like add task/delete task/toggling a task status/print the task list etc.
 * this class also contains methods to load tasks from and save tasks to a hard drive
 */

public class TaskList {

    public static final String FILE_SEPARATOR = " ~ ";
    protected ArrayList<Task> taskList = new ArrayList<Task>();
    private static final String FILE_PATH = "UserData/SavedTasks.txt";
    // Path to store tasks


    public TaskList() {
        loadTasksFromFile();
        // Load tasks from file when initializing
    }
    public TaskList(Task task) {
        taskList.add(task);
    }

    public void addTask(Task task) {
        taskList.add(task);
        saveTasksToFile();
        // Save the updated task list to file after adding a task
    }

    public int getSize() {
        return taskList.size();
    }

    public String[] getTaskList(){
        String[] currentTaskList = new String[taskList.size()];
        for(int i = 0; i < taskList.size(); i++){
            currentTaskList[i] = taskList.get(i).taskDescription;
        }
        return currentTaskList;
    }



    public void printTaskList(){
        for(int i = 0; i < taskList.size(); i++){
            Task thisTask = taskList.get(i);
            System.out.println(AJ.AJ_TEXT_INDENTATION + (i+1)+"] "+ thisTask.getTaskInfo());
        }
    }


    //to mark and unmark tasks
    public void toggleTasks(int taskListIndex, boolean markUnmark){
        taskList.get(taskListIndex).isDone = markUnmark;
        saveTasksToFile();
        // Save the updated task list to file after adding a task
    }

    public void removeTask(int taskListIndex){
        taskList.remove(taskListIndex);
        saveTasksToFile();
    }

    /**
     * gives a getter function for calling save tasks to file function
     * this is mainly utilised after user exits the system
     */

    public void GetSaveTasksToFile(){
        saveTasksToFile();
    }

    /**
     * saves tasks to hard drive in teh location UserData->SavedTasks
     *continuously updated whenever a task is added, deleted or when the prgram is exited
     */

    // Save tasks to file
    private void saveTasksToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            int i=0;
            for (Task task : taskList) {

                switch (task.taskTypeChar) {
                case "T":
                    writer.write((i + 1) + FILE_SEPARATOR + task.taskTypeChar + FILE_SEPARATOR + task.taskDescription.trim() + FILE_SEPARATOR +
                            (task.isDone ? "completed" : "yet to be completed")+"\n");
                    //format on how tasks are saved in the local file
                    break;
                case "D":
                    assert task instanceof Deadlines;
                    Deadlines deadlines = (Deadlines) task;
                    writer.write((i + 1) + FILE_SEPARATOR + deadlines.taskTypeChar + FILE_SEPARATOR + deadlines.taskDescription.trim() + FILE_SEPARATOR +
                            deadlines.by.trim() + FILE_SEPARATOR + (deadlines.isDone ? "completed" : "yet to be completed")+"\n");
                    break;

                case "E":
                    assert task instanceof Events;
                    Events events = (Events) task;
                    writer.write((i + 1) + FILE_SEPARATOR + events.taskTypeChar + FILE_SEPARATOR + events.taskDescription.trim() + FILE_SEPARATOR +
                            events.from.trim() + " - " + events.to.trim() + FILE_SEPARATOR + (events.isDone ? "completed" : "yet to be completed")+"\n");
                    break;

                }
                i++;
            }
        } catch (IOException e) {
            System.out.println(AJ.AJ_TEXT_INDENTATION + "Error saving tasks to file." + e.getMessage());
        }
    }


    /**
     * this method loads tasks from the hard drive on the start of the program
     * For the first time user, if a directory called "User Data" doesnt exist then it adds one, it further creates a file
     * called SavedTasks
     */
    private void loadTasksFromFile() {
        File directory = new File("UserData");
        if (!directory.exists()) {
            // Create the directory if it doesn't exist
            if (directory.mkdirs()) {
                UiMessages.DirectoryCreation();
            } else {
                UiMessages.FailedDirectoryCreation();
            }
        }

        File file = new File(FILE_PATH);

        try {
            if (!file.exists()) {
                // If the file doesn't exist, create it
                if (file.createNewFile()) {
                    UiMessages.FileCreation();
                } else {
                    UiMessages.FailedFileCreation();
                }
            } else {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] currentTask = scanner.nextLine().split(FILE_SEPARATOR);
                    switch (currentTask[1]){
                        case "T":
                            Task savedTask = new Task(currentTask[2]);
                            savedTask.isDone = (currentTask[3].equals("completed"));
                            taskList.add(savedTask);
                            break;

                        case "D":
                            Deadlines savedDeadlines = new Deadlines(currentTask[2], currentTask[3]);
                            savedDeadlines.isDone = (currentTask[4].equals("completed"));
                            taskList.add(savedDeadlines);
                            break;

                        case "E":
                            Events savedEvents = new Events(currentTask[2],
                                    currentTask[3].split(" - ")[0], currentTask[3].split(" - ")[1]);
                            savedEvents.isDone = (currentTask[4].equals("completed"));
                            taskList.add(savedEvents);
                            break;

                    }

                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println(AJ.AJ_TEXT_INDENTATION + "Error reading the tasks file: " + e.getMessage());
        }
    }

}
