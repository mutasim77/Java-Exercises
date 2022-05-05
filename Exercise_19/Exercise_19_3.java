import java.util.ArrayList;
import java.util.LinkedHashSet;

/*

(Distinct elements in ArrayList) Write the following method that returns a new ArrayList.
The new list contains the non-duplicate elements from the original list.
public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)

*/


public class Task_19_3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> nonDuplicates =  new ArrayList<>();

        int arr [] = {1, 2, 3, 2, 1, 2 , 4, 5, 1, 2, 3 ,7, 7, 2, 1};

        for (int i = 0; i < arr.length ; i++) {
            numbers.add(arr[i]);
        }

        System.out.println("Original list with duplicates: " + numbers.toString());

        nonDuplicates = removeDuplicates(numbers);

        System.out.println("New list without duplicates: " + nonDuplicates.toString());

    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
            LinkedHashSet <E> removeIt = new LinkedHashSet<>(list);
            ArrayList <E> newList = new ArrayList<>(removeIt);

            return newList;
    }

}
