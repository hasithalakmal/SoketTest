package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

class echoClient{
  
public static void main(String[] args) throws Exception {
    // creating a socket
    Socket clientSocket = new Socket("127.0.0.1",8888);
    System.err.println("Clien was connected to the server ");
    // Creating input and putput stream to read and write
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
    //Scanner to read the data from keyboard
    Scanner x = new Scanner(System.in);
    while(true){
       System.out.print("Enter Your Message :");
       String s = x.nextLine();
       //Send the message
       out.println(s);
       if (s.equals("bye")) break;
       //Read the echo from the server
       s = in.readLine();
       //Print it on the terminal
       System.out.println("Sever: "+s);
    }
    // Now terminate the client connection.
    System.err.println("Terminating the client connection.");
    out.close();
    in.close();
    clientSocket.close();
  }
}