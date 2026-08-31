import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by aps36017 on 14/7/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int array[] = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= n;i++)
            array[i] = Integer.parseInt(st.nextToken());
        int pos[] = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i <= k;i++)
            pos[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(array);
        Arrays.sort(pos);
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < k - n + 1;i++){
            int max = 0;
            for(int j = 1;j <= n;j++){
                if(Math.abs(array[j] - pos[i + j]) + Math.abs(p - pos[i + j]) == Math.abs(p - array[j]))
                    max = Math.max(max, Math.abs(array[j] - p));
                else max = Math.max(max, Math.abs(array[j] - pos[i + j]) + Math.abs(pos[i + j] - p));
            }
            ans = Math.min(ans, max);
        }
        System.out.println(ans);
    }
}
