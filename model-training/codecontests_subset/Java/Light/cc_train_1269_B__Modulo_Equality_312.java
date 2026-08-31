import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            a[i] = (sc.nextInt() % m);
        }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int x = (b[0]-a[i] >= 0) ? b[0]-a[i] : (m-a[i]+b[0]);
            int[] f = Arrays.copyOf(a,n);
            for(int j=0;j<n;j++){
                f[j] = (f[j]+x)%m;
            }
            Arrays.sort(f);
            if(Arrays.equals(f,b)) ans = Math.min(ans,x);
        }
        System.out.println(ans);
    }
}
