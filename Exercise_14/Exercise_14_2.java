import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileInputStream;

/*

(Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as shown in Figure 14.43b. A cell may be X, O, or empty.
What to display at each cell is randomly decided. The X and O are images in the files x.gif and o.gif.

 */

public class Task_14_2 extends Application {
    private GridPane pane;
    @Override
    public void start(Stage stage) throws Exception {
        pane = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ImageView imageX = new ImageView(new Image(new FileInputStream("images/x.png")));
                imageX.setFitWidth(100);
                imageX.setFitHeight(100);
                ImageView imageY = new ImageView(new Image(new FileInputStream("images/o.png")));
                imageY.setFitWidth(100);
                imageY.setFitHeight(100);
                int a = (int)(Math.random() *3);
                System.out.print(a + " ");
                if(a == 0)
                    pane.add(imageX, i, j);
                else if(a == 1)
                    pane.add(imageY, i, j);
                else{}
            }
        }
        stage.setScene(new Scene(pane, 300,300));
        stage.show();
    }
}
