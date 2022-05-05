import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/*

(Animation: palindrome) Write a program that animates a palindrome swing as shown in Figure 15.31.
Press/release the mouse to pause/resume the animation.

*/


public class Task_15_24 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();

        Arc arc = new Arc(100, 50, 75, 25, 0, -180);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        Circle circle = new Circle(100, 75, 5);
        circle.setFill(Color.RED);

        pane.getChildren().addAll(arc, circle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(arc);
        pt.setNode(circle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        pane.setOnMousePressed(e -> {
            pt.pause();
        });

        pane.setOnMouseReleased(e -> {
            pt.play();
        });

        stage.setScene(new Scene(pane , 300,200));
        stage.show();
    }
}
