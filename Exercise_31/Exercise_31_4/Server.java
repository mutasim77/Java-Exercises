import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/*

(Count clients) Write a server that tracks the number of the clients connected to the server.
When a new connection is established, the count is incremented by 1. The count is stored using a random-access file.
Write a client program thatreceives the count from the server and display a message, such as
You are visi- tor number 11, as shown in Figure 31.19. Name the client Exercise31_04Client and the server Exercise31_04Server.

*/


public class Server extends Application {
    private TextArea ta = new TextArea();
    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new ScrollPane(ta), 400, 200);
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.show();
        ta.setEditable(false);

        new Thread( () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("Server started at "+ new Date() + '\n');

                while (true) {
                    Socket socket = serverSocket.accept();

                    Platform.runLater( () -> {
                      
                        ta.appendText("Starting thread " + (clientNo - 1) + "\n");

                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client IP /" + inetAddress.getHostAddress() + "\n");

                    });

                    clientNo++;

                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch(IOException ex) {
                System.out.println(ex);
            }
        }).start();
    }

    class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try{
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while(true){

                    outputToClient.writeInt(clientNo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
