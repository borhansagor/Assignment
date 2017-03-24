/*Borhan Sagor
COSC 1336
hi-low game
separating methods that do not need to be repeated outside of the loop, making a random generator to generate number between 1-100; which will be 
the winning number, then making a boolean variable that acts as starting and ending of the loops. finally implementing userinput whether they want to
continue or end the game.*/
import java.util.*;

public class hilow{
    public static void main(String[]strArg){

        Scanner scan=new Scanner(System.in);//instantiating methods
        Random number=new Random();

        

        int winningnumber=number.nextInt(100)+1;// winning number between 1-100
        
        boolean play=true;//boolean to use as switch to end and start loop later on
        
        while (play){
            System.out.println("guess the number!");
            int input=scan.nextInt();
            if (input>winningnumber){
                System.out.println("too High..");
                System.out.println("play again? Type yes to continue or no to quit...");
                String input2=scan.next();
                if (input2.equalsIgnoreCase("no")){
                    play=false;//game ends
                }
            }else if (input<winningnumber){
                System.out.println("too low..");
                System.out.println("play again? Type yes to continue or no to quit...");
                String input2=scan.next();
                if (input2.equalsIgnoreCase("no")){
                    play=false;//game ends
                }
            }else if(input==winningnumber){
                System.out.println("you win!");
                System.out.println("play again? Type yes to continue or no to quit...");
                String input2=scan.next();
                if (input2.equalsIgnoreCase("no")){
                    play=false;//game ends
                }
                
            }else{
                System.out.println("error");
            }    
        }
    }
}