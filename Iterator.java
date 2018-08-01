/* I declare that all materials in this assessment task is my own work, except where there is a clear acknowledgment 
 * or reference to the work of others. I further declare that I have compiled with and agree to abide by, the UIS Academic Integrity Policy at the University
 * Website. https://www.uis.edu/academicintegrity
 * Author's Name: Borhan Kader UIN-672595290 Date: 07/29/2018
 */


package kaderTask8;
import java.text.SimpleDateFormat;
import java.util.*;





public class kaderTask8 {
	
	//static ints to keep output counters for both Fibonacci and Prime Numbers, and static Final Times to keep incrementing time
	static int fibCallCounter;
	static int primeCallCounter;
	static int fibOutputCounter;
	static int primeOutputCounter;
	
	static long fibFinalTime;
	static long primeFinalTime;
	
	
	public static void main(String[] args) {
		  
		 
		//Date format to format time to hour minute and second 
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		 //current local time 
		 Date currentTime = new Date();
		 String startTime = formatter.format(currentTime); 
		
		
		
		 boolean play=true;//counter for menu
		 Scanner scan= new Scanner(System.in);
		 //start/end time for Fibonacci and Prime initialization
		 long fibStartTime=0;
		 long fibEndTime=0;
		 long primeStartTime=0;
		 long primeEndTime=0;
		 
		 
		 
		 
		 while(play)
		 {
			 System.out.println("Select an option ");
			 System.out.println("Press (1) for Fibonacci number iterator ");
			 System.out.println("Press (2) for Prime number iterator ");
			 System.out.println("Press (3) to exit ");
			 
			 int input=scan.nextInt();
			 
			 switch(input)
			 {
			 case 1:
				 
				 fibCallCounter++;//keeps counter for number of usage by user
				 System.out.println("Enter max number for Fibonacci iterator ");
				 
				 int fibInput=scan.nextInt();//max number input by user
				 ArrayList<Integer> fibList=new ArrayList<Integer>();//ArrayList to hold output
				 FibonacciIterator fibIterator= new FibonacciIterator(fibInput);
				 fibStartTime=System.nanoTime();//starts the time for this operation
				 
				 while(fibIterator.hasNext())
				 {
					 fibList.add(fibIterator.next());
					 fibOutputCounter++;//number of individual output
				 }
				 Collections.reverse(fibList);//reversing list in descending order
				 System.out.println("Fibonacci Series: "+fibList.toString()+"\n");//display result
				 fibEndTime=System.nanoTime();//ending time for operation
				 break;
			 case 2:
				 
				 primeCallCounter++;//keeps counter for number of usage by user
				 System.out.println("Enter max number for Prime iterator ");
				 
				 int primeInput=scan.nextInt();//max number input by user
				 ArrayList<Integer> primeList=new ArrayList<Integer>();//ArrayList to hold output
				 PrimeIterator pIterator= new PrimeIterator(primeInput);
				 primeStartTime=System.nanoTime();//starts the time for this operation
				 
				 while(pIterator.hasNext())
				 {
					 primeList.add(pIterator.next());
					 primeOutputCounter++;//number of individual output
				 }
				 System.out.println("Prime Series: "+primeList.toString()+"\n");//display result
				 primeEndTime=System.nanoTime();//ending time for operation
				 
				 break;
			 case 3:
				 scan.close();//close scanner
				 fibFinalTime=fibEndTime-fibStartTime;//total time required at Fibonacci operation(s)
				 primeFinalTime=primeEndTime-primeStartTime;//total time required at Prime operation(s)
				 
				 Date end=new Date();//current local time 
				 String endTime=formatter.format(end);
				 System.out.println(fibCallCounter+ " Fibonacci commands yielding "+fibOutputCounter+" individual outputs requiring "+fibFinalTime+" (ns)");
				 System.out.println(primeCallCounter+ " Prime commands yielding "+primeOutputCounter+" individual outputs requiring "+primeFinalTime+" (ns)");
				 System.out.println("Program started at "+startTime+" and terminated at "+endTime);
				 play=false;//exit out
				 break;
			 }
			 
			 
		 }
		 
	 }
	
	
	
	//Fibonacci Number Iterator that implements the Iterator Interface
	 @SuppressWarnings("rawtypes")
	static class FibonacciIterator implements Iterator
	{
		
		int maxnum;
		int current=1;
		int previous=-1;
		public FibonacciIterator(int num)
		{
			this.maxnum=num;
		}
		@Override
		public boolean hasNext() {
			
			int temp=current;
			current+=previous;
			previous=temp;
			
			if(current>maxnum)
			return false;
			else
				return true;
		}

		@Override
		public Integer next() {
			
			return current;
		}
		
	}
	//End of method
	

	 
	//Helper method that is being called in PrimeIterator class to determine if number is Prime 
	static boolean isPrime(int n)
	{
		if(n<2)
			return false;
		for(int i=2;i<n;i++)
		{
			if(n==2)
				return true;
		
			else if(n%i==0)
				return false;
		}
		 return true;
	}
	//End of Method
	
	
	
	//Prime Number Iterator that takes max number as input in class constructor and implements Iterator Interface
	@SuppressWarnings("rawtypes")
	static class PrimeIterator implements Iterator
	{
		int max;
		int limit=0;
		public PrimeIterator(int n)
		{
			this.max=n+1;//offset
		}
		@Override
		public boolean hasNext() 
		{
				max--; 

				while (max>2)
				{
					if (isPrime(max))
						break;

					max--;
				}
            
				if (max < 2)
					return false;
				else
					return true;
		}

		@Override
		public Integer next() 
		{
			return max;
		}
	}
	//End of Prime Iterator class
 
}
