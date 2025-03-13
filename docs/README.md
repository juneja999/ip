# AJ

AJ is a chatbot that can help you manage your tasks by listing them, 
their deadlines, their completion status and even saving them to your 
local files, all done through command line.  
A super efficient tool for a super efficient you!

----------------

## Table of Content
### 1. Setting up in Intellij
### 2. Commands:   
1. Listing all the tasks: `list`
2. Adding a Todo: `todo`
3. Adding a Deadline: `deadline`
4. Adding an Event: `event`
5. Deleting a task: `delete`
6. Marking a task: `mark`
7. Unmarking a task: `unmark`
8. Exiting the program: `bye`
8. Finding a task with keyword(s):`find`
    


   **NOTE:** All of these commands are case-insensitive  

### 3. Important Points  

----


### Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/AJ.java` file, right-click it, and choose `Run AJ.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   

```
***********************(^.^)***************************

Hi there! I'm AJ, always happy to help :) 
What's on your mind?
***********************(^.^)***************************

PS:In case I don't see you later, good afternoon, good evening, and good night
***********************(^.^)***************************
```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.

-----
### Commands
1. Listing all tasks: `list`  
   Lists all the feature currently in the task list.  
   **Format:** `list`  
   **Example:**
   1. `list` returns the following saved tasks
   ````
       1] [T] this will be difficult    
       2] [D] dinosaur is forever be (By:789)    
       3] [E] hahhah what are be (From:9 - To:10)    
       4] [T] jamer dinosaur be    {completed}
       5] [T] superman    {completed}
       6] [E] cycling (From:Aug 12 2009, 05:40 am - To:Feb 14 2025, 02:15 pm)
   ````
   **Note:**  
   - The characters `T`/`D`/`E` represent the task type, which are, todo, deadline and event
   respectively.  
   - Depending upon the task type, they may or may not have a time dimension. More
   description can be found for the individual task type.
   -  `{completed}` indicates that a task has been done  




2. Adding a todo: `todo`  
   Add a task type of todo. This only takes in user task input in the 
form of `UserTask` and no time attribute can be provided here.  
   **Format:** `todo UserTask`  
   **Example:**
   1. `todo sing` will save a task type of todo with description 'sing'.  





3. Adding a deadline: `deadline`  
Add a task type of deadline. This takes in user task input in the
form of `UserTask` and a by time attribute in the form of `By`.    
**Format:** `todo UserTask /by By`  
**Example:**
   1. `deadline sing /by 6 pm ` will save a task type of deadline 
   with description 'sing' and By of 6 pm.  

   **Warning:** AJ can interpret dates and time, but they need to be **strictly** in 
            accordance to the format as described in Important Points, 1.   
            If the format is not followed, programme will store date and time 
            as user had inputted.


4. Adding an event: `event`  
Add a task type of event. This takes in user input in the form of `UserTask` and a 
from time attribute in the form of `From` and a to time attribute in the form of `To`.  
**Format:** `event UserTask /from From /to To`  
**Example:**  
   1. `event sing /from 10 am /to 11 am` will save an event sing from 10 am to 11 am  

   **Warning 1:** AJ can interpret dates and time, but they need to be **strictly** in
         accordance to the format as described in Important Points, 1.   
         If the format is not followed, programme will store date and time
         as user had inputted.  
   **Warning 2:** **It is mandatory** to fill out the `From` and `To` fields. User 
                     cannot leave them blank.  



5. Deleting a task: `delete`  
Deletes the task from list whose `index` is provided.  
**Format:** `delete index`  
**Example:** `delete 1` will delete the following task from the list
      ````
      [T] this will be difficult
      ````  
   **Note:** `index` >= 1  


6. Marking a task: `mark`  
It will mark the task as  `{completed}` when the `index` is provided.  
**Format:** `mark index`  
**Example:** `mark 1` will result in

   ````
    1] [T] this will be difficult    {completed}  
   ````
   **Note:** `index` >=1  


7. Unmarking a task: `Unmark`  
   It will unmark the task when the `index` is provided. If a task was previously
   unmarked, it will display nothing in the status field.  

   **Format:** `unmark index`  
   **Example:** `unmark 1` will result in
   ````
   1] [T] this will be difficult
   ````
   **Note:** `index` >=1  


8. Exiting the programme : `Bye`  
      This will exit the programme.  
      **Format:** `bye`


9. Finding tasks: `find`  
It will find tasks whose description matches the `TargetWord(s)` provided by the user.
User also needs to specify if the search should be case-sensitive or case-insensitive.
User **must write cs** to `CaseSensitivity` for case-sensitive search, 
**otherwise must write ncs**.  

    **Format:** `find CaseSensitivity TargetWord(s)`  
    **Example:**  
1. `find ncs dinosaur` will result in 
      ````
      Here is what I found: 
      1] [D] dinosaur is forever be (By:789)    
      2] [T] jamer dinosaur be    {completed}
      ````
2. `find ncs DINOSAUR` will result in 
   ````
   1] [D] dinosaur is forever be (By:789)    
   2] [T] jamer dinosaur be    {completed}
   ````
3. `find cs DINOSAUR` will result in 
   ````
   Nothing found :(
   ````
4. `find ncs dinosaur superman` will result in 
   ````
   Here is what I found: 
   1] [D] dinosaur is forever be (By:789)    
   2] [T] jamer dinosaur be    {completed}
   3] [T] superman    {completed}
   ````
**Warning:** The `CaseSensitivity` field in format ust be specified, otherwise 
               it will result in incorrect results.    

   



-----------

### Important Points 
1. To make sure that the programme interprets Date and Time, you must **strictly**
use the format **dd-MM-yyyy hh:mm** , where "d" represents day, "M" represents month,
"y" represents year, "h" represents hour and "m" represents minute.  
Also make sure that you use "-" only and not alternatives like "/".   
Please also note that **the system will not pad missing values with zero.**  
**Example:** `event sing /from 10-12-2024 05:30 /to 11-12-2024 17:50` will result in
   ````
   Done!, added: [E] sing  (From:Dec 10 2024, 05:30 am - To:Dec 11 2024, 05:50 pm)
   ````  
2. User must provide `From` and `To` fields for an `event`, otherwise there will be unexpected issues. 
To rectify the error, user must then manually clear this `event` entry from the SavedTasks.txt file (file
where tasks are saved).  

2. Make sure to indicate case-sensitivity via "ncs" or "cs" when using `find`.
3. The `index` for `mark`, `unmark` and`delete` should be >= 1.
4. In the case when task type(`todo`,`deadline`,`event`) is not mentioned, AJ will ask
if we would like to store it as a `todo`. Please follow instructions provided from there.


----
## Hope you enjoy your experience with AJ :)
