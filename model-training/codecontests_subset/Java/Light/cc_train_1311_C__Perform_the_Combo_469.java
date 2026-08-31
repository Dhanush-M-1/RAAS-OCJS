import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            int p[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int a[] = new int[n];
            int alpa[] = new int[26];

            for (int i = 0; i < m; i++) {
                a[p[i] - 1] += 1;
            }
            a[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--)
                a[i] += a[i + 1];
            for (int i = 0; i < n; i++) {
                int pos = s.charAt(i) - 'a';
                alpa[pos] += a[i];
            }
            for (int i = 0; i < 26; i++) {
                System.out.print(alpa[i] + " ");
            }
            System.out.println();
        }
    }

}