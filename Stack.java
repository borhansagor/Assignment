package kaderTask7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* I declare that all materials in this assessment task is my own work, except where there is a clear acknowledgment 
 * or reference to the work of others. I further declare that I have compiled with and agree to abide by, the UIS Academic Integrity Policy at the University
 * Website. https://www.uis.edu/academicintegrity
 * Author's Name: Borhan Kader UIN-672595290 Date: 07/22/2018
 */

public class kaderTask7 
{
	
			
	
	
	public static void main(String [] args)
	{
		Scanner scan= new Scanner(System.in);
		
		boolean play=true;//Determinant for continue or quit menu
		char input;// user input for char A B C or D
		
		while(play)
		{
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Please Choose your option\n");
		System.out.println("A- Evaluate PostFix Expression");
		System.out.println("B-Infix to PostFix format then PostFix Evaluation");
		System.out.println("C-Display" +" hangman.txt"+" words");
		System.out.println("D-Exit");
		
		
		 input= scan.nextLine().charAt(0);
		
		
		switch(input)//switch menu
		{
		case 'A':
		case 'a':
			//asks user for postfix input then evaluates
			System.out.println("PostFix: Example format 1 2 3 + * (Please put a space after each token for accurate evaluation)");
			String postfixInput=scan.nextLine();
			String [] array= postfixInput.split("\\s+");
			displayEvaluation(array);
			break;
			
		case 'B':
		case 'b':
			//infix to postfix evaluation
			infix2postFix();
			break;
			
		case 'C':
		case 'c':
			//displays hangman list, and the times for iterator and get(index)
			displayList();
			iteratorTime();
			getIndexTime();
			
			break;
		case 'D':
		case 'd':
			//closes scanner and ends loop
			scan.close();
			play=false;
			
			}
		}
	
	}
	
	
	//method to stream in a hangman.txt file then format it so that list is printed 4 words per line separated by tab
	public static void displayList()
	{
		File file= new File("hangman.txt");
		LinkedList <String> array=new LinkedList<String>();
		try
		{
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine())
			{
				array.add(scan.nextLine());
			}
			scan.close();
		}
		catch(FileNotFoundException exception)
		{
			
		}
		
		ListIterator<String> iterator= array.listIterator();
		Collections.reverse(array);
		
			
	while(iterator.hasNext())
	{	
		String first="";
		String second="";
		String third="";
		String fourth="";
		if(iterator.hasNext())
		{
		 first= iterator.next();
		}
		if(iterator.hasNext())
		{
		 second =iterator.next();
		}
		if(iterator.hasNext())
		{	
		 third=iterator.next();
		}
		if(iterator.hasNext())
		{	
		 fourth=iterator.next();
		}
		System.out.println("\n"+first +"\t"+ second+"\t" + third+"\t" +fourth);
				
	}
	
	}
	
	
	//takes in array of string as parameter then evaluates postfix expression
	public static void displayEvaluation(String [] array)
	{

		
		Stack <Integer> stack=new Stack <Integer>();
		int result=0;
		
		
		for(int i=0; i <array.length;i++)
		{
			
			
			switch(array[i])
			{
			
			case "+":
				result=stack.elementAt(stack.size()-2)+stack.elementAt(stack.size()-1);
				
				
				
				if(!stack.isEmpty())
					stack.pop();
					stack.pop();
					stack.push(result);
				
				
				break;
			case "-":
				result=stack.elementAt(stack.size()-2)-stack.elementAt(stack.size()-1);
				
				
				if(!stack.isEmpty())
					stack.pop();
					stack.pop();
					stack.push(result);
					
				break;
			case "*":
				result=stack.elementAt(stack.size()-2)*stack.elementAt(stack.size()-1);
				
				
				if(!stack.isEmpty())
					stack.pop();
					stack.pop();
					stack.push(result);
					
				break;
			case"/":
				result=stack.elementAt(stack.size()-2)/stack.elementAt(stack.size()-1);
				
				
				if(!stack.isEmpty())
					stack.pop();
					stack.pop();
					stack.push(result);
					
				break;
				default:
					try
					{
						int value=Integer.parseInt(array[i]);
						stack.push(value);
						
					}
					catch(NumberFormatException e)
					{
						
						
					}
					break;
			
			
				}
			
			}
		System.out.println("EVALUATION: "+result);	
		
		}
	
	
	//asks user for infix expression then evaluates the expression into postfix expression then calls the displayEvaluation method to 
	//evaluate and printout evaluation
	public static void infix2postFix()
	{
		
		Stack <String> stack= new Stack<String>();
		@SuppressWarnings("resource")
		Scanner scan= new Scanner(System.in);
		
		
		System.out.println("Infix: Example format ( 2 + 3 ) * 3 (Please put a space after each token for accurate evaluation) ");
		
		String prefixString=scan.nextLine();
		
		
		String [] prefixArray= new String [prefixString.length()];
		prefixArray=prefixString.split("\\s+");
		
		ArrayList <String> result=new ArrayList<String>();
		String [] resultArray=new String [result.size()];
		
		for(int i=0; i<prefixArray.length;i++)
		{
			
			
			switch(prefixArray[i])
			{
			
			case "(":
				stack.push(prefixArray[i]);
				
				break;
			case ")":
				while (!stack.isEmpty() && stack.indexOf(stack.peek()) != stack.indexOf("("))
					
                    result.add(stack.pop());
					stack.remove(stack.indexOf("("));
			
				break;
				
			case"+":
				
				if(!stack.isEmpty()&&prec(prefixArray[i])<=prec(stack.peek()))
				{
					
					result.add(stack.pop());
				}
				stack.push(prefixArray[i]);
				
				break;
			case "-":
				if(!stack.isEmpty()&&prec(prefixArray[i])<=prec(stack.peek()))
				{
					
					result.add(stack.pop());
				}
				stack.push(prefixArray[i]);
				
				break;
			case "*":
				if(!stack.isEmpty()&&prec(prefixArray[i])<=prec(stack.peek()))
				{
					
					result.add(stack.pop());
				}
				stack.push(prefixArray[i]);
				
				break;
			case "/":
				if(!stack.isEmpty()&&prec(prefixArray[i])<=prec(stack.peek()))
				{
					
					result.add(stack.pop());
				}
				stack.push(prefixArray[i]);
				
				break;
				default:
					result.add(prefixArray[i]);

			}
			
		}
		
		
		while(!stack.isEmpty()&&stack.indexOf(stack.peek()) != stack.indexOf("("))
		{	
			result.add(stack.pop());
		}
		
		resultArray=result.toArray(resultArray);
		System.out.println("PostFix Format "+Arrays.toString(resultArray));
		
		displayEvaluation(resultArray);
		
	}
	
	//helper method for precedence used in infix2postFix method
	static int prec(String ch)
	{
		switch(ch)
		{
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 2;
		case "(":
			return 0;
		}
		return -1;
		
	}
	
	//method to test out time required for using iterator for linkedlist
	public static void iteratorTime()
	{	
		File file= new File("hangman.txt");
		LinkedList <String> array=new LinkedList<String>();
		try
		{
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine())
			{
				array.add(scan.nextLine());
			}
			scan.close();
		}
		catch(FileNotFoundException exception)
		{
			
		}
		
		ListIterator<String> iterator= array.listIterator();
		Collections.reverse(array);
		
		
		
		
		long startTime= System.nanoTime();
		while(iterator.hasNext())
		{
			iterator.next();
		}
		
		long approxTime = System.nanoTime() - startTime;
		System.out.println("Iterator.next() time "+approxTime);
		
		
	}
	
	//method to test time for traversing using .get(index) method for linkedlist
	public static void getIndexTime()
	{
		File file= new File("hangman.txt");
		LinkedList <String> array=new LinkedList<String>();
		try
		{
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine())
			{
				array.add(scan.nextLine());
			}
			scan.close();
		}
		catch(FileNotFoundException exception)
		{
			
		}
		long startTime= System.nanoTime();
		for(int i=0; i <array.size();i++)
		{
			array.get(i);
			
		}
		long approxTime = System.nanoTime() - startTime;
		System.out.println("get(index) time: "+approxTime);
		
		
		
	}
	
}
	