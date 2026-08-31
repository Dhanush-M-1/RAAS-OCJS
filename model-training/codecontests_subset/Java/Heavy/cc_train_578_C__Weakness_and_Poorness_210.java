import java.util.*;
import java.io.*;
import static java.lang.System.in;

public class Main {
    static double[] a,b;
    static int n;
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new double[n]; b = new double[n];
        for(int i=0;i<n;i++) a[i]=sc.nextDouble();
        double hi = 10000.0, lo = -10000.0;
        for(int pass=0;pass<60;pass++){
            double mid = (hi+lo)/2;
            double[] cur = check(mid);
            if(cur[0]>cur[1]) lo = mid; // positive part is too much. We let b[i] = a[i]-mid, so needs more mid
            else hi = mid;
        }
        double[] res = check((lo+hi)/2);
        double ans = Math.max(Math.abs(res[0]),Math.abs(res[1]));
        System.out.println(ans);
    }
    static double help(double[] c){
        double ret = 0,cur = 0;
        for(int i=0;i<n;i++){
            cur += c[i];
            ret = Math.max(ret,cur);
            if(cur<0) cur = 0;
        }
        return ret;
    }
    static double[] check(double mid){
        for(int i=0;i<n;i++) b[i] = a[i]-mid;
        double[] ans = new double[2];
        ans[0] = help(b);
        for(int i=0;i<n;i++) b[i]*=-1;
        ans[1] = Math.abs(help(b));
        return ans;
    }
}