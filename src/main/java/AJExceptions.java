public class AJExceptions {

    /**
     * this is string text is displayed when the task type ( event/t0d0/deadline) cannot be resolved for a task that user inputs
     * @param userCommand
     */
    public static void taskTypeNotFound(String userCommand) {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Hmmm...sorry I couldn't resolve the task \"type\" for "+"\""+userCommand+"\"");
        System.out.println(AJ.AJ_TEXT_INDENTATION + "After all I'm still learning" );
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Would you like to make this as a \"todo\"? Please input \"yes\"" );
        System.out.println(AJ.AJ_TEXT_INDENTATION+"if not, please input \"no\"");
    }

}
