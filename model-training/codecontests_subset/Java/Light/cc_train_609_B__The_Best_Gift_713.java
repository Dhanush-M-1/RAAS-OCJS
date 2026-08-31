import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by vadimc on 19.12.15.
 */
public class N2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), x, count = 0;
        int[] counts = new int[M];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(st.nextToken());
            counts[x - 1] += 1;
        }
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                count += counts[i] * counts[j];
            }
        }
        System.out.println(count);
    }
}
