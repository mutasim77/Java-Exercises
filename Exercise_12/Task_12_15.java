import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*

 (Write/read data) Write a program to create a file named Exercise12_15.txt if it does not exist.
 Write 100 integers created randomly into the file using text I/O. Integers are separated by spaces
 in the file. Read the data back from the file and display the data in increasing order.

 */

public class Task_12_15 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> sortNumbers = new ArrayList<>();
        File file = new File("Exercise12_15.txt");

        if(!file.exists()) {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));
            for (int i = 0; i < 100; i++) {
                printWriter.print((int)(Math.random() * 100) + " ");
            }
            printWriter.close();

            Scanner in = new Scanner(file);
            while(in.hasNext()){
                sortNumbers.add(in.nextInt());
            }
            in.close();

            Collections.sort(sortNumbers);
            System.out.println(sortNumbers.toString());

        }else{
            System.out.println("You have file already");

            Scanner in = new Scanner(file);
            while(in.hasNext()){
                sortNumbers.add(in.nextInt());
            }
            in.close();

            Collections.sort(sortNumbers);
            System.out.println(sortNumbers.toString());
        }


    }
}
