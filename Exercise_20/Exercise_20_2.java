import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;


/*

(Store numbers in a linked list) Write a program that lets the user enter num- bers from a graphical
user interface and displays them in a text area, as shown in Figure 20.17a. Use a linked list to store
the numbers. Do not store duplicate num- bers. Add the buttons Sort, Shuffle, and Reverse
to sort, shuffle, and reverse the list.

*/


public class Task_20_2 extends Application {
    private LinkedList<Integer> list = new LinkedList<>();
    private TextArea textArea = new TextArea();
    private TextField textField  = new TextField();
    @Override
    public void start(Stage stage) throws Exception{
        textField = new TextField();
        Label label = new Label("Enter a number ", textField);
        label.setContentDisplay(ContentDisplay.RIGHT);

        textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);

        Button s = new Button("Sort");
        Button sh = new Button("Shuffle");
        Button r = new Button("Reverse");

        HBox hBox = new HBox(7);
        hBox.getChildren().addAll(s, sh, r);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(label);
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(hBox);

        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                list.addLast(Integer.parseInt(textField.getText()));
                displayText();
                textField.clear();
            }
        });

        //Sorting
        s.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.sort(list);
                displayText();
            }
        });

        //Shuffling
        sh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.shuffle(list);
                displayText();
            }
        });

        //Reverse
        r.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.sort(list, Collections.reverseOrder());
                displayText();
            }
        });



        stage.setScene(new Scene(borderPane, 400,150));
        stage.show();

    }
    private void displayText() {
        String output = "";

        for (int i = 0; i< list.size(); i++){
            output += list.get(i) + "   ";
        }

        //delete duplicate numbers
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i +1 ; j < list.size(); j++) {
                if(list.get(i) == list.get(j)){
                    list.remove(j);
                }
            }
        }

        textArea.setText(output);
        textField.setText("");
    }

}
