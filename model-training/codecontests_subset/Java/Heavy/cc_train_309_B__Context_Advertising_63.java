

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class ContextAdvertising {

    int maxn = 1000010, len[] = new int[maxn], r, c, n;
    String word[] = new String[maxn];
    int f[] = new int[maxn], ans[] = new int[maxn];

    void run() throws Exception {
        n = nextInt();
        r = nextInt();
        c = nextInt();
        for (int i = 1; i <= n; i++) {
            word[i] = next();
            len[i] = word[i].length();
        }
        work();

        int mx = 0, s = 0;
        for (int i = 1; i <= n; i++)
            if (ans[i] - i > mx) {
                mx = ans[i] - i;
                s = i;
            }
        int cnt = 0;
        for (int i = s; i < ans[s]; i++) {
            cnt += len[i] + 1;
            if (cnt > c + 1) {
                cnt = len[i] + 1;
                System.out.print("\n" + word[i]);
            } else {
                if (i != s)
                    System.out.print(" ");
                System.out.print(word[i]);
            }
        }

    }

    void work() {
        int left = 1, right = 1, cnt = 0;
        while (right <= n) {
            if (cnt + len[right] + 1 <= c + 1) {
                cnt += len[right] + 1;
                right++;
            } else {
                f[left] = right;
                cnt -= len[left] + 1;
                left++;
            }
        }
        for (int i = left; i <= n + 1; i++)
            f[i] = n + 1;

        for (int i = 1; i <= n + 1; i++)
            ans[i] = i;
        while (r > 0) {
            if (r % 2 == 1)
                for (int i = 1; i <= n; i++)
                    ans[i] = f[ans[i]];
            for (int i = 1; i <= n; i++)
                f[i] = f[f[i]];
            r = r >> 1;
        }
    }

    StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            new InputStreamReader(System.in)));

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    String next() throws Exception {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws Exception {
        new ContextAdvertising().run();
    }

}
