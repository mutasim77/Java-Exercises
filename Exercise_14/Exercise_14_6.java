import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*

Game: display a checkerboard) Write a program that displays a checkerboard in which each white and black
cell is a Rectangle with a fill color black or white, as shown in Figure 14.44c.

*/


public class Task_14_6 extends Application {
    private GridPane pane;
    private int a = 0;

    @Override
    public void start(Stage stage) throws Exception {
        pane = new GridPane();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Rectangle rectangle = new Rectangle(50, 50, 50, 50);
                if (a % 2 != 0) {
                    rectangle.setFill(Color.BLACK);
                    pane.add(rectangle, i, j);
                }
                a++;
            }
        }
        stage.setScene(new Scene(pane, 300,300));
        stage.show();
    }
}
