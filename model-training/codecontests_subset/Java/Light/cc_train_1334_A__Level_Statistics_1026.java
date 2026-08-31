import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            boolean possible = true;
            int pp = -1;
            int pc = -1;

            for (int i = 0; i < n; ++i) {
                int p = scn.nextInt();
                int c = scn.nextInt();
                if (!possible) {
                    continue;
                }
                if ((p >= c) && (pp <= p) && (pc <= c) && ((p - pp) >= (c - pc))) {
                    // fine
                } else {
                    possible = false;
                    continue;
                }
                pp = p;
                pc = c;
            }
            if (!possible) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}