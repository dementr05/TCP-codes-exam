import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class palindromeClient {
 public static void main(String[] args) {
 try (Socket socket = new Socket("localhost", 12345)) {
 System.out.println("Connected!");
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 DataInputStream in = new DataInputStream(socket.getInputStream());
 try (Scanner sc = new Scanner(System.in)) {
 System.out.println("Enter a string: ");
 out.writeUTF(sc.nextLine());
 }
 System.out.println("Server's Message: " + in.readUTF());
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}
