import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    private DataOutputStream toServer = null;
    private DataInputStream fromServer = null;

    @Override
    public void start(Stage stage) throws Exception {

        StackPane stackPane = new StackPane();
        Label label = new Label();
        label.setStyle("-fx-font-family: monospace; -fx-font-size: 15px");
        stackPane.getChildren().addAll(label);

        Scene scene = new Scene(stackPane, 300, 100);
        stage.setScene(scene);
        stage.show();

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);
            // Socket socket = new Socket("130.254.204.36", 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        }catch (IOException ex) {
            System.out.println(ex);
        }


        try {
            int count = fromServer.readInt();
            label.setText( "You are visitor "+count + "\n");
            stage.setTitle("Client " + count);
        }catch (IOException ex){
            System.out.println(ex);
        }

    }
}
