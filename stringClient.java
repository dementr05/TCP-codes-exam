import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class stringClient {
 public static void main(String[] args) {
 try (Socket socket = new Socket("localhost", 6578)) {
 System.out.println("Connected!");
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 DataInputStream in = new DataInputStream(socket.getInputStream());
 try (Scanner sc = new Scanner(System.in)) {
 System.out.println("Enter two strings: ");
 for (int i = 0; i < 2; i++) {
 out.writeUTF(sc.nextLine());
 }
 }
 System.out.println("Server's Message: " + in.readUTF());
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}
