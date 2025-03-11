


public class UiMessages {

    public static void getInitialGreeting() {
        AJ.getDottedLine();
        System.out.println("Hi there! I'm AJ, always happy to help :) ");
        System.out.println("What's on your mind?");
        AJ.getDottedLine();
        System.out.println("PS:In case I don't see you later, good afternoon, good evening, and good night");
        AJ.getDottedLine();
    }

    public static void AJExitMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Bye,take care! May your device's battery never run out.");
        AJ.getDottedLine();
    }

    public static void RequestSerialNumber() {
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Sorry, I would need the serial number of the task");
        System.out.println(AJ.AJ_TEXT_INDENTATION + "Please try again!");
    }

    public static void TaskUnmarkMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION +"Got it. No worries! you will do it soon.");
    }

    public static void TaskMarkMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION +"Let's gooo!! Keep up the productivity.");
    }

    public static void NotEnoughTaskMessage() {
        System.out.println(AJ.AJ_TEXT_INDENTATION+"Mr. overachiever, you dont have that many tasks!, if only I could be like you");
    }

    public static void RequestPositiveSerialNumber() {
        System.out.println(AJ.AJ_TEXT_INDENTATION+"Sorry but that serial number was not recognised, please try again!");
        System.out.println(AJ.AJ_TEXT_INDENTATION+"Please try to input a non-zero positive serial number");
    }
}
