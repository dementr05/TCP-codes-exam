import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class lengthServer {
 public static void main(String[] args) throws IOException {
 try (ServerSocket server = new ServerSocket(6000)) {
 System.out.println("Server Running!");
 System.out.println("Waiting for client...");
 Socket socket = server.accept();
 DataInputStream in = new DataInputStream(socket.getInputStream());
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 out.writeUTF(Integer.toString(in.readUTF().length()));
 System.out.println("Client request processed");
 }
 }
}