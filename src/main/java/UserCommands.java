import java.util.Scanner;

public class UserCommands {

    public static String getUserCommand() {
        String userCommand;
        Scanner input = new Scanner(System.in);
        userCommand = input.nextLine();
        return userCommand.strip();
    }

}
