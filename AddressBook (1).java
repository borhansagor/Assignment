/*Borhan Sagor
COSC 1336
Creating a new class called Person, and defining methods within it by using setter and getter, finally having a setter and getter that puts the accumulative 
methods of individual setters and getters
UPDATE: implementing the functions created in Person to AddressBook, creating objPersonOne and calling and instantiating the person class. setting varaibles to
correlated values and finally printingout to see if the functions are working.*/
public class AddressBook {

    public static void main(String [] strArgs) {
        Person objPersonOne = new Person();//creating instance of the Person class
        System.out.println(objPersonOne.getName());
        objPersonOne.setFirstName("Chris");
        objPersonOne.setMiddleName("R");
        objPersonOne.setLastName("MacDougald");
        System.out.println(objPersonOne.getName());

        objPersonOne.setName("J","F","K");
        System.out.println(objPersonOne.getName());
        objPersonOne.setBirthDay(12,28,1996);//setting birthdate
        objPersonOne.setWeightLBS(150);//setting weight
        objPersonOne.setHeightIN(170);//setting height
        objPersonOne.setchrGender('M');//setting sex
        System.out.println(objPersonOne.getBirthDate());
        System.out.println(objPersonOne.getWeightLBS());
        System.out.println(objPersonOne.getHeightIN());//printing out getters.
        System.out.println(objPersonOne.getchrGender());
        
    }
}