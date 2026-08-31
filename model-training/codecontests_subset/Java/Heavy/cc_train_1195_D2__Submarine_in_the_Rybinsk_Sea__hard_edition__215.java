import java.util.*;
import java.io.*;
public class D1195 {
    static int toint(char i) {return (int) i - 48;}
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        int n = Integer.parseInt(f.next()), N = 998244353;
        String[] a = new String[n];
        int[] size = new int[11];
        long[] pow = new long[21];
        pow[0] = 1;
        for (int i = 1; i < 21; i++) {
            pow[i] = (pow[i-1]) * 10 % N;
        }
        for (int i = 0; i < n; i++) {
            a[i] = f.next(); size[a[i].length()]++;
        }
        long ans = 0;
//        int i = 0;
        for (int i = 0; i < n; i++) {
            int len = a[i].length();
            for (int j = 1; j <= 10; j++) {
                long eval = 0;
                int p = 0;
                for (int k = 0; k < len; k++) {
                    if (k >= j) { // unhappy
                        eval = (eval + 2 * pow[p]*toint(a[i].charAt(len-1-k))) % N;
                        p++;
                    } else {
                        eval = (eval + 11 * pow[p]*toint(a[i].charAt(len-1-k))) % N;
                        p+=2;
                    }
                }
//                System.out.println(eval);
                ans = (ans + size[j] * eval) % N;
            }
        }
        System.out.println(ans);
    }
}
