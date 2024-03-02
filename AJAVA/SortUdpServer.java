import java.net.*;
import java.util.Arrays;

public class SortUdpServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String receivedNumbers = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received numbers from client: " + receivedNumbers);

            // Split the received numbers and convert them to an array
            String[] numbersArray = receivedNumbers.split(",");
            int[] numbers = new int[numbersArray.length];
            for (int i = 0; i < numbersArray.length; i++) {
                numbers[i] = Integer.parseInt(numbersArray[i]);
            }

            Arrays.sort(numbers);

            String responseMessage = Arrays.toString(numbers);

            // Send the sorted numbers back to the client
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            byte[] sendData = responseMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);

            System.out.println("Sorted numbers sent back to client.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
