import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tok = null;

    private static String nextToken() throws IOException {
        if (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }

        return tok.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) throws IOException {
	    int n = nextInt();
        int k = nextInt();
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();

        if (k < n + 1 || n == 4) {
            System.out.println(-1);
            return;
        }

        int[] perm = new int[n];
        perm[0] = a;
        perm[n - 1] = b;
        perm[1] = c;
        perm[n - 2] = d;

        Set<Integer> unused = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) {
            unused.add(i);
        }
        unused.removeAll(Arrays.asList(a, b, c, d));

        int i = 2;
        for (int j : unused) {
            perm[i++] = j;
        }

        for (int j = 0; j < n; j++) {
            System.out.print(perm[j] + " ");
        }
        System.out.println();

        System.out.printf("%d %d ", perm[1], perm[0]);
        for (int j = 2; j < n - 2; j++) {
            System.out.print(perm[j] + " ");
        }
        System.out.printf("%d %d ", perm[n - 1], perm[n - 2]);
    }
}
