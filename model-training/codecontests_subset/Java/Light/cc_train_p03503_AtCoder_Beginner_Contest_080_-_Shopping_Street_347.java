import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = scan.nextInt();
        int[][] F = new int[N][10];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                F[i][j] = scan.nextInt();
            }
        }
        int[][] P = new int[N][11];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 10; j++) {
                P[i][j] = scan.nextInt();
            }
        }
        int max = (int)Math.pow(2, 11);
        long answer = Long.MIN_VALUE;
        for (int i = 1; i < max; i++) {
            String digits = Integer.toString(i, 2);
            int remain = 10 - digits.length();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < remain; j++) {
                sb.append("0");
            }
            sb.append(digits);
            digits = sb.toString();
            int[] c = new int[N];
            char[] d = digits.toCharArray();
            for (int j = 0; j < 10; j++) {
                if (d[j] - '0' == 0) {
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    if (F[k][j] == 1) {
                        c[k] += 1;
                    }
                }
            }
            long t = 0;
            for (int j = 0; j < N; j++) {
                t += P[j][c[j]];
            }
            answer = Math.max(answer, t);
        }
        System.out.println(answer);
    }
}
