import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    private DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage stage) throws Exception {


        TextField t1 = new TextField();
        Label label1  = new Label("Annual interest Rate: ");

        TextField t2 = new TextField();
        Label label2 = new Label("Number of year         ");

        TextField t3 = new TextField();
        Label label3  = new Label("Loan Amount               ");

        Button button = new Button("Submit");

        HBox hBox1= new HBox(5);
        hBox1.getChildren().addAll(label1, t1);

        HBox hBox2= new HBox(10);
        hBox2.getChildren().addAll(label2, t2, button);

        HBox hBox3= new HBox(5);
        hBox3.getChildren().addAll(label3, t3);


        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3);

        TextArea textArea = new TextArea();
        ScrollPane scrollPane  = new ScrollPane(textArea);
        textArea.setEditable(false);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox);
        borderPane.setCenter(scrollPane);

        Scene scene = new Scene(borderPane, 350, 200);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();




        button.setOnAction(e -> {
            try {

                double rate = Double.parseDouble(t1.getText());
                double year = Double.parseDouble(t2.getText());
                double loan = Double.parseDouble(t3.getText());

                toServer.writeDouble(rate);
                toServer.writeDouble(year);
                toServer.writeDouble(loan);
                toServer.flush();

//                double area = fromServer.readDouble();
                double monthlyPayment = fromServer.readDouble();
                double total = fromServer.readDouble();

                textArea.appendText("Anual interest Rate " + rate + "\n");
                textArea.appendText("Number of year: "+ year + "\n");
                textArea.appendText("Loan Amount: " + loan + "\n");
                textArea.appendText("monthlyPayment: " + monthlyPayment + "\n");
                textArea.appendText("totalPayment: " + total + "\n");

            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 800);
            // Socket socket = new Socket("130.254.204.36", 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        }catch (IOException ex) {
            textArea.appendText(ex.toString() + '\n');
        }
    }
}
