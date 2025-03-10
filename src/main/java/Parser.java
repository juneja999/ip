import java.util.ArrayList;

public class Parser {


    public static String[] userCommandParser(String[] command) {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < command.length; i++) {
            if (command[i].equals("")) {
                continue;
            }
            output.add(command[i]);
        }
        return output.toArray(new String[output.size()]);
    }
}