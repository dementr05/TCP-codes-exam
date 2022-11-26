import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class palindromeServer {
 public static void main(String[] args) {
 try (ServerSocket server = new ServerSocket(12345)) {
 System.out.println("Server Running");
 System.out.println("Waiting for Client...");
 Socket socket = server.accept();
 DataInputStream in = new DataInputStream(socket.getInputStream());
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 String str = in.readUTF();
 if (str.equals(new StringBuffer(str).reverse().toString())) {
 out.writeUTF("PALINDROME");
 } else {
 out.writeUTF("NOT PALINDROME");
 }
 System.out.println("Client request processed!");
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}
