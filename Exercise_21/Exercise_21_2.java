import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*

(Display nonduplicate words in ascending order) Write a program that reads words from a text file
and displays all the nonduplicate words in ascending order. The text file is passed as a command-line argument.

*/


public class Task_21_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Task_21_2.txt");
        Scanner in = new Scanner(file);
        String s = "";
        while(in.hasNext()){
            s += in.nextLine();
        }
        in.close();
        String [] arr = s.toString().split(" ");

        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }

        TreeSet<String> words = new TreeSet<>(Arrays.asList(arr));
        System.out.println("\nNon Duplicate: " + words.toString());
    }
}
