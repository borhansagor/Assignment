/*Borhan Sagor
COSC 1336
For loop practice
creating scanner obj and instantiating it, then creating sum variable and setting it to 0; having an if conditional so that user input is less than 2
it prints out an error message; afterwards creatin a for lop that sets initial value to 2 and adding and incrementing integers by 2 till its equal to or less
than the user input.*/

import java.util.*;

public class Even{
    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);//scanner instantiating

        System.out.println("enter a number..");
        int objinput=scan.nextInt();//user input
        int sum=0;
        if (objinput<2){//conditional for wrong input
            System.out.println("Error");
        }
            for (int intnum=2; intnum<=objinput;intnum+=2){//for loop to get the sum of even integers
                sum+=intnum;
              
             }
            
        
        System.out.println("total: "+sum);//prinitng out the total sum
    }
}