import java.util.HashSet;
import java.util.Scanner;


public class CF44B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A = in.nextInt(), B = in.nextInt(), C = in.nextInt();
        int r = 0;
        for (int i = 0; i <= A; i += 2) {
            for (int j = 0; j <= C; j++) {
                int have = i/2 + j*2;
                if (have <= n && n <= have + B)
                    r++;
            }
        }
        System.out.println(r);
    }
}
    