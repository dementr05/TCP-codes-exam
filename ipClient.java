import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;



public class ipClient {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost",7000)){
      System.out.println("connected");
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      System.out.println("Do you want to know the IP address of the client: Y/N ?");
      try(Scanner sc = new Scanner(System.in)){
        String message = sc.next();
        if(message.equals("N")){
          out.writeUTF(message);
          System.exit(0);
        }else if(message.equals("Y")){
          out.writeUTF(message);
          String servermessage = in.readUTF();
          System.out.println("server's IP address:"+ servermessage);
        }else{
          System.out.println("Please resond correctly");
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
