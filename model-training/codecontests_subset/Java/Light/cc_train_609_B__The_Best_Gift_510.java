import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        // PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 
        // int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] a = new int[n];

        int[] count = new int[11];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            count[a[i]]++;
        }
        long ans = c2(n);
        for(int i=1; i<=10; i++) ans -= c2(count[i]);
        System.out.println(ans);
        
        // int n = scan.nextInt();
        
        // out.close(); System.exit(0);
    }
    public static long c2(int n) {
        return 1L*n*(n-1)/2;
    }
}
