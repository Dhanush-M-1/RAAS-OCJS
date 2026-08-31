import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int b, c, d;
        int i;
        for (i = 1; i < 10; i++) {
            if (i >= c1 || i >= d1 || i >= r1) {
                pr.print(-1);
                break;
            }
            b = r1 - i;
            c = c1 - i;
            if (d1 - i == c2 - b && d1 - i == r2 - c && b + c == d2) {
                d = d1 - i;
                if (i != b && i != c && i != d && b != c && b != d && c != d && b < 10 && b > 0 && c < 10 && c > 0 && d < 10 && d > 0) {
                    pr.println(i + " " + b);
                    pr.println(c + " " + d);
                    break;
                }
            }
        }
        if (i == 10)
            pr.print(-1);
        pr.close();
    }
}