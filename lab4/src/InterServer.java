import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

class ClientUDP extends Thread{
    private InetAddress address;
    private byte[] buffer;
    private DatagramSocket socket;
    private DatagramPacket packet;

    private String group;
    private int portUDP;

    private List<String> listOfMessage;
    private String currentMessage = "";
    private String previousMessage = "";

    public ClientUDP(String group, int portUDP, List<String> listOfMessage) {
        this.group = group;
        this.portUDP = portUDP;
        this.listOfMessage = listOfMessage;
        start();
    }

    @Override
    public void run(){
        System.out.println("Waiting for message from server(UDP)");
        try{
            //creating object MulticastSocket, to get
            //data from group using port 1502
            socket = new MulticastSocket(portUDP);

            address = InetAddress.getByName(group);
            //registration client in a group
            socket.connect(address,1502);
            boolean flag = false;
            while (true) {
                buffer = new byte[256];
                packet = new DatagramPacket(buffer, buffer.length);
                //getting data from server
                socket.receive(packet);
                if(flag){
                    previousMessage = currentMessage;
                    currentMessage = (new String(packet.getData())).trim();
                }
                if (!(previousMessage.equalsIgnoreCase(currentMessage))){
                    listOfMessage.add(currentMessage);
                    System.out.println("New message: " + currentMessage);
                }
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.disconnect();
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

class ServerTCP extends Thread{
    private List<String> listOfMessage;
    private ServerSocket serverSocket = null;
    ObjectOutputStream out;

    public ServerTCP(int portTCP, List<String> listOfMessage){
        this.listOfMessage = listOfMessage;
        try{
            //creating object ServerSocket which get
            //client requests too port 1500
            serverSocket = new ServerSocket(portTCP);
            System.out.println("Server staring over TCP");

            start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try{
            while (true) {
                //waiting connection requests from clients
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection get from: " + clientSocket);

                //getting output stream which is connected with object Socket
                out = new ObjectOutputStream(clientSocket.getOutputStream());

                //entry object in output stream
                int size = listOfMessage.size();
                int count = (size >= 5) ? size - 5 : 0;
                for (int i = count; i < size; i++) {
                    out.writeObject(listOfMessage.get(i));
                }
                out.writeObject("end");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class InterServer {
    public static void main(String[] args) {
        List<String> listOfMessage = new ArrayList<>();
        new ClientUDP("233.0.0.1", 1502, listOfMessage);
        new ServerTCP(1500, listOfMessage);
    }

    /*private static MulticastSocket socket;
    private static InetAddress address;
    private static byte[] buffer;
    private static DatagramPacket packet;
    private static String str;
    private static List<String> list;


    public static void main(String[] args) {
        list = new ArrayList();
        System.out.println("Waiting for server's message");
        try {
            //creating object MulticastSocket, to get data
            //from group with using port 1502
            socket = new MulticastSocket(1502);

            address = InetAddress.getByName("233.0.0.1");
            socket.joinGroup(address);
            while (true){
                buffer = new byte[256];
                packet = new DatagramPacket(buffer, buffer.length);
                //getting data from server
                socket.receive(packet);
                str = new String(packet.getData());
                if (!list.contains(str)){
                    list.add(str);
                }
                System.out.println("New message is: " + str.trim());
            }
            sendMessage(list);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.leaveGroup(address);
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket.close();
        }


    }

    private static void sendMessage(List<String> list) {

        try {
            ServerSocket serverSocket = new ServerSocket(1502);
            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection accepted from " + clientSocket.getInetAddress().getHostAddress());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(list);
                out.close();
                System.out.println("Starting the sever");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
*/
}
