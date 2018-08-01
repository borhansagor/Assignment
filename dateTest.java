package kaderTask1;



/* Changes that were made to this class, added method call setYear(year) setMonth(month) setDay(day) under the MyDate(int year, int month, int day) Constructor.
 * Adding additional requirements to setMethods for year, month and day so that month can not be >12 and day cannot be >31
 * new String method created getTime(), that at first turns int values of set day, year, month to a String date ,then parse in that String to a Date object so can use Date.compareTo() method with another created Date object currentDate that
 * gives the current date. if statement added to see if date passes currentDate if so set date to currentDate else return a String object of date via format.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class dateTest {
	  public static void main(String[] args) {
	    MyDate date = new MyDate();
	    System.out.println("year: " + date.getYear());
	    System.out.println("month: " + date.getMonth());
	    System.out.println("day: " + date.getDay());
	    
	    date = new MyDate(561555550000L);
	    System.out.println("year: " + date.getYear());
	    System.out.println("month: " + date.getMonth());
	    System.out.println("day: " + date.getDay());
	    
	  }
	}

	class MyDate {
	  private int year;
	  private int month;
	  private int day;
	  
	  
	  MyDate() {    
	    GregorianCalendar date = new GregorianCalendar();
	    // Find year, month, and day from date. You write your own code to replace the out-dated get methods
	   
	    year = date.get(Calendar.YEAR);
	    month = date.get(Calendar.MONTH);
	    day = date.get(Calendar.DAY_OF_MONTH);
	  }
	  
	  MyDate(long elapsedTime) {   
	    GregorianCalendar date = new GregorianCalendar();
	    date.setTimeInMillis(elapsedTime);
	    // Find year, month, and day from date. You write your own code to replace the out-dated get methods
	    year = date.get(Calendar.YEAR);
	    month = date.get(Calendar.MONTH);
	    day = date.get(Calendar.DAY_OF_MONTH);
	  }
	    
	  MyDate(int year, int month, int day) {
	    setYear(year);
	    setMonth(month);
	    setDay(day);
	  }
	  
	  public int getYear() {
	    return year;
	  }

	  public int getMonth() {
	    return month;
	  }
	  
	  public int getDay() {
	    return day;
	  }
	  
	  public void setYear(int year) 
	  {
		  GregorianCalendar date = new GregorianCalendar();
		  if(year>date.get(Calendar.YEAR))
		  this.year=date.get(Calendar.YEAR);
		  else{
			  this.year=year;
		  }
	  }
	  
	  public void setMonth(int month) 
	  {		
		  if(month>12)
		  this.month=12;
		  else{
			  this.month=month;
		  }
	  }
	  
	  public void setDay(int day) 
	  {		if(day>31)
		  this.day=31;
	  else{
		  this.day=day;
	  }
	  } 
	  public String getTime() throws ParseException
	  {
		  String date=this.month+"/"+this.day+"/"+this.year;
		  SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		  Date date1 = format.parse(date);
		  Date currentDate= new Date();
		  if(date1.compareTo(currentDate)>0)
		  {
			  date1=currentDate;
		  }
		  DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		  String dateFinal=df.format(date1);
		  return dateFinal;
	  }
	  
	  
	  

}