import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bulbs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int switches = Integer.parseInt(st.nextToken()), bulbs = Integer.parseInt(st.nextToken());
        int[] a = new int[bulbs + 1];
        for (int i = 0; i < switches; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int pos = Integer.parseInt(st.nextToken());
                if (pos >= 0 && pos < a.length) {
                    a[pos]++;
                }
            }
        }
        boolean rej = false;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                System.out.println("NO");
                rej = true;
                break;
            }
        }
        if (!rej)
            System.out.println("YES");
    }
}
