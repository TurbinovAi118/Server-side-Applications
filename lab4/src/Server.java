import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Server {

    private DatagramSocket socket;
    private DatagramPacket packet;
    private BufferedReader in = null;
    private String str;
    private byte[] buffer;
    private InetAddress address;


    public Server() throws SocketException {
        System.out.println("Sending message");
        socket = new DatagramSocket();


        transmit();

    }

    private void transmit() {
        in = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("Enter data to send to clients: ");
            try {
                str = in.readLine();
                buffer = str.getBytes();
                address = InetAddress.getByName("233.0.0.1");
                //sending pocket to port 1502
                packet = new DatagramPacket(
                        buffer,
                        buffer.length,
                        address,
                        1502
                );
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
