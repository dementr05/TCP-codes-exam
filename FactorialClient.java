import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class FactorialClient {
  public static void main(String[] args) {
    Socket socket = null;
    DataOutputStream out = null;
    DataInputStream in = null;
    Scanner sc = null;
    try {
      socket = new Socket("localhost", 5000);
      System.out.println("Connected!");
      out = new DataOutputStream(socket.getOutputStream());
      in = new DataInputStream(socket.getInputStream());
      sc = new Scanner(System.in);
      while (true) {
        System.out.println("Enter the number: (Press 0 to exit)");
        int num = sc.nextInt();
        if (num == 0) {
          out.writeUTF(Integer.toString(num));
          System.exit(0);
        } else {
          out.writeUTF(Integer.toString(num));
          System.out.println("Message sent to Server!");
          String servermessage = in.readUTF();
          System.out.println("The factorial of " + num + " = " + servermessage);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}