import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 
        int T = Integer.parseInt(bf.readLine());
        for(int t=0; t<T; t++) {
            char[] c = bf.readLine().toCharArray();
            int n = c.length;
            int ans = 0;
            for(int i=1; i<n; i++) {
                if(!(c[i] != c[i-1] && (i<=1 || (c[i] != c[i-2])))) {
                    c[i] = '?';
                    ans += 1;
                }
            }
            out.println(ans);
        }
        // StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        // int n = Integer.parseInt(st.nextToken());
        // int n = scan.nextInt();
        
        out.close(); System.exit(0);
    }
}
