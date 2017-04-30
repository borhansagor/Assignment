/*Borhan Sagor
COSC 1336
overloading methods
psuedo code: simply going to create a class named OVerload then creating print methods that intake integers and print the average of their sum; overloading them by having the same method modified 
with different parameters; finally creating a main method that uses the methods.*/
public class Overload{

    public void average(int pintnumber, int pintnumber2){//intakes two numbers
        System.out.println("Average is: "+ pintnumber+pintnumber2/2);
    }
    public void average(int pintnumber, int pintnumber2, int pintnumber3){//intakes 3 numbers
        System.out.println("Average os: "+ pintnumber+pintnumber2+pintnumber3/3);
    }
    public void average(int pintnumber, int pintnumber2, int pintnumber3, int pintnumber4 ){//intakes 4 numbers
        System.out.println("Average is: "+ pintnumber+pintnumber2+pintnumber3+pintnumber4/4);
    }
    public static void main(String[]args){
        Overload objectTest=new Overload();//new obj of class OVerload
        objectTest.average(5,6);//print method of 2 int avr
        objectTest.average(5,9,8);//print method of 3 int avr
        objectTest.average(5,8,9,4);//print method of 4 int avr
        
    }  
}