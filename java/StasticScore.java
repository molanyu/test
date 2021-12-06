import java.util.Scanner;

public class StasticScore {
    static void stastic() throws ScoreException {
        int i, k, sum = 0;
        double avg;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入班级人数：");
        k = input.nextInt();
        int num = k;
        while (k > 0) {
            try {
                System.out.println("输入学生成绩：");
                i = input.nextInt();
                if (i < 0 || i > 100) {
                    throw new ScoreException("输入的成绩不合法，请重新输入");
                } else {
                    sum += i;
                    k--;
                }
            } catch (ScoreException e) {
                System.out.println(e.getMessage());
            }
        }
        avg = sum / num;
        System.out.println("我是分割线----------------");
        System.out.println("平均成绩：" + avg);
        input.close();
    }
}
