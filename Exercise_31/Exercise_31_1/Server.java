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

(Loan server) Write a server for a client. The client sends loan informa- tion (annual interest rate, number of years, and loan amount)
to the server (see Figure 31.17a). The server computes monthly payment and total pay- ment, and sends them back to the client
(see Figure 31.17b). Name the client Exercise31_01Client and the server Exercise31_01Server.

*/


public class Server extends Application{
    private TextArea ta = new TextArea();
    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.show();
        ta.setEditable(false);

        new Thread( () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(800);
                ta.appendText("Server started at "+ new Date() + '\n');

                while (true) {
                    Socket socket = serverSocket.accept();

                    clientNo++;

                    Platform.runLater( () -> {
                        ta.appendText("Connected to a client at " + new Date() + '\n');

                    });

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

                    double rate = inputFromClient.readDouble();
                    double year = inputFromClient.readDouble();
                    double loan = inputFromClient.readDouble();


                    double monthlyInterestRate = rate / 1200;
                    double monthlyPayment = loan * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, year * 12)));
                    double totalPayment = monthlyPayment * year * 12;

                    outputToClient.writeDouble(monthlyPayment);
                    outputToClient.writeDouble(totalPayment);

                    Platform.runLater(() -> {
                        ta.appendText("Anual interest Rate " + rate + '\n');
                        ta.appendText("Number of year: " + year + '\n');
                        ta.appendText("Loan Amount: " + loan + "\n");
                        ta.appendText("monthlyPayment: " + monthlyPayment + "\n");
                        ta.appendText("totalPayment: " + totalPayment + "\n");
                    });
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
