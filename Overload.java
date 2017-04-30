/*Borhan Sagor
COSC 1336
overloading methods
psuedo code: simply going to create a class named OVerload then creating print methods that intake float and print the average of their sum; overloading them by having the same method modified 
with different parameters; finally creating a main method that uses the methods.*/
public class Overload{

    public void average(float pintnumber, float pintnumber2){//intakes two numbers
        System.out.println("Average is: "+ (pintnumber+pintnumber2)/2.0);
    }
    public void average(float pintnumber, float pintnumber2, float pintnumber3){//intakes 3 numbers
        System.out.println("Average is: "+ (pintnumber+pintnumber2+pintnumber3)/3.0);
    }
    public void average(float pintnumber, float pintnumber2, float pintnumber3, float pintnumber4 ){//intakes 4 numbers
        System.out.println("Average is: "+ (pintnumber+pintnumber2+pintnumber3+pintnumber4)/4.0);
    }
    public static void main(String[]args){
        Overload objectTest=new Overload();//new obj of class OVerload
        objectTest.average(5.0f,6.0f);//print method of 2 float avr
        objectTest.average(5.0f,9.0f,8.0f);//print method of 3 float avr
        objectTest.average(5.0f,8.0f,9.0f,4.0f);//print method of 4 float avr
        
    }  
}
