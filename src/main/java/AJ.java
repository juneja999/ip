import java.util.Scanner;


public class AJ {

    private final static String DOTTED_LINE="***********************(^‿^)***************************";
    private final static int AJ_TEXT_INDENTATION = 7; //will use with " ".repeat(#)

    //used to segregate user and bot text
    public static void getDottedLine(){
        System.out.println(DOTTED_LINE+"\n");
    }


    public static void main(String[] args) {
        getDottedLine();
        System.out.println("Hi there! I'm AJ, always happy to help :) ");
        System.out.println("What's on your mind?");
        getDottedLine();
        System.out.println("PS:In case I don't see you later, good afternoon, good evening, and good night");
        getDottedLine();

        String userCommand;
        while(true){
            Scanner input = new Scanner(System.in);
            userCommand = input.nextLine();
            getDottedLine();
            if(!userCommand.equals("bye")){
                System.out.println(" ".repeat(AJ_TEXT_INDENTATION)+userCommand);
            }else{
                System.out.println(" ".repeat(AJ_TEXT_INDENTATION) + "Bye,take care! May your device's battery never run out.");
                getDottedLine();
                break;
            }
            getDottedLine();
        }
    }
}
