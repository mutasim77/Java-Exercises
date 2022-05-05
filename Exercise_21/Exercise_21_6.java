import java.util.*;

/*

(Count the occurrences of numbers entered) Write a program that reads an unspecified number of integers and
finds the one that has the most occurrences. The input ends when the input is 0. For example,
if you entered 2 3 40 3 5 4 –3 3 3 2 0, the number 3 occurred most often.

*/

public class Task_21_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true){
            int a = in.nextInt();
            if (a == 0)
                break;
            numbers.add(a);
        }
        Collections.sort(numbers);

        int temp = 0;
        for (int i = 0; i < numbers.size() -1; i++) {
            for (int j = i+ 1; j < numbers.size(); j++) {
                if(numbers.get(i) == numbers.get(j)){
                    temp = numbers.get(i);
                }
            }
        }
        System.out.println("The number "+ temp + " occured most often");
    }
}
