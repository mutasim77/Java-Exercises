import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*

(Select geometric figures) Write a program that draws various figures, as shown in Figure 16.36b.
The user selects a figure from a radio button and uses a check box to specify whether it is filled.

*/


public class Task_16_2 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(40);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Rectangle rectangle = new Rectangle(100,50,100,50);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        Ellipse ellipse = new Ellipse(60,30);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);

        RadioButton c = new RadioButton("Circle");
        RadioButton r = new RadioButton("Rectangle");
        RadioButton e = new RadioButton("Ellipse");
        CheckBox  check = new CheckBox("Fill");

        ToggleGroup toggleGroup = new ToggleGroup();
        c.setToggleGroup(toggleGroup);
        r.setToggleGroup(toggleGroup);
        e.setToggleGroup(toggleGroup);

        StackPane stackPane = new StackPane();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(c, r, e, check);
        hBox.setAlignment(Pos.CENTER);


        c.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stackPane.getChildren().clear();
                stackPane.getChildren().add(circle);
            }
        });

        r.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stackPane.getChildren().clear();
                stackPane.getChildren().add(rectangle);
            }
        });

        e.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stackPane.getChildren().clear();
                stackPane.getChildren().add(ellipse);
            }
        });

        check.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(check.isSelected()){
                    circle.setFill(Color.BLACK);
                    rectangle.setFill(Color.BLACK);
                    ellipse.setFill(Color.BLACK);
                }else {
                    circle.setFill(Color.WHITE);
                    rectangle.setFill(Color.WHITE);
                    ellipse.setFill(Color.WHITE);
                }
            }
        });


        BorderPane borderPane= new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setCenter(stackPane);

        stage.setScene(new Scene(borderPane, 300,150));
        stage.show();
    }
}
