/*Borhan Sagor
COSC 1336
switch practice
importing java util then having a counter for index and intializing its value to 0; then creating counters for each vowel along with a non vowel counter and setting 
them to 0; then creating a while loop that doesn't end until the intindex is equal to the word length that is system input by user;finally putting a switch
statement within the while loop that determines whether the .charAt(intindex) is a vowel or non vowel for both upper and lower cases. and incrementing intindex everytime
finally printing out the results.*/



import java.util.*;

public class Switch{
public static void main(String[]args){

Scanner scan=new Scanner(System.in);
System.out.println("Type a word..");
String word=scan.next();//user input
int intIndex=0;
int intACounter=0;
int intECounter=0;//initial values of counters
int intICounter=0;
int intOCounter=0;
int intUCounter=0;
int intNotVowelCounter=0;




while (intIndex < word.length()){//condition

    switch(word.charAt(intIndex))//each character of the index
    {
        case 'a':
        case 'A':
            intACounter++;
            break;
        case 'e':
        case 'E':
            intECounter++;
            break;
        case 'i':
        case 'I':
            intICounter++;
            break;
        case 'o'://cases and if found ++
        case 'O':
            intOCounter++;
            break;
        case 'u':
        case 'U':
            intUCounter++;
            break;
        
        default:
            intNotVowelCounter++;
            break;
        }

    intIndex++;//incrementing index each time 
        }
    System.out.println("a: "+intACounter);
    System.out.println("e: "+intECounter);
    System.out.println("i: "+intICounter);
    System.out.println("o: "+intOCounter);///printing out results
    System.out.println("u: "+intUCounter);
    System.out.println("non vowel letters : "+intNotVowelCounter);
    }


}