import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Woodcutters {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int i, j, t = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = 1;
        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            Long[] x = new Long[n];
            Long[] h = new Long[n];
            for (i = 0; i < n; i++) {
                String[] inp = br.readLine().split(" ");
                x[i] = Long.parseLong(inp[0]);
                h[i] = Long.parseLong(inp[1]);
            }
            int count = 1;
            Long max = x[0];
            for (i = 1; i < n; i++) {
                if (i == n - 1) {
                    count++;
                } else if ((x[i] - h[i]) > max) {
                    count++;
                    max = x[i];
                } else if (x[i] + h[i] < x[i+1]) {
                    count++;
                    max = x[i] + h[i];
                } else {
                    max = x[i];
                }
            }
            System.out.println(count);
        }
    }
}