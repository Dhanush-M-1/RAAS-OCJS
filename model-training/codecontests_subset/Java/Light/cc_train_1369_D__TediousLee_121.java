import java.io.*;
import java.util.*;

public class T4 extends PrintWriter {
    public T4() {
        super(System.out);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        T4 main = new T4();
        int n = s.nextInt();
        main.preWork();
        while (n-- > 0) {
            main.mainPrint(s);
        }
        main.flush();
    }
    long[] ans = new long[2*1000000];
    private void mainPrint(Scanner s) {
        int n = s.nextInt();
        println(ans[n - 1]);
    }
    long mod = (long) (1e9 + 7);
    private void preWork() {
        for (int i = 2; i < 2000000; i++) {
            ans[i] = ans[i - 2] * 2 + ans[i - 1] + (i % 3 == 2 ? 4 : 0);
            ans[i] %= mod;
        }
    }

}
