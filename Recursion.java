/* I declare that all materials in this assessment task is my own work, except where there is a clear acknowledgment 
 * or reference to the work of others. I further declare that I have compiled with and agree to abide by, the UIS Academic Integrity Policy at the University
 * Website. https://www.uis.edu/academicintegrity
 * Author's Name: Borhan Kader UIN-672595290 Date: 07/15/2018
 */

package kaderTask6;

import java.util.Scanner;

public class kaderTask6 {

	//static counters to keep count of recursive calls per function 
		static int permutationCounter;
		static int bin2DecCounter;
		static int decimal2HexCounter;
		static int hex2DecimalCounter;

		public static void main(String [] args)
		{	
			long startTime= System.nanoTime(); //current value of the running Java Virtual Machine
			Scanner scan= new Scanner (System.in);
			boolean counter=true;//counter for Main Menu to quit/continue;
			int inputParseInt=0;// used for main Menus switch and parsing userinput in the menu;
			
			while(counter)
			{
				
				System.out.printf("%45s","Menu");
				System.out.println();
				System.out.printf("\n%50s","(1) Permutation of Strings");
				System.out.printf("\n%56s","(2) Binary to Decimal Conversion");
				System.out.printf("\n%53s","(3) Decimal to Hex Conversion");
				System.out.printf("\n%53s","(4) Hex to Decimal Conversion");
				System.out.printf("\n%32s","(5) Quit");
				
				System.out.print("\n\n[WARNING: INPUT LENGTH BIGGER THAN 6 WILL RESULT IN DELAY] INPUT-->");
				
				
			String input= scan.nextLine();//takes userinput as a string;
			
			//parse userinput for Integer if failed back to main menu;
			try
			{
				inputParseInt=Integer.parseInt(input);
				if(inputParseInt<0||inputParseInt>6)//if user selects an invalid option back to main menu;
				{
					continue;
				}
			}
			catch(NumberFormatException e)
			{
				
			}
			
			
			//switch for user selected method usage
			switch(inputParseInt)
			{
			//case 1 calls displayPermutation and prints out result, then breaks to main menu;
			case 1:
				System.out.println("Enter a String for Permutation");
				String PermInput=scan.nextLine();
				System.out.println("---------------------------------------------------------------");	
				displayPermutation(PermInput);
				System.out.println("---------------------------------------------------------------");
				
				break;
			//case 2 calls bin2Dec and prints out result, then breaks to main menu;
			case 2:System.out.println("Enter Binary sequence for decimal format: ");
			String binaryString=scan.nextLine();
			
			//regex so that input consists of only 1 or 0
			if(binaryString.matches("[01]+"))
			
				System.out.println("DECIMAL:"+ bin2Dec(binaryString));
			else
			
				System.err.println(binaryString+ " :NOT A BINARY NUMBER");
			break;
			
			//case 3 calls dec2Hex and prints out result, then breaks to main menu;
			case 3:System.out.println("Enter Decimal Number for Hex format");
			String DeccimalInput=scan.nextLine();
			int DecimalIntInput=0;
			//try/catch for IntegerParse if not display err and back to main menu;
			try
			{
				DecimalIntInput=Integer.parseInt(DeccimalInput);
				
			}
			catch(NumberFormatException e)
			{
				System.err.println(DeccimalInput+ "Not a valid Decimal Value");
			}
			
			System.out.println("Hex: "+dec2Hex(DecimalIntInput));
			break;
			//case 4 calls hex2Dec and prints out result, then breaks to main menu;
			case 4:System.out.println("Enter Hex Number for Decimal format");
			String hexString=scan.nextLine();
			//regex to make sure its a Hexadecimal value, if not err message then main menu;
			if(hexString.matches("-?[0-9a-fA-F]+"))
			System.out.println("Decimal: "+hex2Dec(hexString));
			else
				System.err.println(hexString+" Not a valid Hex value");
			break;
			
			//incase of user quits printout goodbye and number of recursive calls per function and the time elapsed is printed.
			case 5:
			System.out.println("\nGoodbye..");
			System.out.println("\nTotal Recursive Calls for displayPermutation: "+permutationCounter);
			System.out.println("\nTotal Recursive Calls for bin2Dec: "+bin2DecCounter);
			System.out.println("\nTotal Recursive Calls for dec2Hex: "+decimal2HexCounter);
			System.out.println("\nTotal Recursive Calls for hex2Dec: "+hex2DecimalCounter);
			long approxTime = System.nanoTime() - startTime;//approximate Time
			System.out.println("\nTime elapsed :"+approxTime+" nanoseconds");
			scan.close();//close scan;
			counter=false;//end program;
			}
				continue;//back to main menu
			
			}
			
		}

		
		
		
		
		public static void displayPermutation(String s)//method used for calling in main
		{
			
			if(s.length()==0)//check if string is empty, if so print err then system exit to main menu
			{
				System.err.println("NO STRING" );
				System.exit(0);
			}
			
			displayPermutation("",s);
			
		}

		//Helper method for displayPermutation
		private static void displayPermutation(String s1, String s2)
		{
			int length=s2.length();
			
			if(length==0)//base case
			
				System.out.println(s1);
			else
			{
				permutationCounter++;//counter for recursion calls
				for(int i=0;i<length;i++)
					displayPermutation(s1+s2.charAt(i),s2.substring(0,i)+s2.substring(i+1,length));//recursive call 
			}
		}
		
		
		
		//Format for Conversion: First digit in string parsed to int then multiplied by 2 (binary base 2) to the power of length-1, done recursively
		//for remaining digits until length is 0.
		public static int bin2Dec(String s) 
		{

				int len = s.length();
				
			    if (len == 0) return 0;//base case;
			    
			    int firstDigit = Integer.parseInt(s.substring(0,1));
			    String remainingDigit = s.substring(1);
			    bin2DecCounter++;//counter for recursion calls
			    return firstDigit * (int)Math.pow(2, len-1) + bin2Dec(remainingDigit);//recursive call
		}



		//Decimal to Hexadecimal Conversion Method
		 public static String dec2Hex(int value) 
		 {
		        String hexString = "";
		        
		        int remainder = value % 16;

		        if (value == 0) //base case
		            return "";
		        
		            switch (remainder) {
		                case 10:
		                	hexString = "A";
		                    break;
		                case 11:
		                	hexString = "B";
		                    break;
		                case 12:
		                	hexString = "C";
		                    break;
		                case 13:
		                	hexString = "D";
		                    break;
		                case 14:
		                	hexString = "E";
		                    break;
		                case 15:
		                	hexString = "F";
		                    break;
		                default:
		                	hexString +=remainder;
		                    break;
		            }
		            decimal2HexCounter++;//counter for recursion calls
		           
		            return dec2Hex((value / 16)) + hexString;//recursive call
		    }
		 
		 
		 //HexaDecimal to Decimal Conversion Method
		 private static int hex2Dec(String hexString) {
				int value = 0;
				hexString = hexString.toUpperCase();
				int length = hexString.length();
				int firstHexDigit=0;
				if (length == 0) //base case
					return 0;
					
					switch(hexString.charAt(0))
					{
					case '0': firstHexDigit =0;
					break;
					case '1': firstHexDigit =1;
					break;
					case '2': firstHexDigit =2;
					break;
					case '3': firstHexDigit =3;
					break;
					case '4': firstHexDigit =4;
					break;
					case '5': firstHexDigit =5;
					break;
					case '6': firstHexDigit =6;
					break;
					case '7': firstHexDigit =7;
					break;
					case '8': firstHexDigit =8;
					break;
					case '9': firstHexDigit =9;
					break;
					case 'A': firstHexDigit =10;
					break;
					case 'B': firstHexDigit =11;
					break;
					case 'C': firstHexDigit =12;
					break;
					case 'D': firstHexDigit =13;
					break;
					case 'E': firstHexDigit =14;
					break;
					case 'F': firstHexDigit =15;
					break;
					
					
					}
					hex2DecimalCounter++;//counter for recursion calls
					String remainingHexDigits = hexString.substring(1);
					value = firstHexDigit * (int) Math.pow(16, length - 1) + hex2Dec(remainingHexDigits);//recursive call
				
				return value;
			}
		 
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
}
