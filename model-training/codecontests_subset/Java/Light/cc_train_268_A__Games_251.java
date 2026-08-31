
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: dima
 * Date: 28.01.13
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
public class TaskA {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringTokenizer str;
    static String SK;

    static String next() throws IOException {
        while ((str == null) || (!str.hasMoreTokens())) {
            SK = in.readLine();
            if (SK == null)
                return null;
            str = new StringTokenizer(SK);
        }
        return str.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int h[] = new int[n];
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = nextInt();
            a[i] = nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == h[j]) cnt++;
                if (a[j] == h[i]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}