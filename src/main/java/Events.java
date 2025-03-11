import java.sql.Time;

public class Events extends Task {
    public String From;
    public String To;

    public Events(String Description, String From, String To) {
        super(Description);
        this.taskTypeChar="E";
        this.From = TimeInterpreter.InterpretTime(From);
        this.To = TimeInterpreter.InterpretTime(To);
    }

    public static String[] getEventsData(String[] command) {
        String[] eventsData = new String[]{"","",""};
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 1; i < command.length; i++) { //since the first word is going to be events
            if(command[i].startsWith("/")) {
                if(flag1 == 0) {flag1 = 1;}else {flag2 = 1;}
                continue; // <---------------------------------TO NOT HAVE MULTIPLE FROM/ TO
            }
            if(flag1==0 && flag2==0) {eventsData[0] += command[i]+" ";}
            if( flag1==1 && flag2==0) {eventsData[1] += " " + (command[i].startsWith("/") ? command[i].substring(1) : command[i]);}
            if( flag1==1 && flag2==1) {eventsData[2] += " " + (command[i].startsWith("/") ? command[i].substring(1) : command[i]);}
        }
        return eventsData;
    }

    public String getTaskInfo(){
        return "["+this.taskTypeChar+"] "+this.taskDescription+" "+"(From:"+this.From+" - To:"+this.To+")"+
                " ".repeat(4)+(this.isDone ? "{completed}" : "");
    }
}

