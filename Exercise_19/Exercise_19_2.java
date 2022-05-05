import java.util.ArrayList;
import java.util.Scanner;

/*

(Implement GenericStack using inheritance) In Listing 19.1, GenericStack is implemented using composition.
Define a new stack class that extends ArrayList.
Draw the UML diagram for the classes and then implement GenericStack.
Write a test program that prompts the user to enter five strings and displays them in reverse order.

*/


public class Task_19_2 <E> extends ArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GenericStack<String> names = new GenericStack<>();

        for (int i = 0; i < 5 ; i++) {
            String s = in.nextLine();
            names.push(s);
        }

        System.out.println("In reverse order: ");
        while (!names.isEmpty()){
            System.out.print(names.pop() + " ");
        }


    }
}
