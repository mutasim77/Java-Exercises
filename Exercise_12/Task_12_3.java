import java.util.Scanner;

/*

(ArrayIndexOutOfBoundsException) Write a program that meets the fol- lowing requirements:
■ Creates an array with 100 randomly chosen integers.
■ Prompts the user to enter the index of the array, then displays the corre-
sponding element value. If the specified index is out of bounds, display the message Out of Bounds.

*/

public class Task_12_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        try {
            int a = in.nextInt();
            System.out.println(arr[a] + " is at index " + a);

        }catch (ArrayIndexOutOfBoundsException e ){
            System.out.println("Out of Bounds");
        }
    }
}
