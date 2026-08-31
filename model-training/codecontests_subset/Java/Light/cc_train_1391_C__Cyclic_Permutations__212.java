import java.util.*;
public class Solution
{
	public static void main(String[] args)
	{
    long mod=(long)1e9+7;
     Scanner sc=new Scanner(System.in);
      long n=sc.nextLong();
      long t=power(2, n-1, mod);
      System.out.println((modFact(n, mod)-t+mod)%mod);
  }
  static long power(long x, long y, long p)
  {
    long res = 1; // Initialize result
 
    x = x % p; // Update x if it is more than or
    // equal to p
 
    if (x == 0)
      return 0; // In case x is divisible by p;
 
    while (y > 0)
    {
 
      // If y is odd, multiply x with result
      if ((y & 1) != 0)
        res = (res * x) % p;
 
      // y must be even now
      y = y >> 1; // y = y/2
      x = (x * x) % p;
    }
    return res;
  }
 
static long modFact(long n,
                       long p)
    {
        if (n >= p)
            return 0;
     
        long result = 1;
        for (long i = 1; i <= n; i++)
            result = (result * i) % p;
     
        return result;
    }
     
}