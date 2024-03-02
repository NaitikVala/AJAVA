import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            socket.receive(receivePacket);

            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Receiver: Message received from Sender: " + receivedMessage);

            // Reverse the message
            String reversedMessage = new StringBuilder(receivedMessage).reverse().toString();
            System.out.println("Receiver: Reversed Message: " + reversedMessage);

            InetAddress senderAddress = receivePacket.getAddress();
            int senderPort = receivePacket.getPort();
            byte[] sendData = reversedMessage.getBytes();

            // Send the reversed message back to the sender
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, senderAddress, senderPort);
            socket.send(sendPacket);

            System.out.println("Receiver: Reversed Message sent back to Sender: " + reversedMessage);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
