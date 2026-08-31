import java.util.*;
// scanner.nextInt();
// gatogari.
public class Solution {
    public static void main(String[] args) {       

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        
        long fact = 1;
        long index = 2;
        while(index <= n) 
        {
            fact *= index;
            fact %= (1000000007);     
            ++index;
        }
        long k = fact - exponentiation(2, n-1);
        while(k < 0)
        {
            k += 1000000007;
            k %= 1000000007;
        }
        System.out.println(k);
    }

            public static long exponentiation(long a, long b) //a^b
            {
                if(b < 0 || (b == 0 && a == 0)) return -1;
                if(b == 0 && a > 0) return 1;
                while(b%2 == 0)
                {
                    a *= a;
                    a %= (1000000007);
                    b /= 2;
                }

                long res = a;
                b = b/2;
                while(b > 0) 
                {
                    a *= a;
                    a %= 1000000007;
                    if(b %2 ==1)
                    {
                        res *= a;
                        res %= 1000000007;
                    }
                    b /= 2;
                }

                return res%(1000000007);
            }
}

