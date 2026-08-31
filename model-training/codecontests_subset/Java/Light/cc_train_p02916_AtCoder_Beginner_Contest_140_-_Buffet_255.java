import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n-1];
        for(int i=0;i<n;++i) a[i] = sc.nextInt();
        for(int i=0;i<n;++i) b[i] = sc.nextInt();
        for(int i=0;i<n-1;++i) c[i] = sc.nextInt();
        int last = -1;
        long ans = 0;
        for(int i=0;i<n;++i){
            int cur = a[i];
            ans+=b[cur-1];
            if(cur - last == 1) ans+=c[a[i]-2];
            last = cur;
        }
        System.out.print(ans);
    }


}
