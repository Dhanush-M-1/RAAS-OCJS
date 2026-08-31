import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskB {
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
        String s = next();
        char[] in = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (in[i] == 'I') cnt++;
        }
        if (cnt > 1) {
            System.out.println(0);
            return;
        } else if (cnt == 1) {
            System.out.println(1);
            return;
        } else {
            cnt = 0;
            for (int i = 0; i < n; i++) {
                if (in[i] == 'I' || in[i] == 'A') cnt++;
            }
            System.out.println(cnt);
            return;
        }
    }
}