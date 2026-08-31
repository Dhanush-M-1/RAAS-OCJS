import java.io.*;
import java.util.*;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        solve();
        out.close();
    }

    public static void solve() {
        int a = in.nextInt(), b = in.nextInt();
        int h = a;
        while (a >= b) {
            h += a / b;
            a = (a / b) + (a % b);
        }
        out.println(h);
    }
}
