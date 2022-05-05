import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.Stack;


/*

(Draw lines using the arrow keys) Write a program that draws line segments using the arrow keys.
The line starts from the center of the pane and draws toward east, north, west, or south when the
right-arrow key, up-arrow key, left- arrow key, or down-arrow key is pressed, as shown in Figure 15.26b.

*/


public class Task_15_9 extends Application {
    private int a = 200;
    private int b = 200;

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();

        pane.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case UP:
                    pane.getChildren().add(new Line(b,a,b,a-10));
                    a -= 10;
                    System.out.println("++");
                    break;
                case DOWN:
                    pane.getChildren().add(new Line(b,a,b,a+10));
                    a += 10;
                    break;
                case LEFT:
                    pane.getChildren().add(new Line(b,a,b-10,a));
                    b -= 10;
                    break;
                case RIGHT:
                    pane.getChildren().add(new Line(b,a,b+10,a));
                    b += 10;
                    break;
            }
        });
        stage.setScene(new Scene(pane, 500,500));
        stage.show();
        pane.requestFocus();
    }
}
