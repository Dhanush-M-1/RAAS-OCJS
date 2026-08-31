import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {

    public static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
//        sc = new Scanner(new File("input-d.txt"));
        new ProblemD().doTest();
    }

    long N, K, P;
    long[] a;
    long[] b;

    private void doTest() {
        N = sc.nextLong();
        K = sc.nextLong();
        P = sc.nextLong();

        a = new long[(int) N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        b = new long[(int) K];
        for (int i = 0; i < K; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);

        System.out.println(binSearch(-1, 2_100_000_000));
    }

    private long binSearch(long leftExcl, long rightIncl) {
        if (leftExcl + 1 >= rightIncl) {
            return rightIncl;
        }

        long mid = (leftExcl + rightIncl) / 2;
//        System.out.println(leftExcl + " " + mid + " " + rightIncl);
        if (solve(mid)) {
            return binSearch(leftExcl, mid);
        } else {
            return binSearch(mid, rightIncl);
        }

    }

    private boolean solve(long maxDist) {
        int key = -1;
        for (int i = 0; i < a.length; i++) {
            boolean found = false;
            while (true) {

                key++;
                if (key >= b.length) {
                    break;
                }

                if (Math.abs(a[i] - b[key]) + Math.abs(b[key] - P) <= maxDist) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}
