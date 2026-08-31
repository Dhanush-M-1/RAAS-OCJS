import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Common Subsequence
 */
public class Main {

    private static StreamTokenizer st;

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    private static void solve(int[] a, int[] b) {
        for (int numa : a) {
            for (int numb : b) {
                if (numa == numb) {
                    System.out.println("YES");
                    System.out.println(1 + " " + numa);
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        st = new StreamTokenizer(in);
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt(), m = nextInt();
            int[] a = new int[n], b = new int[m];
            for (int j = 0; j < n; j++) a[j] = nextInt();
            for (int j = 0; j < m; j++) b[j] = nextInt();
            solve(a, b);
        }
    }
}
