import java.util.*;

/*
(Remove duplicates) Write a method that removes the duplicate elements from an array list of integers using the following header:

public static void removeDuplicate(ArrayList<Integer> list)

Write a test program that prompts the user to enter 10 integers to a list and dis-
plays the distinct integers separated by exactly one space.

*/

/* for testing 34 5 3 5 6 4 33 2 2 4 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter ten numbers: ");
        for (int i = 0; i < 10; i++) {
            numbers.add(in.nextInt());
        }

        removeDuplicate(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i)  + " ");
        }

    }

    public static void removeDuplicate(ArrayList<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
    }

}
