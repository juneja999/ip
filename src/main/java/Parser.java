import java.util.ArrayList;

public class Parser {

    /**
     * breaks the user command into words( broken at spaces)
     * @param command user input
     * @return an array consisting of words in user command
     */

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