import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*

(Revise Listing 30.1) Rewrite Listing 30.1 to display the output in a text area, as shown in Figure 30.30.

*/


public class Task_30_1 extends Application {
    public static TextArea textArea = new TextArea();
    @Override
    public void start(Stage stage) throws Exception {
        ScrollPane scrollPane = new ScrollPane(textArea);

        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        thread2.start();
        thread1.start();
        thread3.start();

        stage.setScene(new Scene(textArea, 400 ,200));
        stage.show();

    }
}
class PrintChar extends Task_30_1 implements Runnable{
    private char charToPrint;
    private int times;
    public PrintChar(char c, int t){
        charToPrint = c;
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            synchronized (textArea){
                textArea.appendText(charToPrint + "");
            }
        }
    }
}

class PrintNum extends Task_30_1 implements Runnable{
    private int lastNum;

    public PrintNum(int n){
        lastNum = n;
    }

    @Override
    public void run() {
        for (int i = 0; i <= lastNum ; i++) {
            synchronized (textArea){
                textArea.appendText(" " + i);
            }
        }
    }
}

