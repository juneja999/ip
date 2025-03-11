import java.util.Scanner;

public class UserCommands {

    /**
     * takes user commands
     * @return stripped user command to AJ.java
     */
    public static String getUserCommand() {
        String userCommand;
        Scanner input = new Scanner(System.in);
        userCommand = input.nextLine();
        return userCommand.strip();
    }

}
