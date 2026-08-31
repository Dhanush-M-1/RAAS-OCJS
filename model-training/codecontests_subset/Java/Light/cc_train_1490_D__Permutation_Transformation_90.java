import java.util.*;

public final class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCount = scanner.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] r = new int[n];
            build(a, r, 0, n, 0);
            for (int v : r) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    private static void build(int[] a, int[] r, int from, int to, int lvl) {
        if (from >= to) {
            return;
        }

        int mi = from;
        for (int i = from + 1; i < to; i++) {
            if (a[i] > a[mi]) {
                mi = i;
            }
        }

        build(a, r, from, mi, lvl+1);
        build(a, r, mi+1, to, lvl+1);

        r[mi] = lvl;

        return;
    }
}