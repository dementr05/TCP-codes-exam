import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class DaytimeClient {
  public static void main(String[] args) {
    Socket socket = null;
    DataOutputStream out = null;
    DataInputStream in = null;
    Scanner sc = null;
    try{
      socket  = new Socket("localhost",8001);
      System.out.println("connected");
      out = new DataOutputStream(socket.getOutputStream());
      in = new DataInputStream(socket.getInputStream());
      sc = new Scanner(System.in);
      while(true){
        System.out.println("Do you want to know the current date and time: Y/N?");
        String message = sc.next();
        if(message.equals("N")){
          out.writeUTF(message);
          System.exit(0);

        }else if(message.equals("Y")){
          out.writeUTF(message);
          String servermessage = in.readUTF();
          System.out.println("current date and time:"+servermessage);
        }else{
          System.out.println("Please respond correctly!");
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
