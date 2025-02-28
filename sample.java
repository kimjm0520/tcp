import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;


public class sample{
    public static void main(String[] args){
        sample Sample=new sample();
        Sample.startServer();
    }

    public void startServer(){
        ServerSocket server=null;
        Socket client=null;
        try{
            InetAddress ip = InetAddress.getByName("192.168.0.38"); //로컬 ip주소 입력 192.168.0.38
            int port = 9999;
            server=new ServerSocket();
            server.bind(new InetSocketAddress(ip, port));
            while(true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();
                System.out.println("Server:Accepted.");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(stream));
                String data = null;
                StringBuilder receivedData = new StringBuilder();
                while ((data = in.readLine()) != null){
                    receivedData.append(data);
                }
                System.out.println("Received data:"+receivedData);
                in.close();
                stream.close();
                client.close();
                if(receivedData!=null && "EXIT".equals(receivedData.toString())){
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("------");
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            if(server!=null){
                try {
                    server.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}