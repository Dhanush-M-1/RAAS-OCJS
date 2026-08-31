import java.util.*;

public class Solution
{
       static long pow(long a , long b)
       {
              if(b== 0)
              return 1;
              long mod = 1000000007;
              long ans = pow(a,b/2);
              if(b%2 == 0)
              return ans*ans%mod;
              
              return ans*ans%mod*a%mod;
       }
       public static void main(String []args)
       {
              Scanner sc = new Scanner(System.in);
               int n  = sc.nextInt();
               long fact[] = new long[n+1];
               fact[0] = 1;
               long mod = 1000000007;
               for(long i = 1 ; i <= n ; i++)
               {
                      fact[(int)i] = fact[(int)(i-1)]*i%mod;
               }
               
               long ans = fact[n];
               ans -= pow(2 , n-1);
               ans = (ans+mod)%mod;
               System.out.println(ans);
       }
}