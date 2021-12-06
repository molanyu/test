import java.io.IOException;
import java.net.*;  //����java.net��

public class InetAddressDemo {
    public static void main(String[] args) throws IOException {
        try {
            //��õ�ǰ����������IP��ַ
            InetAddress add1 = InetAddress.getLocalHost();
            System.out.println("��ǰ����������" + add1);

            //����������ͨ��DNS���������������Ӧ�����������ַ
            InetAddress add2 = InetAddress.getByName("www.163.com");
            System.out.println("���׷�����������" + add2);
            
           
            //�����ַ���������ʽ��IP��ַ�����Ӧ��������ַ(�����������и�IP��ַ�Ļ�)
            InetAddress add3 = InetAddress.getByName("192.168.0.22");
            System.out.println("IP��ַΪ192.168.0.22��������" + add3);

            //���ݻ����������Ӧ��������ַ������������иû������Ļ���
            InetAddress add4 = InetAddress.getByName("J104");
            System.out.println("������ΪJ104��������" + add4);
        } catch (UnknownHostException uhe) { uhe.printStackTrace(); }
    }
}
