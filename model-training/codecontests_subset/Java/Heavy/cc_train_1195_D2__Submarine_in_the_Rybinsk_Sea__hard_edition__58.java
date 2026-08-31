import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        long[] t = new long[11];
        for(int i=0;i<n;i++){
            a[i] = Long.parseLong(st.nextToken());
            int tol = String.valueOf(a[i]).length();
            t[tol]++;
        }
        long sum = 0;
        long mod = 998244353;
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder(String.valueOf(a[i]));
            int l = String.valueOf(a[i]).length();
            for(int j=l;j>0;j--){
                if(j==1&&a[i]==1000000000){
                    long d = Long.valueOf(sb.toString()).longValue();
                    d %= mod;
                    d *= 10;
                    d %= mod;
                    d *= t[10];
                    d %= mod;
                    sum += d;
                    sum %=mod;
                }else{
                    sb.insert(j,"0");
                    long d = Long.valueOf(sb.toString()).longValue();
                    d %= mod;
                    d *= t[l+1-j];
                    d %= mod;
                    sum += d;
                    sum %=mod;
                }
            }
            long s = Long.valueOf(sb.toString()).longValue();
            for(int j=l+1;j<11;j++){
                long d = s;
                d %= mod;
                d *= t[j];
                d %= mod;
                sum += d;
                sum %=mod;
            }
            
            
            sb = new StringBuilder(String.valueOf(a[i]));
            l = String.valueOf(a[i]).length();
            for(int j=l-1;j>0;j--){
                sb.insert(j,"0");
                long d = Long.valueOf(sb.toString()).longValue();
                d %= mod;
                d *= t[l-j];
                d %= mod;
                sum += d;
                sum %=mod;
            }
            s = Long.valueOf(sb.toString()).longValue();
            for(int j=l;j<11;j++){
                long d = s;
                d %= mod;
                d *= t[j];
                d %= mod;
                sum += d;
                sum %=mod;
            }
        }
        System.out.println(sum);
    }
}

