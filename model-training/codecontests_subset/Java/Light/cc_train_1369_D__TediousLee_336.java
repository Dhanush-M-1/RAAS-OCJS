import java.io.*;
import java.util.*;
     
    public class Solution {
        
       public static void main(String[] args) throws Exception{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           PrintWriter out = new PrintWriter(System.out);
          StringTokenizer st = new StringTokenizer(br.readLine());

                int t = Integer.parseInt(st.nextToken());
        int max = 0;
          int[] query = new int[t];
          
           for(int i=0;i<t;i++){
               st = new StringTokenizer(br.readLine());
               query[i] = Integer.parseInt(st.nextToken());
               max = Math.max(query[i],max);
           }
           
           long[] a = new long[max+1];
           long one = 1,leaf = 1;
           int mod = 1000000007;
           
           for(int i=3;i<a.length;i++){
               a[i] = (one*4)%mod;
               long temp  = (one*2)%mod;
               one = leaf;
               leaf = (leaf+temp)%mod;
               a[i] = (a[i]+a[i-3])%mod;
           }
          
          for(int i=0;i<t;i++) out.println(a[query[i]]);
          out.close();
       }
    }