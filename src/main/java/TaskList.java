import java.util.ArrayList;

public class TaskList {

    protected ArrayList<Task> taskList = new ArrayList<Task>();

    public TaskList() {}
    public TaskList(Task task) {
        taskList.add(task);
    }

    public void addTask(Task task) {
        taskList.add(task);
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
    }

}
