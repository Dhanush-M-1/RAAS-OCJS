import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;
            p[u]++;
            p[v]++;
        }
        for (int i = 0; i < n; i++) {
            if (p[i] == 2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}