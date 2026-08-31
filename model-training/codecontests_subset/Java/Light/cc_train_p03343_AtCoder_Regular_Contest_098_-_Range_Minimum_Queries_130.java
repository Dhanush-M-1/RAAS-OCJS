import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by darshan on 5/30/19.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int minDiff = Integer.MAX_VALUE;
        PriorityQueue<Integer> currentSubsequence = new PriorityQueue<>();
        PriorityQueue<Integer> leastQElements = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            int low = num[i];
            currentSubsequence.clear();
            leastQElements.clear();
            for (int j = 0; j <= n; j++) {
                if (j == n || num[j] < low) {
                    while (currentSubsequence.size() - k + 1 > 0) {
                        leastQElements.add(currentSubsequence.poll());
                    }
                    currentSubsequence.clear();
                } else {
                    currentSubsequence.add(num[j]);
                }
            }
            while (leastQElements.size() > q) {
                leastQElements.poll();
            }
            if (leastQElements.size() == q) {
                minDiff = Math.min(minDiff, leastQElements.poll() - low);
            }
        }
        System.out.println(minDiff);
    }
}
