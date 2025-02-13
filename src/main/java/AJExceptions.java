public class AJExceptions {

    public static void taskTypeNotFound(String userCommand) {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Hmmm...sorry I couldn't resolve the task \"type\" for "+"\""+userCommand+"\"");
        System.out.println(AJ.AJ_TEXT_INDENTATION + "After all I'm still learning" );
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Would you like to make this as a \"todo\"? Please input \"yes\"" );
        System.out.println(AJ.AJ_TEXT_INDENTATION+"if not, please input \"no\"");
    }

}
