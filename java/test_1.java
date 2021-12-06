import java.util.*;
import java.io.*;

class test_1 {
    public static void main(String args[]) {
        File infile = new File("E:\\java_test", "test.txt");
        File outfile = new File("E:\\java_test", "out_test.txt");
        FileInputStream in = new FileInputStream(infile);
        FileOutputStream out = new FileOutputStream(outfile);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();
    }
}
