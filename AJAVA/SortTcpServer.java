import java.io.*;
import java.net.*;
import java.util.Arrays;

public class SortTcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("TCP Server is waiting for client connection on port 12345...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("TCP Client connected: " + clientSocket.getInetAddress());

            // Create BufferedReader to read data from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create PrintWriter to send data to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read 10 numbers from the client
            int[] numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                numbers[i] = Integer.parseInt(in.readLine());
            }

            Arrays.sort(numbers);

            out.println("Sorted Numbers: " + Arrays.toString(numbers));

            clientSocket.close();
            System.out.println("TCP Connection closed with client.");

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
