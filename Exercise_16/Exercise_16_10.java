import com.example.java2semester.Lessons.ScrollBars;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*

(Text viewer) Write a program that displays a text file in a text area, as shown in Figure 16.40a.
The user enters a file name in a text field and clicks the View button; the file is then displayed in a text area.

*/


public class Task_16_10 extends Application {
    private  String text = "";
    @Override
    public void start(Stage stage) throws Exception {
        TextArea textArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane(textArea);

        TextField textField = new TextField();
        textField.setPrefColumnCount(20);
        Label label = new Label("fileName ", textField);
        label.setContentDisplay(ContentDisplay.RIGHT);
        Button button = new Button("View");
        label.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(label, button);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(scrollPane, hBox);
        vBox.setAlignment(Pos.CENTER);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                File file = new File(textField.getText());

                if(file.exists()){
                    try {
                        Scanner in =  new Scanner(file);
                        while (in.hasNext()){
                            text += in.nextLine();
                            text += "\n";
                        }
                        in.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    textArea.setText(text);
                }
                else {
                    textArea.setText("File not Found!");
                }

            }
        });

        stage.setScene(new Scene(vBox, 500,200));
        stage.show();

    }
}
