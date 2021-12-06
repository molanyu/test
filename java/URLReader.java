import java.io.*;
import java.net.*;

public class URLReader {
     public static void main(String[] args) throws Exception {
          URL tirc = new URL("https://www.baidu.com/");
          BufferedReader in = new BufferedReader(new InputStreamReader(tirc.openStream()));

          String inputLine;
          File outfile = new File("test.html");
          PrintWriter out = new PrintWriter(new FileWriter(outfile));
          while ((inputLine = in.readLine()) != null) {
               // ���������в��϶�ȡ����ֱ������Ϊֹ
               out.println(inputLine); // �Ѷ��������д��test.html
          }
          in.close(); // �ر�������
          out.close();
     }
}
