import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        APhoneNumbers solver = new APhoneNumbers();
        solver.solve(1, in, out);
        out.close();
    }

    static class APhoneNumbers {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int n = in.nextInt();
            String str = in.next();
            int strCount = n / 11;
            int index = 0;
            int count8 = 0;
            while (index < str.length()) {
                if (str.indexOf('8', index) >= 0) {
                    count8++;
                    index = str.indexOf('8', index) + 1;
                } else {
                    break;
                }
            }

            out.print(Math.min(strCount, count8));
        }

    }
}

