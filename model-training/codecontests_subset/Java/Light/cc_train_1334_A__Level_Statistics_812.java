import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] temp = br.readLine().split(" ");
            int p1 = Integer.parseInt(temp[0]);
            int c1 = Integer.parseInt(temp[1]);
            boolean result = true;
            if (c1 > p1) {
                // false
                result = false;
            }

            for (int i = 0; i < n - 1; i++) {
                temp = br.readLine().split(" ");
                int p2 = Integer.parseInt(temp[0]);
                int c2 = Integer.parseInt(temp[1]);

                if (/*(c2 > p2) ||*/
                        (c2 < c1) ||
                        (p2 < p1) ||
                        ((c2 - c1) > (p2 - p1))) {
                    result = false;
                }

                p1 = p2;
                c1 = c2;
            }

            System.out.println(result ? "YES" : "NO");
        }
    }
}