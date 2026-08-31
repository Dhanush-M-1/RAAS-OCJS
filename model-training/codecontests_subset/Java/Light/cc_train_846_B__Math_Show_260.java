import java.util.*;
import java.io.*;
public class Major {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int array[] = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        long full = 0;
        for(int i = 1;i <= k;i++) {
            array[i] = Integer.parseInt(st.nextToken());
            full += array[i];
        }
        Arrays.sort(array);
        long ans = 0;
        for(int i = 0;i <= n;i++){
            long current = full*i;
            long points = i*(k + 1);
            for(int j = 1;j <= k;j++){
                for(int l = 1;l <= n - i && current + array[j] <= m;l++) {
                    current += array[j];
                    ++points;
                }
            }
            if(current <= m)
                ans = Math.max(ans, points);
        }
        System.out.println(ans);
    }
}