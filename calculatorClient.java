import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.Scanner;

public class calculatorClient {
  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("localhost", 8002);
    System.out.println("connected");
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 2; i++) {
      System.out.println("Enter no. " + (i + 1) + ":");
      out.writeUTF(Integer.toString(sc.nextInt()));
    }
    System.out.println("Press 1 for Addition:");
    System.out.println("Press 2 for Substraction:");
    System.out.println("Press 3 for Multiplication:");
    System.out.println("Press 4 for Divsion:");
    out.writeUTF(Integer.toString(sc.nextInt()));
    System.out.println("Result from Server: " + in.readUTF() + ".");
  }
}
