import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class EqualizingDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(f.readLine());
        int[][] seenAndCount = new int[(int)(2 * (10e5))+1][2];
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            seenAndCount[arr.get(i)][0]++;
        }
        Collections.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = arr.get(i);
            int countDivides = 0;
            while (cur >= 0) {
                if (seenAndCount[cur][0] >= k) {
                    ans = Math.min(seenAndCount[cur][1], ans);
                }
                cur/=2;
                countDivides++;
                seenAndCount[cur][0]++;
                seenAndCount[cur][1] += countDivides;
                if (cur == 0) {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
