/*borhan sagor
COSC 1336
for loop practice
pseudo Code: creating random obj to input dice values then creating a variable to store the value of boxcars or 12; putting rollnumber to 1000 then creating 
a for loop that runs through 1000 times and each time it runs it generates a pair of random dice and adds up then increments count only if it adds to 12;*/
import java.util.*;
public class Dice{
    public static void main(String[]args){
        Random gen=new Random();//random gen
        int count=0;
        int roll;
        int boxcars=12;
        int rollnumber=1000;
            for(int i=0; i<rollnumber;i++){//runs 1000 times and i increments
                roll = gen.nextInt(6)+1 + gen.nextInt(6)+1;//random gen and adding them up
                if(roll==boxcars){//checks to see if it adds to 12
                    count++;//increments every time lands a boxcar 
                }
            }
        System.out.println(count);
        
    }
}
