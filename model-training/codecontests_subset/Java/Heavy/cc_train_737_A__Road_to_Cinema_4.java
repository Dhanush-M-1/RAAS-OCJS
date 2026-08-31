import java.util.*;

public class Solution
{
       static int n,k,s,t;
       static int c[] , v[] , g[];
       
       static boolean check(int x)
       {
              long tt = 0;
              for(int i = 0 ; i < k+1 ; i++)
              {
                     int dist = g[i+1] - g[i];
                     if(x < dist)
                     return false;
                     
                     int xx = Math.min(x-dist , dist);
                     int yy = dist - xx;
                     
                     
                     tt += xx + 2*yy;
              }
              if(tt <= t)
              return true;
              
              return false;
       }
       public static void main(String []args)
       {
              Scanner sc = new Scanner(System.in);
              n = sc.nextInt();
              k = sc.nextInt();
              s = sc.nextInt();
              t = sc.nextInt();
              
              c = new int[n];
              v = new int[n];
              g = new int[k+2];
              g[0] = 0;
              g[1] = s;
              for(int i = 0 ; i < n ; i++)
              {
                     c[i] = sc.nextInt();
                     v[i] = sc.nextInt();
              }
              for(int i = 2 ; i <= k+1 ; i++)
              {
                     g[i] = sc.nextInt();
              }
              Arrays.sort(g);
              int l = 1 , r = 1000000010;
              while(l < r)
              {
                     int mid = (l+r)/2;
                     if(check(mid))
                     r = mid;
                     
                     else
                     l = mid+1;
              }
              int min = Integer.MAX_VALUE;
              for(int i = 0 ; i < n ; i++)
              {
                     if(v[i] >= l)
                     min = Math.min(min,c[i]);
              }
              if(min == Integer.MAX_VALUE)
              System.out.println(-1);
              
              else
              System.out.println(min);
       }
}