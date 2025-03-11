public class Deadlines extends Task {
    public String by;

    public Deadlines(String Description, String by) {
        super(Description);
        this.taskTypeChar="D";
        this.by = TimeInterpreter.InterpretTime(by);
    }

    /**
     * this method enables us to segregate all the essential info of a deadline ( description and by date)
     * @param command user input
     * @return this segregated info in an array
     * index 0: description, index 1: by date
     */

    public static String[] getDeadlinesData(String[] command ){
        String[] deadlinesData = new String[2];
        String deadlinesByDate="";
        String deadlinesDescription="";
        int flag=0;
        for(int i=1;i<command.length;i++){ //first word is deadlines, so skip it
            if(command[i].startsWith("/")){
                //deadlinesByDate+=command[i].substring(1); <------- TO NOT HAVE MULTIPLE BY BY: STATEMENTS
                flag=1;
                continue;
            }
            if(flag==1){
                deadlinesByDate+=" "+command[i];

            }else{
                deadlinesDescription+=command[i]+" ";
            }
        }
        deadlinesData[0]=deadlinesDescription;
        deadlinesData[1]=deadlinesByDate;
        return deadlinesData;
    }

    public String getTaskInfo() {
        return "["+this.taskTypeChar+"] "+this.taskDescription+" (By:"+this.by+")"+" ".repeat(4)+(this.isDone ? "{completed}" : "");
    }
}
