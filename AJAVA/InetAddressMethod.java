import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMethod {

    public static void main(String[] args) {
        try {
            // Demonstrate getByName(String host)
            String hostName = "www.google.com";
            InetAddress googleAddress = InetAddress.getByName(hostName);
            System.out.println("IP Address for " + hostName + ": " + googleAddress.getHostAddress());

            // Demonstrate getLocalHost()
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localHost.getHostName());
            System.out.println("Local Host Address: " + localHost.getHostAddress());

            // Demonstrate getHostName()
            System.out.println("Google Host Name: " + googleAddress.getHostName());

            // Demonstrate getHostAddress()
            System.out.println("Google IP Address: " + googleAddress.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
