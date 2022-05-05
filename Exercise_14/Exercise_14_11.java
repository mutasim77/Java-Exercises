import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*

(Paint a smiley face) Write a program that paints a smiley face, as shown in
Figure 14.46a.

*/


public class Task_14_11 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //Head
        Circle circle = new Circle(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        //The Right Eye
        Circle c2 = new Circle(20);
        c2.setCenterY(160);
        c2.setCenterX(160);
        c2.setFill(Color.WHITE);
        c2.setStroke(Color.BLACK);

        //The Left Eye
        Circle c1 = new Circle(14);
        c1.setCenterY(160);
        c1.setCenterX(160);

        //Right Eye
        Circle c3 = new Circle(20);
        c3.setCenterY(160);
        c3.setCenterX(245);
        c3.setFill(Color.WHITE);
        c3.setStroke(Color.BLACK);

        //Left Eye
        Circle c4 = new Circle(14);
        c4.setCenterY(160);
        c4.setCenterX(245);

        //Nose
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{25.0, 10.0, 15.0, 35.0, 35.0, 35.0});
        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.WHITE);

        //Smile
        Arc arc = new Arc();
        arc.setStroke(Color.BLACK);
        arc.setFill(Color.WHITE);
        arc.setRadiusY(25);
        arc.setRadiusX(45);
        arc.setCenterX(200);
        arc.setCenterY(240);
        arc.setStartAngle(180.0f);
        arc.setLength(180);

        //Text
        Text text = new Text("Hello World!");
        text.setX(170);
        text.setY(330);

        //Add all in pane and StackPane
        Pane pane = new Pane();
        pane.getChildren().addAll(c2, c1, c3, c4, arc, text);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(circle, pane, polygon);

        stage.setScene(new Scene(stackPane, 400,400));
        stage.show();
    }
}
