  import java.util.Scanner;
  public class fadi_and_lcm 
  {
	  static long gcd(long a, long b) 
	    { 
	    if (a == 0) 
	        return b;  
	    return gcd(b % a, a);  
	    } 
	 
	    static long lcm(long a, long b) 
	    { 
	        return (a*b)/gcd(a, b); 
	    } 
        public static void main(String[] args) 
        {
            Scanner s = new Scanner(System.in);
            long n = s.nextLong();
            int sqrt = (int)Math.sqrt(n);
            for (int i = sqrt; i >= 0; i--) 
            {
                if (n % i == 0 && lcm(i, n/i) == n) 
                {
                    System.out.println(i + " " + n/i);
                    return;
                }
            }
        }
   }