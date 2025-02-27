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
            InetAddress ip = InetAddress.getByName("192.168.0.7"); //로컬 ip주소 입력
            int port = 9999;
            server=new ServerSocket();
            server.bind(new InetSocketAddress(ip, port));
            while(true){
                System.out.println("Server:Waiting for request.");
                client=server.accept();
                System.out.println("Server:Accepted.");
                InputStream stream=client.getInputStream();
                BufferedReader in =new BufferedReader(
                        new InputStreamReader(stream));
                String data=null;
                String
            }
        }
        catch (Exception e){

        }
    }
}