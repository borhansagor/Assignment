/* I declare that all materials in this assessment task is my own work, except where there is a clear acknowledgment 
 * or reference to the work of others. I further declare that I have compiled with and agree to abide by, the UIS Academic Integrity Policy at the University
 * Website. https://www.uis.edu/academicintegrity
 /* i declare that all materials in this assessment task is my own work, except where there is a clear acknowledgment 
 * or reference to the work of others. I further declare that I have compiled with and agree to abide by, the UIS Academic Integrity Policy at the University
 * Website. https://www.uis.edu/academicintegrity
 * Author's Name: Borhan Kader UIN-672595290 Date: 06/13/2018
 */

package kaderTask2;
import java.util.*;






public class kaderTask2 {
	
//Sorting algorithm to sort traverse through Integer list and swaps elements of indexes based on their value;
	
	
	public static void sort(ArrayList<Integer> list)
	{
		for(int i=0;i<list.size()-1;i++)
		{	
			
			
			
			for (int j=0;j<list.size()-1;j++ )
			
				if(list.get(j)>list.get(j+1))
				{	
					int temp=list.get(j+1);// Local variable temp created to store j+1;
					
					list.set(j+1, list.get(j));//sets the value of list at index j to index j+1;
					list.set(j, temp);//Sets the value of temp to the value at index j;
				}
		}
	}
	
	
	
	
	
	
	public static void main(String[]args)
	{	
		
		ArrayList <Integer> list =new ArrayList <Integer>();
		Scanner scan= new Scanner(System.in);
		final int num=5;//Constant 5 because specified requirement of asking user for 5 integer inputs;
		
		
		System.out.println("Enter 5 numbers: ");
		for (int i=0;i<num;i++)
		{
			//Implemented to avoid crash in case user inputs something other than integers.
			try
			{
				int input= scan.nextInt();
				list.add(input);
			}
			catch (InputMismatchException e){
				scan.next();
				
			}
				
		}
		
		
		sort(list);//Calls sort method to sort the list
		System.out.println("Your sorted array is: "+ list );
		
		
		//Foreach loop to loop through the list and sum their values;
		int sum=0;
		for(int i:list)
		{
			
			sum+=i;
		}
		System.out.println("\nThe sum of your numbers is: "+ sum);
		
		
		
		 
			
		}
			
		
	}
	
	

	
	
	
	
		
	
	 

