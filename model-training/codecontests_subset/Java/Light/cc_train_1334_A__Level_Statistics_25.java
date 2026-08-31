
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            boolean possible = true;
            int currentP = 0, currentC = 0;
            while (N-- > 0) {
                int p = in.nextInt(), c = in.nextInt();
                if (p < currentP || c < currentC || p < c || (p-currentP) < (c-currentC)) {
                    possible = false;
                }

                currentP = p;
                currentC = c;
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}
