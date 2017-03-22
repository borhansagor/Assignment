public class Bookshelf{
public static void main(String [] args){
    Book objbook=new Book();
    
    objbook.settitle("A Game of Thrones");
    objbook.setauthor("George R.R. Martin");
    objbook.setpublisher("Bantam Spectra (US) Voyager Books (UK)");
    objbook.setcopyRightDate(2017);
    
    System.out.println(objbook.toString());
    
}
}