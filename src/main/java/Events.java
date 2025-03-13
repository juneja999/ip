public class Events extends Task {
    public String from;
    public String to;

    public Events(String Description, String From, String To) {
        super(Description);
        this.taskTypeChar = "E";
        this.from = TimeInterpreter.InterpretTime(From);
        this.to = TimeInterpreter.InterpretTime(To);
    }

    /**
     * helps us segregate event description, from date and to date
     * @param command inputted by user
     * @return this segregated info in an array
     * index 0: description, index 1: from date, index 2: to date
     */
    public static String[] getEventsData(String[] command) {
        String[] eventsData = new String[]{"","",""};
        int fromTime = 0;
        int toTime = 0;
        for (int i = 1; i < command.length; i++) { //since the first word is going to be events
            if(command[i].startsWith("/")) {
                if(fromTime == 0) {
                    fromTime = 1;
                }else {
                    toTime = 1;
                }
                continue; // <---------------------------------TO NOT HAVE MULTIPLE FROM/ TO
            }
            if(fromTime == 0 && toTime == 0) {eventsData[0] += command[i]+" ";}
            if( fromTime == 1 && toTime == 0) {eventsData[1] += " " + (command[i].startsWith("/") ? command[i].substring(1) : command[i]);}
            if( fromTime == 1  && toTime == 1) {eventsData[2] += " " + (command[i].startsWith("/") ? command[i].substring(1) : command[i]);}
        }
        return eventsData;
    }

    public String getTaskInfo(){
        return "["+this.taskTypeChar+"] "+this.taskDescription+" "+"(From:"+this.from +" - To:"+this.to +")"+
                " ".repeat(4)+(this.isDone ? "{completed}" : "");
    }
}

