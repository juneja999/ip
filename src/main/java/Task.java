/**
 * defines the behaviour of all Task types like events, deadlines and t0d0 ( which are its' subclasses)
 */
public class Task {
    protected String taskDescription;
    protected Boolean isDone;
    protected String taskTypeChar="T";

    //this is so that we can get the Name instead of memory address when converting Task to String
    public String getTaskDescription(Task task){
        return task.taskDescription;
    }

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    /**
     * this method enables us to get all the essential information of a task(description, status, Task type)
     * @return all this information as a string
     */

    public String getTaskInfo(){
        return "["+this.taskTypeChar+"] "+this.taskDescription+" ".repeat(4)+ (this.isDone ? "{completed}" : "");
    }
}

