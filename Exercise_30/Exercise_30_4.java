import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*

(Synchronize threads) Write a program that launches 1,000 threads. Each thread adds 1 to a variable sum that initially is 0.
Define an Integer wrapper object to hold sum. Run the program with and without synchronization to see its effect.

*/


public class Task_30_4 {
    private static Integer sum = 0;
    public static void main(String[] args) {

        ExecutorService e = Executors.newFixedThreadPool(1000);

        for(int i = 0; i < 1000; i++){
            e.execute(new Sum());
        }
        e.shutdown();

        // Wait until all tasks are finished
        while(!e.isTerminated()){
        }

        System.out.println(sum);
    }

    private static class Sum implements Runnable{

        @Override
        public void run() {
            m();
        }

        public synchronized void m(){
            sum = sum+1;
        }
    }

}

