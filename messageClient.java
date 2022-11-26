import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
public class messageClient {
  public static void main(String[] args) {
    Socket socket = null;
    DataOutputStream out = null;
    DataInputStream in = null;
    Scanner sc = null;
  
  try{
    socket=new Socket("localhost",8001);
    System.out.println("connected");
    out = new DataOutputStream(socket.getOutputStream());
    in = new DataInputStream(socket.getInputStream());
    sc = new Scanner(System.in);
    while(true){
      String message = sc.nextLine();
      if(message.equals("over")){
        out.writeUTF(message);
        System.exit(0);

      }else{
        out.writeUTF(message);
        String servermessage = in.readUTF();
        if(servermessage.equals("over")){
          System.out.println("connection terminated by server!");
          System.exit(0);
        }else{
          System.out.println("Message from server:"+message);
        }
      }
    }
  }catch(Exception e){
      e.printStackTrace();
  }finally{
    try{
      sc.close();
      out.close();
      socket.close();

    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
}
