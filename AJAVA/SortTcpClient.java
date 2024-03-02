import java.io.*;
import java.net.*;

public class SortTcpClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to TCP Server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create PrintWriter to send data to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Enter 10 numbers one by one
            for (int i = 0; i < 10; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                int num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                out.println(num);
            }

            // Read and print the sorted numbers received from the server
            String sortedNumbers = in.readLine();
            System.out.println("Sorted Numbers received from TCP Server: " + sortedNumbers);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
