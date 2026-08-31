//Created by Aminul on 4/23/2019.

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        boolean found = false;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] > s[i + 1]) {
                pw.println("YES");
                pw.println((i + 1) + " " + (i + 2));
                found = true;
                break;
            }
        }
        if (!found) pw.println("NO");
        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}