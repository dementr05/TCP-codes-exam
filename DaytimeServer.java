import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket; import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DaytimeServer {
  public static void main(String[] args) {
    ServerSocket server = null;
    Socket socket = null;
    DataOutputStream out = null;
    DataInputStream in = null;
    try{
      server = new ServerSocket(8001);
      System.out.println("server ruuning!");
      System.out.println("waiting for client...");
      socket = server.accept();
      out = new DataOutputStream(socket.getOutputStream());
      in = new DataInputStream(socket.getInputStream());
      while(true){
        String message = in.readUTF();
        if(message.equals("N")){
          System.out.println("connection terminated by client!");
          System.exit(0);

        }else{
          DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss");
          LocalDateTime now = LocalDateTime.now();
          out.writeUTF(datetime.format(now));
          System.out.println("Request from client succesfully processed!");
        }
      }
    }catch (Exception e){
      e.printStackTrace();

    }
  }
}
