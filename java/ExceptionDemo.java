import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String args[]) {
        Bank ba = new Bank(10000);
        Scanner reader = new Scanner(System.in);
        double b, c;
        System.out.println("余额为：" + ba.show_balance());
        System.out.println("输入存入的钱：");
        b = reader.nextDouble();
        ba.deposite(b);
        try {
            System.out.println("输入要取出的钱数：");
            c = reader.nextDouble();
            ba.withdrawal(c);
        } catch (InsufficientFundsException e) {
            System.out.println("e.toString():" + e.toString());
            System.out.println(e.excepMesagge());
        } finally {
            System.out.println("操作退出！");
        }
        System.out.println("余额为：" + ba.show_balance());
        reader.close();
    }
}
