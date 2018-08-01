/*I declare that all material in this assessment task is my own work except where there is a clear acknowledgement 
 * or reference to the work of others.I further declare that complied with, and agree
 * to abide by, the UIS Academic Integrity Policy at the University website. https://www.uis.edu/academicintegrity
 * Author's name: Borhan Kader UIN: 672595290 Date:06/24/2018
 */





package kaderTask1;

import java.util.*;
public class kaderTask1{
	

	
	public static void main(String args[])
	{
		
		String [] value;
		
		//Sample output with println and typed parameters to be split.
		value=split("q#w?45#","#?");
		System.out.println("Input"+"\n q#w?45# #?");
		System.out.println("Tokenized: ");
		
		for(int i=0;i<value.length;i++)
		{
			
			System.out.println(value[i]);
		}
		
		
		//Read userinput and output string split with delimiters
		Scanner scan=new Scanner(System.in);
		//create input string and delimiter string to be passed on to function.
		System.out.println();
		
		System.out.println("Please enter a String followed by a space denoting the delimiter..");
		String inputString=scan.next();
		String delimiter=scan.nextLine();
		delimiter=delimiter.trim();//trimming extra white space.
		
		if(delimiter.isEmpty())
		{
			System.err.println("Error: Did not provide delimiters..");//In case user doesn't provide delimiters, print an err message then System exit.
			System.exit(0);
			
		}
		
		
		
		value=split(inputString,delimiter);
		
		System.out.println("Tokenized: ");
		for(String s: value)
		{
			System.out.println(s);
		}
		
		
			
	}

  
    /*Purpose of String[] split(String str, String regex) is to implement the regex based split
	and use the positive look behind and positive lookahead regex expression.*/
    
	public static String[] split(String str, String regex)
	{
		 String[] myString = str.split("(?<=[" + regex + "])|(?=[" + regex + "])");
		    return myString;
	
	}

	
}