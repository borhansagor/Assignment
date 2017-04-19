/*Borhan Sagor
COSC 1336
Pseudo code: Creating a Book class that contains instance variable as private (title,author,publisher,copyRightDate), creating setters and getter methods and finally adding 
a toString() method that converts the coprightDate and spits out as a multilined formatted description of the book.*/

public class Book{
    private String title="";
    private String author="";//private variable to use as different values later on;
    private String publisher="";
    private int copyRightDate=0;

    public void settitle(String ptitle){//setting up perimeter
        this.title=ptitle;
    }
    public String gettitle(){//get method to retrive value;
        return this.title;
    }
    public void setauthor(String pauthor){//setting up perimeter
        this.author=pauthor;
    }
    public String getauthor(){//get method to retrive value;
        return this.author;
    }
    public void setpublisher(String ppublisher){//setting up perimeter
        this.publisher=ppublisher;
    }
    public String getpublisher(){//get method to retrive value;
        return this.publisher;
    }
    public void setcopyRightDate(int pcopyRightDate){//setting up perimeter
        this.copyRightDate=pcopyRightDate;
    }
    public int getcopyRightDate(){//get method to retrive value;
        return this.copyRightDate;
    }
    public String toString(){//method that spits out a formatted info;
        return gettitle()+"\n"+getauthor()+"\n"+getpublisher()+"\n"+getcopyRightDate();
    }
}
