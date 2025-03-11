import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class TimeInterpreter {

            public static String InterpretTime(String InputTime) {
                String OutputTime = "";
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); //format: dd-MM-yyyy
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a"); //format dd mmm yyyy

                try {
                    LocalDateTime date = LocalDateTime.parse(InputTime.strip(), inputFormatter);
                    OutputTime = date.format(outputFormatter);
                } catch (DateTimeParseException e) {
                    OutputTime = InputTime;
                }
                return OutputTime;
            }

}
