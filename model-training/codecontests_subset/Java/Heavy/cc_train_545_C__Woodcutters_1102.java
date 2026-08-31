import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Woodcutters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] h = new int[n];
        TreeSet<Integer> occupied = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());
            occupied.add(x[i]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int lX = occupied.ceiling(x[i] - h[i]);
            if (lX == x[i]) {
                count++;
                occupied.add(x[i] - h[i]);
                continue;
            }
            int rX = occupied.floor(x[i] + h[i]);
            if (rX <= x[i]) {
                count++;
                occupied.add(x[i] + h[i]);
            }
        }
        System.out.println(count);
    }
}
