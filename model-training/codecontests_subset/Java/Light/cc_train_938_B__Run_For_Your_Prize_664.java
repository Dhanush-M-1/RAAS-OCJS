import java.util.*;
import java.lang.*;
import java.io.*;

public class B {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int m = 0;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            m = Math.max(m, Math.min(p[i] - 1, 1000000 - p[i]));
        }
        
        System.out.print(m);
        sc.close();
    }
}
