/*

(The Person, Student, Employee, Faculty, and Staff classes) Design a class named Person and its
two subclasses named Student and Employee. Make Faculty and Staff subclasses of Employee. A person
has a name, address, phone number, and email address. A student has a class status (freshman, sophomore, junior, or senior).
Define the status as a constant. An employee has an office, salary, and date hired. Use the MyDate class defined in Programming
Exercise 10.14 to create an object for date hired. A faculty member has office hours and a rank. A staff member has a title.
Override the toString method in each class to display the class name and the person’s name.

Draw the UML diagram for the classes and implement them. Write a test pro- gram that creates a Person, Student,
Employee, Faculty, and Staff, and invokes their toString() methods.

*/

public class forTest {
    public static void main(String[] args) {
        Person person = new Person("Jack", "USA", "+1254923879", "jack@gmail.com");
        System.out.println("\tPerson:"+person.toString());

        Employee employee = new Employee("Amanda", "London", "+34524512", "amanda@bk.com",5,1550);
        System.out.println("\n\tEmployee:"+employee.toString());

        Faculty faculty =  new Faculty("Engineering", "SDU", "87872683712","sdu@gmail.com",302,2000,"Monday in 3 o'clock", "PHD");
        System.out.println("\t\nFaculy:"+faculty.toString());

        Staff staff = new Staff("Hector", "Argentina", "+423487923", "hector@yahoot.com", 34, 1000.32,"Staff");
        System.out.println("\t\nStaff:"+staff.toString());
    }
}
