import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * this class helps the programme understand and save dates and times if they are provided in the correct format
 */

public class TimeInterpreter {

            public static String InterpretTime(String inputTime) {
                String outputTime = "";
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                //format expected from user
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
                //format given by system

                try {
                    LocalDateTime date = LocalDateTime.parse(inputTime.strip(), inputFormatter);
                    outputTime = date.format(outputFormatter);
                } catch (DateTimeParseException e) {
                    //when input format is wrong, AJ will directly save what user wrote
                    outputTime = inputTime;
                }
                return outputTime;
            }

}
