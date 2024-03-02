import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeServer {
    public static void main(String[] args) {
        try {
            
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create a PrintWriter to send data to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Get the current date and time
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateTimeStr = dateFormat.format(now);

                // Send the date and time to the client
                out.println(dateTimeStr);

                clientSocket.close();
                System.out.println("Connection closed with client.");
                serverSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
