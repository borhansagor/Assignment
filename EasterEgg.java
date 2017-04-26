/*Borhan Sagor  
COSC 1336
Easter Egg practice
psuedo code: writing a class for EasterEgg, creating instance variable and assigning default value of '#', creating constructors and getters and setters method, then applying them 
on a main method to print out the output.*/


public class EasterEgg{
    private char chrSign='#';
    
    public EasterEgg(){//constructor with no parameter
     char   pcharacter=' ';
    }
    public EasterEgg(char pcharacter){//constructor with a char input
        this.chrSign=pcharacter;
    }
    public void setSign(char pcharacter){  //setting sign through setmethod
        this.chrSign=pcharacter;
    }
    public char getSign(){//returns the sign
        return chrSign;
    }
    public String toString(){//to string method to prinout the outer lair of the egg
        return ("  __ ")+"\n"+
        (" /"+getSign()+getSign()+"\\")+"\n"+
        ("/"+getSign()+getSign()+getSign()+getSign()+"\\")+"\n"+
        ("|"+getSign()+getSign()+getSign()+getSign()+"|")+"\n"+
        ("\\"+"____"+"/");
    }
    public static void main(String[]args){//main method
        EasterEgg object=new EasterEgg();//object with no parameter
        System.out.println(object);
        object.setSign('$');//set sign
        System.out.println(object);
        object.setSign('%');//set sign
        System.out.println(object);
        EasterEgg object1=new EasterEgg('+');//new obj with parameter
        System.out.println(object1);

        
    }
}