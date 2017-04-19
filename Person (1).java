/*Borhan Sagor
COSC 1336
Psuedo Code: Creating a new class called Person, and defining methods within it by using setter and getter, finally having a setter and getter that puts the accumulative 
methods of individual setters and getters*/
public class Person {
    private String strFirstName = "";
    private String strLastName = "";
    private String strMiddleName = "";
    private int intBirthYear = 95;
    private int intBirthMonth = 1;
    private int intBirthDay = 1;
    private char chrGender = ' ';
    private int intHeightIN = 72;
    private int intWeightLBS = 165;

    public void setintBirthYear(int pintBirthYear){//setting up perimeter
        this.intBirthYear=pintBirthYear;//birthyear now equates to setvalue
    }
    public int getintBirthYear(){
        return this.intBirthYear;
    }
    public void setintBirthMonth(int pintBirthMonth){//perimeter
        this.intBirthMonth=pintBirthMonth;
    }
    public int getintBirthMonth(){
        return this.intBirthMonth;
    }
    public void setBirthDay(int pintBirthDay){//perimeter
        this.intBirthDay=pintBirthDay;
    }
    public int intgetBirthDay(){
        return this.intBirthDay;
    }
    public void setchrGender(Character pchrGender){//perimeter
        this.chrGender=pchrGender;
    }
    public Character getchrGender(){
        return this.chrGender;
    }
    public void setHeightIN(int pintHeightIN){//perimeter
        this.intHeightIN=pintHeightIN;
    }
    public String getHeightIN(){
        return this.intHeightIN+" INCH";//adding "INCH" so switching to String variable
    }
    public void setWeightLBS(int pintWeightLBS){//perimeter
        this.intWeightLBS=pintWeightLBS;
    }
    public String getWeightLBS(){
        return this.intWeightLBS+" LBS";//swtichign to String variable
    }

    public void setFirstName(String pstrFirstName) {//perimeter]
        this.strFirstName = pstrFirstName;
    }
    public String getFirstName() {
        return this.strFirstName;
    }

    public void setLastName(String pstrLastName) {//perimeter
        this.strLastName = pstrLastName;
    }
    public String getLastName() {
        return this.strLastName;
    }

    public void setMiddleName(String pstrMiddleName) {//perimeter
        this.strMiddleName = pstrMiddleName;
    }
    public String getMiddleName() {
        return this.strMiddleName;
    }
    public void setBirthDay(int pintBirthMonth,int pintBirthDay, int pintBirthYear){//accumulative methods under one function
        this.setintBirthMonth(pintBirthMonth);
        this.setBirthDay(pintBirthDay);
        this.setintBirthYear(pintBirthYear);
    }
    public String getBirthDate(){//accumulative get methods under one function
        return this.getintBirthMonth()+"/"+this.intgetBirthDay()+"/"+this.getintBirthYear();
    }

    public String getName() { //accumulative get methods under one function
        return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();
    }

    public void setName(String pstrFirstName, //accumulative methods under one function
                            String pstrMiddleName,
                            String pstrLastName) {
        this.setFirstName(pstrFirstName);
        this.setMiddleName(pstrMiddleName);
        this.setLastName(pstrLastName);
    }
}
