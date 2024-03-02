import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SumClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Enter two numbers one by one
            System.out.print("Enter the first number: ");
            int num1 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.print("Enter the second number: ");
            int num2 = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

            // Send two numbers to the server
            out.println(num1);
            out.println(num2);

            // Read and print the sum received from the server
            String sumResult = in.readLine();
            System.out.println("Sum received from server: " + sumResult);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
