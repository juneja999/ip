import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileAJ {

    public static void getFileInfo(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) {
        try{
            getFileInfo("UserTasks\\AJChatbot.txt");
        }catch(FileNotFoundException e){
           FileAJ.MakeFile();
        }
    }
}
