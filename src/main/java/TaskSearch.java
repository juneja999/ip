import java.util.ArrayList;

/**
 * class that helps with task searching
 */
public class TaskSearch {

    /**
     * method responsible for task searching
     * @param isCaseSensitive tells us whether the search should be case-sensitive or not
     * @param wordsToSearch gives the words for which user is searching
     * @param taskList is the task list from AJ that is being continuously updated
     */
    public static void searchTask(Boolean isCaseSensitive, String[] wordsToSearch, TaskList taskList) {
        Boolean foundSearch = false;
        ArrayList<String> tasksWithTargetWord = new ArrayList<>();
        for (int i = 2; i < wordsToSearch.length; i++) {
            //starting from 2 because 0th word is find and 1st word is cs/ncs
            String TargetWord = (isCaseSensitive) ? wordsToSearch[i] : wordsToSearch[i].toLowerCase();
            for (int k = 0; k < taskList.getSize()  ; k++) {
                if (taskList.taskList.get(k).taskDescription.contains(TargetWord) ) {
                    //these cases are neccesary otherwise it will detect for eg: jupyter for py
                    tasksWithTargetWord.add(taskList.taskList.get(k).getTaskInfo());
                    foundSearch = true;
                }
            }

        }
        if (foundSearch) {
            System.out.println("Here is what I found: ");
            for (int j = 0; j < tasksWithTargetWord.size(); j++) {
                System.out.println(j + 1 + "] " + tasksWithTargetWord.get(j));
                //to display from 1
            }
            return;
        }
        System.out.println("Nothing found :(");

    }
}
