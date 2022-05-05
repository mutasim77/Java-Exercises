import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*

(Store objects and arrays in a file) Write a program that stores an array of the five int values
1, 2, 3, 4, and 5, a Date object for the current time, and the double value 5.5 into the file named Exercise17_05.dat.

*/


public class Task_17_5 {
    public static void main(String[] args) throws IOException {
        int [] arr = {1, 2, 3, 4, 5};
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Exercise17_05.dat"));

        out.writeObject(arr);
        out.writeDouble(5.5);
        out.writeObject(new java.util.Date());
        out.close();
    }
}
