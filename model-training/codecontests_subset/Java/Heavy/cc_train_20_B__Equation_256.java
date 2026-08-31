
import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.util.regex.Pattern;
import javafx.util.Pair;
import sun.util.locale.StringTokenIterator;
 
public class Foh {
 
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder out = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
 
    static int I(String s) {
        return Integer.parseInt(s);
    }
 
    static long L(String s) {
        return Long.parseLong(s);
    }
 
    static double D(String s) {
        return Double.parseDouble(s);
    }
 
    static String[] SA() throws IOException {
        return bf.readLine().split(" ");
    }
 
    public static void main(String[] args) throws IOException {
 
        StringTokenizer in = new StringTokenizer(bf.readLine());
        long a = I(in.nextToken());
        long b = I(in.nextToken());
        long c = I(in.nextToken());
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("-1");
        } else if (a == 0 && b == 0 && c != 0) {
            System.out.println("0");
        } else if (a == 0 && b != 0) {
            System.out.println("1");
            System.out.printf("%.5f%n", ((-c * 1.0) / (b * 1.0)));
        } else {
            if ((b * b) - (4 * a * c) < 0) {
                System.out.println(0);
            } else {
                double max = Math.max(((((-b) * 1.0) + Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)), (((-b) - Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)));
                double min = Math.min(((((-b) * 1.0) + Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)), (((-b) - Math.sqrt((b * 1.0 * b * 1.0) - (4.0 * a * 1.0 * c * 1.0))) / (2.0 * a)));
                if ((max == min)) {
                    System.out.println("1\n");
                    System.out.printf("%.5f%n", (min));
 
                } else {
                    System.out.println("2\n");
                    System.out.printf("%.5f%n", (min));
                    System.out.printf("%.5f%n", (max));
                }
            }
        }
    }
   
}
//I tried to delete one condition(just)
 //I deduced from someone's solution that