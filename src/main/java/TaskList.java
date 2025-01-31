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


    //to mark and unmark tasks
    public void toggleTasks(int taskListIndex, boolean markUnmark){
        taskList.get(taskListIndex).isDone = markUnmark;
    }

}
