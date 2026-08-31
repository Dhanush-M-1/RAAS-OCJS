//package code_;

import java.io.*;
import java.util.*;

public class A_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int minr = 2147483647;
            int maxl = -1;
            for (int j = 0; j < n; j++) {
                int l = in.nextInt();
                int r = in.nextInt();
                minr = Math.min(minr, r);
                maxl = Math.max(maxl, l);
            }
            out.println(Math.max(maxl - minr, 0));
        }
        out.close();
    }
}
