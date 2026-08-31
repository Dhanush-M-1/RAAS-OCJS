import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                                            //(new FileReader("input.in"));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        //PrintWriter pw = new PrintWriter("output.out", "UTF-8");
        
        int n = parseInt(in.readLine());
        tk = new StringTokenizer(in.readLine());
        
        long l=0,r=0,m;
        
        int [] a = new int[n];
        for(int i=0; i<n; i++)
            r += (long)(a[i] = parseInt(tk.nextToken()));
        
        long ans = 0;
        
        while(l <= r) {
            m = (l+r)/2;
            
            if(check(a,m)) {
                ans = m;
                r = m-1;
            } else l = m+1;
        }
        
        System.out.println(ans);
    }
    
    static boolean check(int [] a,long m) {
        long sum = 0;
        for(int i=0; i<a.length; i++) {
            if(a[i] > m) return false;
            sum += m-(long)a[i];
        }
        
        return (sum >= m);
    }
    
}