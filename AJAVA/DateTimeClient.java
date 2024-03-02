import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateTimeClient {
    public static void main(String[] args) {
        try {
            
            Socket socket = new Socket("localhost", 12345);

            // Create a BufferedReader to read data from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read and print the date and time received from the server
            String dateTimeStr = in.readLine();
            System.out.println("Date & Time received from server: " + dateTimeStr);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
