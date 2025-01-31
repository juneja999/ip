public class Task {
    protected String taskDescription;
    protected Boolean isDone;

    //this is so that we can get the Name instead of memory address when converting Task to String
    public String getTaskDescription(Task task){
        return task.taskDescription;
    }

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
    }
}
