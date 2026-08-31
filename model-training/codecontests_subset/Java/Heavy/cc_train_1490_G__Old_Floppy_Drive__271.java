import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class G702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int ff = 0; ff < t; ff++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            long[] ar = new long[n];
            long maxadd = -2000000000;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                if(i == 0)
                    ar[i] = Integer.parseInt(st.nextToken());
                else
                    ar[i] = ar[i-1] + Integer.parseInt(st.nextToken());
                maxadd = Math.max(maxadd, ar[i]);
            }
            long endadd = ar[n-1];
            for (int i = 1; i < n; i++) {
                ar[i] = Math.max(ar[i], ar[i - 1]);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int q = Integer.parseInt(st.nextToken());
                if(q > maxadd && endadd <= 0){
                    System.out.print(-1 + " ");
                    continue;
                }
                long num;
                if(q <= maxadd)
                    num = 0;
                else
                    num = (long) Math.ceil(((double)(q-maxadd)) / ((double)endadd));
                q -= (num * endadd);
                int l = 0, r = n;
                while (l < r){
                    int mid = (l + r)/2;
                    if(mid == n || ar[mid] >= q){
                        r = mid;
                    }else{
                        l = mid + 1;
                    }
                }
                if(r == n)
                    System.out.print(-1 + " ");
                long ans = (long)num * (long)n + (long)l;
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}
