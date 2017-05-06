/* Borhan Sagor
COSC 1336
using Array to record occurance of userinput
psuedo code: creating a boolean to check if number input is greater than the desired criteria, if so it will be invalid...making an array of 51 values 0-50, putting in a for loop to run 50 times and 
initializing each occurance of number to 0; having a while loop that runs until userinput is -1, and checking using the boolean whether to add the numbers to array or not,by taking in userinput. finally
printing out the number of occurance for each input value.*/


import java.util.Scanner;
public class Array 
{
public static int input = -2;//initializing input variable
public static boolean isValid(int s)
	{
		if(s > 50 || s < -1){ ///boolean to check so that numbers bigger than 50 and less than -1
			return false;
			}else{
		return true;
			}
	}
	
	public static void main(String[] args)
	{
		int[] inputArray = new int[51];// array to have 0-50 inclusive
		//Initialize the Array
		for(int i = 0; i < 51; i++)
		{
			inputArray[i] = 0;//starting value of 0 unless user inputs the value
		}
		Scanner scan = new Scanner(System.in);
		
		while(input != -1)//stops the loop
		{
		   
			if(isValid(input))
			{
				inputArray[input]++;//increments user input
			}
			System.out.println("Please type an integer between 0 and 50. Type '-1' to exit.");
			input = scan.nextInt();
		}
		for(int i = 0; i < 51; i++)
		{
			System.out.println(Integer.toString(inputArray[i]) + " occurrences of " + Integer.toString(i));//number of times occurance of each number
		}
	}
}