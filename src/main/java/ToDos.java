public class ToDos extends Task{
    public ToDos(String Description){
        super(Description.substring(Description.indexOf(" ")+1).strip());
        //because the first word is going to be "todos"
        this.taskTypeChar="T";
    }
}
