import java.util.PriorityQueue;
import java.util.Queue;

/*

(Perform set operations on priority queues) Create two priority queues,
{"George", "Jim", "John", "Blake", "Kevin", "Michael"} and
{"George", "Katie", "Kevin", "Michelle", "Ryan"}, and find their
union, difference, and intersection.

*/


public class Task_20_10 {
    public static void main(String[] args) {
        Queue <String> queue1 = new PriorityQueue();
        String [] arr = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};

        for (int i = 0; i < arr.length; i++) {
            queue1.add(arr[i]);
        }


        Queue <String> queue2 = new PriorityQueue();
        String [] arr2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};

        for (int i = 0; i < arr2.length; i++) {
            queue2.add(arr2[i]);
        }

        System.out.println("The first SET: "+queue1.toString());
        System.out.println("The second SET: " + queue2.toString());

        System.out.println("Union: "+union(queue1, queue2));
        System.out.println("Difference: "+difference(queue1, queue2));
        System.out.println("Intersection: "+intersection(queue1, queue2));
    }

    public static Queue union(Queue queue1, Queue queue2){
        Queue queue = new PriorityQueue(queue1);
        queue.addAll(queue2);

        return queue;
    }

    public static Queue difference(Queue queue1, Queue queue2){
        Queue queue = new PriorityQueue(queue1);
        queue.removeAll(queue2);

        return queue;
    }
    public static Queue intersection(Queue queue1, Queue queue2){
        Queue queue = new PriorityQueue(queue1);
        queue.retainAll(queue2);

        return queue;
    }
}
