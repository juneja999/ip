import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


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

//    public void printTaskList(){
//        for(int i = 0; i < taskList.size(); i++){
//            Task thisTask = taskList.get(i);
//
//            switch (thisTask.taskTypeChar){
//            case "T":
//                System.out.println(AJ.AJ_TEXT_INDENTATION + i+1+"] "+"["+ thisTask.taskTypeChar+"] "+
//                                thisTask.taskDescription +" ".repeat(4) + (thisTask.isDone ? "{completed}" : ""));
//                break;
//
//            case "D":
//                //START FROM HERE
//
//            }
//        }
//    }

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

    public void GetSaveTasksToFile(){
        saveTasksToFile();
    }


    // Save tasks to file
    private void saveTasksToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            int i=0;
            for (Task task : taskList) {
//                writer.write((i+1) + "] "+ task.getTaskInfo()+"\n");
//                i++;
                switch (task.taskTypeChar) {
                case "T":
                    writer.write((i + 1) + FILE_SEPARATOR + task.taskTypeChar + FILE_SEPARATOR + task.taskDescription.trim() + FILE_SEPARATOR +
                            (task.isDone ? "completed" : "yet to be completed")+"\n");
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
                            events.From.trim() + " - " + events.To.trim() + FILE_SEPARATOR + (events.isDone ? "completed" : "yet to be completed")+"\n");
                    break;

                }
                i++;
            }
        } catch (IOException e) {
            System.out.println(AJ.AJ_TEXT_INDENTATION + "Error saving tasks to file." + e.getMessage());
        }
    }


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
                // Load tasks from the file
//                BufferedReader reader = new BufferedReader(new FileReader(file));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    // Assuming each task is stored in a specific format, like "[T] Task description {completed}"
//                    String[] taskData = line.split(" \\[");
//                    if (taskData.length == 2) {
//                        String description = taskData[1].split("]")[1].trim();
//                        boolean isDone = taskData[1].contains("{completed}");
//                        Task task = new Task(description);
//                        task.isDone = isDone;
//                        taskList.add(task);
//                    }
//                }
//                reader.close();
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
