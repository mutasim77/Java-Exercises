import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*

(Create a simple calculator) Write a program to perform addition, subtraction, multiplication, and division, as shown in Figure 15.25a.

*/


public class Task_15_4 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField textField1 = new TextField();
        textField1.setMinSize(60,30);
        textField1.setMaxSize(60,30);
        Label label1 = new Label("Number 1: ", textField1);
        label1.setContentDisplay(ContentDisplay.RIGHT);

        TextField textField2 = new TextField();
        textField2.setMinSize(60,30);
        textField2.setMaxSize(60,30);
        Label label2 = new Label("Number 2: ", textField2);
        label2.setContentDisplay(ContentDisplay.RIGHT);


        TextField textField3 = new TextField();
        textField3.setMinSize(60,30);
        textField3.setMaxSize(60,30);
        Label label3 = new Label("Result: ", textField3);
        label3.setContentDisplay(ContentDisplay.RIGHT);


        Button add = new Button("Add");
        Button sub = new Button("Subtract");
        Button multiply = new Button("Multiply");
        Button divide =  new Button("Divide");
        Button close  = new Button("Close");


        HBox hBox2  = new HBox(10);
        hBox2.getChildren().addAll(add, sub, multiply, divide);
        hBox2.setAlignment(Pos.CENTER);

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int a = Integer.valueOf(textField1.getText());
                int b = Integer.valueOf(textField2.getText());

                String s = String.valueOf(a + b);
                textField3.setText(s);
            }
        });

        sub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField3.clear();
                int a = Integer.valueOf(textField1.getText());
                int b = Integer.valueOf(textField2.getText());
                String s = String.valueOf(a - b);
                textField3.setText(s);
            }
        });

        multiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField3.clear();
                int a = Integer.valueOf(textField1.getText());
                int b = Integer.valueOf(textField2.getText());
                String s = String.valueOf(a * b);
                textField3.setText(s);
            }
        });

        divide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField3.clear();
                double a = Double.valueOf(textField1.getText());
                double b = Double.valueOf(textField2.getText());
                String s = String.valueOf(a / b);
                textField3.setText(s);
            }
        });

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });

        HBox hBox1 = new HBox(7);
        hBox1.getChildren().addAll(label1, label2, label3);

        VBox vBox = new VBox(30);
        vBox.getChildren().addAll(hBox1, hBox2, close);

        stage.setScene(new Scene(vBox, 400,150));
        stage.show();
    }
}
