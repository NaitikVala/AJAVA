import java.net.*;

public class Sender {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String message = "Welcome to Gujarat Technological UNIVERSITY";
            byte[] sendData = message.getBytes();

            InetAddress receiverAddress = InetAddress.getLocalHost();
            int receiverPort = 9876;

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receiverAddress, receiverPort);
            socket.send(sendPacket);

            System.out.println("Sender: Message sent to Receiver: " + message);

            // Receive the reversed message from the receiver
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String reversedMessageFromReceiver = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Sender: Reversed Message received from Receiver: " + reversedMessageFromReceiver);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
