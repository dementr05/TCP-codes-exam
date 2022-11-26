import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class smallestClient {
 public static void main(String[] args) throws UnknownHostException, IOException {
 try (Socket socket = new Socket("localhost", 7000)) {
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 DataInputStream in = new DataInputStream(socket.getInputStream());
 try (Scanner sc = new Scanner(System.in)) {
 System.out.println("Enter three numbers: ");
 for (int i = 0; i < 3; i++) {
 out.writeUTF(Integer.toString(sc.nextInt()));
 }
 }
 System.out.println("Response received from the Server!");
 System.out.println("The smallest of the three numbers = " + in.readUTF());
 }
 }
}

