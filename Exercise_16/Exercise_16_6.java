import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*

(Demonstrate TextField properties) Write a program that sets the horizontal- alignment and
column-size properties of a text field dynamically, as shown in Figure 16.38a.

*/


public class Task_16_6 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField("JavaFx");
        Label label = new Label("Text Field", textField);
        label.setContentDisplay(ContentDisplay.RIGHT);
        textField.setPrefColumnCount(12);
        textField.setAlignment(Pos.BOTTOM_CENTER);

        TextField textField2 = new TextField("12");
        Label label2 = new Label("Column size", textField2);
        label2.setContentDisplay(ContentDisplay.RIGHT);
        textField2.setPrefColumnCount(3);
        textField2.setAlignment(Pos.BOTTOM_RIGHT);
        RadioButton right = new RadioButton("Right");
        RadioButton left = new RadioButton("Left");
        RadioButton center = new RadioButton("Center");
        center.setSelected(true);

        ToggleGroup toggleGroup = new ToggleGroup();
        right.setToggleGroup(toggleGroup);
        left.setToggleGroup(toggleGroup);
        center.setToggleGroup(toggleGroup);

        HBox hBox1 = new HBox(7);
        hBox1.getChildren().addAll(left, center, right, label2);

        VBox vBox = new VBox(30);
        vBox.getChildren().addAll(label, hBox1);


        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField.setAlignment(Pos.BOTTOM_RIGHT);
            }
        });

        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField.setAlignment(Pos.CENTER_LEFT);
            }
        });

        center.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField.setAlignment(Pos.BOTTOM_CENTER);
            }
        });
        textField2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER){
                    int a = Integer.valueOf(textField2.getText());
                    textField.setPrefColumnCount(a);
                }
            }
        });

        stage.setScene(new Scene(vBox, 500,100));
        stage.show();
    }
}
