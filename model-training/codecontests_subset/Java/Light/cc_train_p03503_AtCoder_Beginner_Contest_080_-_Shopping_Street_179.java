import java.util.*;
import java.util.stream.IntStream;

public class Main {
        static boolean[][] f;
        static  int[][] p;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        f = new boolean[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                f[i][j] = scan.nextInt() == 1;
            }
        }
        p = new int[n][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                p[i][j] = scan.nextInt();
            }
        }
        
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i < 1024; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += score(j, i);
            }
            ret = (ret > sum)? ret : sum;
        }
        System.out.println(ret);
    }

    private static int score(int mise, int i) {
        int num = 0;
        for (int j = 0; j < 10; j++) {
            if ((i & (1 << j)) > 0 && f[mise][j]) {
                num++;
            }
        }
        return p[mise][num];
    }
}