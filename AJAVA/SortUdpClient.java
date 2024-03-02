import java.net.*;
import java.util.Scanner;

public class SortUdpClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Read 10 numbers from the user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 10 numbers separated by commas:");
            String numbersInput = scanner.nextLine();

            byte[] sendData = numbersInput.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String sortedNumbers = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Sorted numbers received from server: " + sortedNumbers);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
