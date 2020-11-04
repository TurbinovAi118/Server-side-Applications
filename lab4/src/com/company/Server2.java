package com.company;

import com.company.model.DOMParsing;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Server2 {

    private byte[] buffer;
    private DatagramPacket packet;
    private InetAddress address;
    private DatagramSocket socket;

    private Random rand;
    private String forecast;
    private DOMParsing domParser;

    public Server2() throws IOException {
        System.out.println("Sending message(refresh every 10 sec)");

        //creating object DatagramSocket to get client requests
        socket = new DatagramSocket();

        rand = new Random();
        domParser = new DOMParsing();

        //calling method transmit() to send message for every
        //client which are in group
        transmit();
    }

    public void transmit() {
        try {
            while (true) {
                int random = rand.nextInt(4);
                forecast = domParser.getForecastsList().get(random).toString();
                buffer = forecast.getBytes();
                address = InetAddress.getByName("233.0.0.1");
                //sending Datagram packet to port 1502
                packet = new DatagramPacket(
                        buffer,
                        buffer.length,
                        address,
                        1502);

                //sending message for every client which are in group
                socket.send(packet);
                System.out.println(forecast);
                Thread.sleep(10_000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //closing socket
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String arg[]) throws Exception {
        //starting server
        new Server2();
    }
}