import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class messageServer {
  public static void main(String[] args) {
    ServerSocket server = null;
    Socket socket = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    Scanner sc = null;
    try {
      server = new ServerSocket(8001);
      System.out.println("server running!\n Waiting for client");
      socket = server.accept();
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      sc = new Scanner(System.in);
      while (true) {
        String message = in.readUTF();
        if (message.equals("over")) {
          System.out.println("Connection terminated by client!");
          System.exit(0);

        } else {
          System.out.println("Message from client: " + message);
          String servermessage = sc.nextLine();
          if (servermessage.equals("over")) {
            out.writeUTF(servermessage);
            System.exit(0);
          } else {
            out.writeUTF(servermessage);
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {
        sc.close();
        out.close();
        in.close();
        socket.close();
        server.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
