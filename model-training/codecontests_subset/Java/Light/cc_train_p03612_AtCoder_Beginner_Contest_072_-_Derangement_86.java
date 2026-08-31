import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = scan.nextInt();
        int[] p = new int[N];
        for (int i = 1; i <= N; i++) {
            p[i-1] = scan.nextInt();
        }
        long answer = 0;
        for (int i = 1; i <= N; i++) {
            if (p[i-1] != i) {
                continue;
            }
            answer += 1;
            if (i < N) {
                p[i - 1] = p[i];
                p[i] = i;
            }
        }
        System.out.println(answer);
    }
}
