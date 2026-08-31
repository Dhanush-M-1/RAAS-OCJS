import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int r1 = in.nextInt();
        int r2 = in.nextInt();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        int d1 = in.nextInt();
        int d2 = in.nextInt();

        // x a
        // b c
        int x, a, b, c;
        for (int i = 1; i <= 9; i++) {
            x = i;
            a = r1 - x;
            b = c1 - x;
            c = d1 - x;
            if (r2 == b + c && c2 == a + c && d2 == a + b && x != a && x != b && x != c && a != b && a != c && b != c && a < 10 && a > 0 && b < 10 && b > 0 && c < 10 && c >0) {
                out.println(x + " " + a);
                out.println(b +" " + c);
                out.close();
                return;
            }
        }
        out.print("-1");
        out.close();
    }
}
