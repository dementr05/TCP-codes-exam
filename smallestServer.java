import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class smallestServer {
 public static void main(String[] args) throws IOException {
 try (ServerSocket server = new ServerSocket(7000)) {
 System.out.println("Server Running!");
 System.out.println("Waiting for Client...");
 Socket socket = server.accept();
 DataInputStream in = new DataInputStream(socket.getInputStream());
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 int[] num = new int[3];
 for (int i = 0; i < 3; i++) {
 num[i] = Integer.parseInt(in.readUTF());
 }
 int min = num[0];
 for (int i = 1; i < num.length; i++) {
 if (num[i] < min) {
 min = num[i];
 }
 }
 System.out.println("Client request processed!");
 out.writeUTF(Integer.toString(min));
 } catch (NumberFormatException e) {
 e.printStackTrace();
 }
 }
}
