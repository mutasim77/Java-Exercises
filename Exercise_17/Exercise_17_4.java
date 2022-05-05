import java.io.*;
import java.util.Scanner;

/*

(Convert a text file into UTF) Write a program that reads lines of characters from a text
file and writes each line as a UTF-8 string into a binary file. Display the sizes of the text
file and the binary file. Use the following command to run the program:
java Exercise17_04 Welcome.java Welcome.utf

*/


public class Task_17_4 {
    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);

        if(file.exists()){
            Scanner in = new Scanner(file);
            DataOutputStream out = new DataOutputStream(new FileOutputStream(args[1]));

            while (in.hasNext()){
                out.writeUTF(in.nextLine());
            }
            out.close();
            in.close();

            System.out.println("\n"+args[0] + " size is " + file.length() + " bytes");
            System.out.println(args[1] + " size is " + out.size() + " bytes\n");

        }else
            System.out.println("File not found!");

    }
}
