import java.util.ArrayList;
public class TaskSearch {

    public static void searchTask(Boolean IsCaseSensitive, String[] WordsToSearch, TaskList taskList) {
        Boolean FoundSearch = false;
        ArrayList<String> TasksWithTargetWord = new ArrayList<>();
        for (int i = 2; i < WordsToSearch.length; i++) {
            //starting from 2 because 0th word is find and 1st word is cs/ncs
            String TargetWord = (IsCaseSensitive) ? WordsToSearch[i] : WordsToSearch[i].toLowerCase();
            for (int k = 0; k < taskList.getSize()  ; k++) {
                if (taskList.taskList.get(k).taskDescription.contains(" "+TargetWord+" ") ||
                        taskList.taskList.get(k).taskDescription.contains(" "+TargetWord) ||
                        taskList.taskList.get(k).taskDescription.contains(TargetWord+" ")) {
                    //these cases are neccesary otherwise it will detect for eg: jupyter for py
                    TasksWithTargetWord.add(taskList.taskList.get(k).getTaskInfo());
                    FoundSearch = true;
                }
            }
            if (FoundSearch) {
                System.out.println("Here is what I found: ");
                for(int j = 0; j < TasksWithTargetWord.size(); j++) {
                    System.out.println(j+1+"] "+TasksWithTargetWord.get(j));
                    //to display from 1
                }
                return;
            }
        }
        System.out.println("Nothing found :(");

    }
}
