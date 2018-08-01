package kaderTask1;


public class Student extends Person {
	
	//constant Status for Student class
	final String FRESHMEN="Freshmen";
	final String SOPHOMORE="Sophomore";
	final String JUNIOR="Junior";
	final String SENIOR="Senior";
	private String status;
	
	//Class Constructor with No Parameter
	public Student()
	{
		
		this.status="No Status";
		
	
	}
	//Class constructor with multiple Parameter, also compares strings to determine status of student
	public Student(String name,String status)
	{
		if(status.compareToIgnoreCase(FRESHMEN)==0)
		{
			this.status=status;
		}
		else if(status.compareToIgnoreCase(SOPHOMORE)==0)
		{
			this.status=status;
		}else if(status.compareToIgnoreCase(JUNIOR)==0)
		{
			this.status=status;
		}else if(status.compareToIgnoreCase(SENIOR)==0){
			this.status=status;
		}else{
			this.status="No Status";
		}
		setName(name);//sets name
	}
	
	//@override toString, getName() call from parent class with the status
	public String toString()
	{
		return (status.compareToIgnoreCase(FRESHMEN)==0)?getClass().getSimpleName()+ " Name: "+getName()+"\nStatus: Freshmen"
				:(status.compareToIgnoreCase(SOPHOMORE)==0)?getClass().getSimpleName()+ " Name: "+getName()+"\nStatus: Sophomore"
				:(status.compareToIgnoreCase(JUNIOR)==0)?getClass().getSimpleName()+ " Name: "+getName()+"\nStatus: Junior"
				:getClass().getSimpleName()+ " Name: "+getName()+"\nStatus: Senior";
	}
	
	
	
	
}
