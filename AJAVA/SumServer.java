import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SumServer {
    public static void main(String[] args) {
        try { 
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is waiting for client connection on port 12345...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read two numbers from the client
            int num1 = Integer.parseInt(in.readLine());
            int num2 = Integer.parseInt(in.readLine());

            // Calculate the sum
            int sum = num1 + num2;

            // Send the sum back to the client
            out.println("Sum: " + sum);

            clientSocket.close();
            System.out.println("Connection closed with client.");
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
