// Why do we fall ? So we can learn to pick ourselves up.
import java.util.*;
public class solve {
    static int mod = 1000000007;
    static int mod1 = 998244353;
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        int ans = mod;
        for(int i=0; i<n; i++) a[i] = sc.nextLong();
        for(int i=0; i<n; i++) b[i] = sc.nextLong();
        Arrays.sort(b);
        for(int i=0; i<n; i++){
            long x = (b[0]-a[i]+m)%m;
            long[] temp = new long[n];
            for(int j=0; j<n; j++) temp[j] = (a[j]+x)%m;
            Arrays.sort(temp);
            if(Arrays.equals(b,temp)) ans = (int) Math.min(ans,x);
        }
        System.out.println(ans);
    }
}