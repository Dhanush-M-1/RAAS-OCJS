
// ~/BAU/ACM-ICPC/Teams/A++/BlackBurn95

import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class Main {

    static int n,offset = 20001,inf = (int)1e9;
    static int [] a,b;
    static pair [][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                                              // (new FileReader("input.in"));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        
        n = parseInt(in.readLine());
        tk = new StringTokenizer(in.readLine());
        a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine());
        b = new int[n];
        for(int i=0; i<n; i++)
            b[i] = parseInt(tk.nextToken());
        
        dp = new pair[n][10001+offset];
        
        pair ans = calc(0,0);
        
        System.out.println(ans.first+" "+ans.second);
    }

    static pair calc(int i,int val) {
        if(i==n) {
            if(val<=0) return new pair(0,val);
            return new pair(inf,inf);
        }
        
        if(dp[i][val+offset]!=null) {
            //System.out.println(val+" "+(val+offset));
            return dp[i][val+offset];
        }
        
        pair c1 = new pair(calc(i+1,val+a[i]));
        pair c2 = new pair(calc(i+1,val-(b[i]-a[i])));
        c2.first++;
        c2.second += max(b[i]-a[i],0*val);
        
        if(c1.first < c2.first) return dp[i][val+offset] = c1;
        if(c1.first > c2.first) return dp[i][val+offset] = c2;
        if(c1.second < c2.second) return dp[i][val+offset] = c1;
        return dp[i][val+offset] = c2;
    }
}

class pair {
    int first,second;
    
    public pair(int f,int s) {
        this.first = f;
        this.second = s;
    }
    
    public pair(pair c) {
        this.first = c.first;
        this.second = c.second;
    }
}
