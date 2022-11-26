import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class stringServer {
 public static void main(String[] args) {
 try (ServerSocket server = new ServerSocket(6578)) {
 System.out.println("Server Running!");
 System.out.println("Waiting for Cient...");
 Socket socket = server.accept();
 DataInputStream in = new DataInputStream(socket.getInputStream());
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 String[] str = new String[2];
 for (int i = 0; i < str.length; i++) {
 str[i] = in.readUTF();
 }
 if (str[0].equals(str[1])) {
 out.writeUTF("YES");
 } else {
 out.writeUTF("NO");
 }
 System.out.println("Client request processed!");
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}
