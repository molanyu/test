import java.net.*;
import java.io.*;

public class TestURL {
    public static void main(String[] args) throws Exception {
 
        URL aURL = new                URL("https://news.nwafu.edu.cn");
        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("host = " + aURL.getHost());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("port = " + aURL.getPort());   
        System.out.println("port = " + aURL.getDefaultPort()); 
        
    }
}
