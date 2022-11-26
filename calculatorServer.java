import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class calculatorServer {
  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(8002);
    System.out.println("server running");
    System.out.println("Waiting of client");
    Socket socket = server.accept();
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());
    int[] num = new int[2];
    for(int i =0;i<2;i++){
      num[i] = Integer.parseInt(in.readUTF());
    }
    int ch = Integer.parseInt(in.readUTF());
    if(ch==1)
      out.writeUTF(Integer.toString(num[0]+num[1]));
    else if(ch==2)
      out.writeUTF(Integer.toString(num[0]-num[2]));
    else if (ch==3)
      out.writeUTF(Integer.toString(num[0]*num[1]));
    else
      out.writeUTF(Integer.toString(num[0]/num[1]));
    System.out.println("client request succesfully!");
  }
}
