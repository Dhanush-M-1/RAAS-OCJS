
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DisJoinSetUnion {

    public int[] upper;

    public DisJoinSetUnion(int n) {
        upper = new int[n];
        Arrays.fill(upper, -1);
    }

    public int root(int x) {
        return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
    }

    public boolean equiv(int x, int y) {
        return root(x) == root(y);
    }

    public boolean MergeGroup(int x, int y) {
        x = root(x);
        y = root(y);
        if (x != y) {
            if (upper[y] < upper[x]) {
                int d = x;
                x = y;
                y = d;
            }
            upper[x] += upper[y];
            upper[y] = x;
        }
        return x == y;
    }

    public int count() {
        int ct = 0;
        for (int u : upper) if (u < 0) ct++;
        return ct-1;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        try (PrintWriter or = new PrintWriter(System.out)) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            DisJoinSetUnion d = new DisJoinSetUnion(n + m);
            for (int i = 0; i < q; i++) {
                d.MergeGroup(in.nextInt() - 1, in.nextInt() + n - 1);
            }
            or.print(d.count());
        }

    }

}

