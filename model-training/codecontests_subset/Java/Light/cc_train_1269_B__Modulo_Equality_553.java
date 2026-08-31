import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);;
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        long m = in.nextLong();
        long a[] = new long[n];
        long b[] = new long[n];
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            b[i] = in.nextLong();
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            long x = (b[i] >= a[0] ? (b[i] - a[0]) : (m - a[0] + b[i]));
            long f[] = Arrays.copyOf(a,n);
            for (int j = 0; j < n; j++) {
                f[j]+=x;
                f[j]%=m;
            }
            Arrays.sort(f);
            if(Arrays.equals(f,b))ans = Math.min(ans,x);
        }
        out.println(ans);
        out.close();
    }
}