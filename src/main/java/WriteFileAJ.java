import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WriteFileAJ {
    protected ArrayList<String> textToWrite = new ArrayList<String>();

    public WriteFileAJ(ArrayList<Task> taskList, String filepath) throws IOException {
        int i=0;
        for (Task task : taskList) {
            textToWrite.add(i +") " + "["+task.taskTypeChar +"] " + task.taskDescription + (task.isDone ? "completed": "")  );
            i++;
        }

        try{
            FileWriter fw = new FileWriter(filepath);
            for (String s : textToWrite) {
                fw.write(s);
            }
            fw.close();
        }catch(IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }
}
