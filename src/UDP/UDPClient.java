import java.io.*;
import java.net.*;
import java.util.*;

class UDPClient{

public static void main(String[] args) throws Exception {
   byte[] sendData = new byte[1024];
   byte[] receiveData = new byte[1024];
   
   // creating a socket
   DatagramSocket clientSocket = new DatagramSocket();
    InetAddress IPAddress = InetAddress.getByName("localhost"); 
   //Scanner to read the data from keyboard
   Scanner x = new Scanner(System.in);
   while(true){
       System.out.print("Enter Your Message :");
       String s = x.nextLine();
       sendData = s.getBytes();
       //Send the message
       DatagramPacket sendPacket = 
         new DatagramPacket(sendData, sendData.length, IPAddress, 8888); 
       clientSocket.send(sendPacket);
       
       if (s.contains("bye")) break;
      //Read the echo from the server
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String modifiedSentence =new String(receivePacket.getData()); 
      System.out.println("FROM SERVER:" + modifiedSentence);
   }
   // Now terminate the client connection.
   System.err.println("Terminating the client connection.");
   clientSocket.close();
  }
}