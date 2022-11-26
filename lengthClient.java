import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class lengthClient {
 public static void main(String[] args) throws UnknownHostException, IOException {
 try (Socket socket = new Socket("localhost", 6000)) {
 System.out.println("Connected!");
 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
 DataInputStream in = new DataInputStream(socket.getInputStream());
 try (Scanner sc = new Scanner(System.in)) {
 System.out.print("Enter a string: ");
 out.writeUTF(sc.nextLine());
 }
 System.out.println("The length of the input string is " + in.readUTF() + ".");
 System.out.println("Server responded successfully to client's message!");
 }
 }
}