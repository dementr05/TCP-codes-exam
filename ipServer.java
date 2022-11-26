import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ipServer {
  public static void main(String[] args) {
    try(ServerSocket server = new ServerSocket(7000)){
      System.out.println("server Running");
      System.out.println("Waiting for client");
      Socket socket = server.accept();
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      String message = in.readUTF();
      if(message.equals("N")){
        System.out.println("connection terminated by client!");
        System.exit(0);
      }else{
        out.writeUTF(InetAddress.getLocalHost().toString());
        System.out.println("Request from client succesfully processed");
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }
}
