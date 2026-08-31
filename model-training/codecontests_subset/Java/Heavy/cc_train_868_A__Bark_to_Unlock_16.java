import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // int n = Integer.parseInt(bf.readLine());
        // StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        // int n = Integer.parseInt(st.nextToken());
        String pass = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        String[] s = new String[n];
        boolean ans = false;
        for(int i=0; i<n; i++) s[i] = bf.readLine();
        for(int i=0; i<n; i++) {
          for(int j=0; j<n; j++) {
            if(pass.charAt(0) == s[i].charAt(1))
              if(pass.charAt(1) == s[j].charAt(0))
                ans = true;
          }
        }
        for(int i=0; i<n; i++) if(s[i].equals(pass)) ans = true;
        if(ans) out.println("YES");
        else out.println("NO");
        out.close(); System.exit(0);
    }
}
