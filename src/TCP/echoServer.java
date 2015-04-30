package TCP;

import java.io.*;
import java.net.*;

class echoServer{

public static void main(String[] args) throws Exception {
    // creating a socket
    ServerSocket serverSocket = new ServerSocket(8888);
    System.err.println("Server is listing on port : 8888");
    // Wait for a connection, and process
    Socket clientSocket = serverSocket.accept();
    System.err.println("Now clien is connected ");
    // Creating input and putput stream to read and write
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
    //Reading the client message
    String s;
    while (true){
      //Read the line from client
      s = in.readLine();
      //Write it to the terminal
       System.out.println("Client: "+s);
       //If client say bye, break the loop
       if (s.equals("bye")) break;
       //Echo the response
       out.println(s);
    }

     // Now terminate the client connection.
    System.err.println("Terminating the client connection.");
    out.close();
    in.close();
    clientSocket.close();
    }
}