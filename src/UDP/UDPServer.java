import java.io.*;
import java.net.*;
import java.util.*;

class UDPServer{

public static void main(String[] args) throws Exception {
   byte[] sendData = new byte[1024];
   byte[] receiveData = new byte[1024];
   
   //Openning a datagram socket
   System.err.println("The server was started.");
   DatagramSocket serverSocket = new DatagramSocket(8888);
   while(true){
       //Initializing the array
       for(int i=0;i<sendData.length;i++) sendData[i]=0;
       for(int i=0;i<receiveData.length;i++) receiveData[i]=0;
       //Reading the packet
       DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
       serverSocket.receive(receivePacket);
       String sentence =new String(receivePacket.getData()); 
       if (sentence.contains("bye")) break;
       System.out.println("from client:" + sentence);
       //Retriving the IP address of the received packet
       InetAddress address = receivePacket.getAddress();
       //Retriving the port number of the received packet
       int port = receivePacket.getPort();
       //Change the senstence to uppercase
       String capitalizedSentence = sentence.toUpperCase();
       sendData = capitalizedSentence.getBytes();
       DatagramPacket sendPacket =
         new DatagramPacket(sendData, sendData.length,address, port);
       serverSocket.send(sendPacket);
      }
   // Now terminate the server.
   System.err.println("Terminating the server.");
   serverSocket.close();
  }
}