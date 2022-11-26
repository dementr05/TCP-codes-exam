
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class FactorialServer {
 public static void main(String[] args) {
 ServerSocket server = null;
 Socket socket = null;
 DataInputStream in = null;
 DataOutputStream out = null;
 try {
 server = new ServerSocket(5000);
 System.out.println("Server running!");
 System.out.println("Waiting for Client...");
 socket = server.accept();
 in = new DataInputStream(socket.getInputStream());
 out = new DataOutputStream(socket.getOutputStream());
 while (true) {
 String message = in.readUTF();
 if (message.equals("0")) {
 System.out.println("Connection terminated by Client!");
 System.exit(0);
 } else {
 int num = Integer.parseInt(message);
 long fact = 1;
 for (int i = num; i > 0; i--) {
 fact = fact * i;
 }
 out.writeUTF(Long.toString(fact));
 System.out.println("Request from Client successfully processed!");
 }
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}