import java.io.PrintWriter;
import java.util.Scanner;

public class TCR3A {

    public void solve(Scanner in, PrintWriter out) {
        int t = in.nextInt();
        for (int q = 0; q < t; q++) {
            int n = in.nextInt();
            int minR = Integer.MAX_VALUE;
            int maxL = 0;
            for (int i = 0; i < n; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                if (l > maxL) maxL = l;
                if (r < minR) minR = r;
            }
            if (n == 1) {
                out.println(0);
            } else {
                if (maxL < minR) {
                    out.println(0);
                } else {
                    out.println(maxL - minR);
                }
            }

        }
    }

    public static void main(String[] args) {
        new TCR3A().run();
    }

    public void run() {
        try (Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
