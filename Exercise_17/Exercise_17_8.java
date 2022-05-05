import java.io.*;
import java.util.Scanner;

/*

(Update count) Suppose you wish to track how many times a program has been executed.
You can store an int to count the file. Increase the count by 1 each time this program is executed.
Let the program be Exercise17_08 and store the count in Exercise17_08.dat.

*/


public class Task_17_8 {
    public static void main(String[] args) throws IOException {
        File file = new File("Exercise17_08.dat");
            RandomAccessFile r = new RandomAccessFile(file, "rw");
            int count = 0;
            if(r.length() == 0){
                count = 1;
            }else
                count = r.readInt() + 1;
            r.seek(0);
            r.writeInt(count);
            System.out.println("The count is " + count);
    }
}
