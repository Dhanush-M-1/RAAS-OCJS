import  java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;
public class hacker
{
    

    static float area(int x1, int y1, int x2, 
                        int y2, int x3, int y3)
    {
        return (float)Math.abs((x1 * (y2 - y3) + 
        x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }
         
    /* A function to check whether point P(x, y) 
    lies inside the rectangle formed by A(x1, y1), 
    B(x2, y2), C(x3, y3) and D(x4, y4) */
    static boolean check(int x1, int y1, int x2, int y2,
    int x3, int y3, int x4, int y4, int x, int y)
    {
         
        /* Calculate area of rectangle ABCD */
        float A = area(x1, y1, x2, y2, x3, y3)+ 
                area(x1, y1, x4, y4, x3, y3);
     
        /* Calculate area of triangle PAB */
        float A1 = area(x, y, x1, y1, x2, y2);
     
        /* Calculate area of triangle PBC */
        float A2 = area(x, y, x2, y2, x3, y3);
     
        /* Calculate area of triangle PCD */
        float A3 = area(x, y, x3, y3, x4, y4);
     
        /* Calculate area of triangle PAD */
        float A4 = area(x, y, x1, y1, x4, y4);
     
        /* Check if sum of A1, A2, A3 and A4 
        is same as A */
        return (A == A1 + A2 + A3 + A4);
    }
     



     public static int popCount(int n) 
   {
        n -= (n >>> 1) & 0x55555555;
        n = ((n >>> 2) & 0x33333333) + (n & 0x33333333);
        n = ((n >> 4) & 0x0F0F0F0F) + (n & 0x0F0F0F0F);
        return (n * 0x01010101) >> 24;
    }

// Speed up counting by counting the primes per
// array slot and not individually. This yields
// another factor of about 1.24 or so.
    public static int nthPrime(long n) {
        if (n < 2) return 2;
        if (n == 2) return 3;
        if (n == 3) return 5;
        int limit, root, count = 2;
        limit = (int)(n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
        root = (int)Math.sqrt(limit);
        switch(limit%6) {
            case 0:
                limit = 2*(limit/6) - 1;
                break;
            case 5:
                limit = 2*(limit/6) + 1;
                break;
            default:
                limit = 2*(limit/6);
        }
        switch(root%6) {
            case 0:
                root = 2*(root/6) - 1;
                break;
            case 5:
                root = 2*(root/6) + 1;
                break;
            default:
                root = 2*(root/6);
        }
        int dim = (limit+31) >> 5;
        int[] sieve = new int[dim];
        for(int i = 0; i < root; ++i) {
            if ((sieve[i >> 5] & (1 << (i&31))) == 0) 
            {
                int start, s1, s2;
                if ((i & 1) == 1) 
                {
                    start = i*(3*i+8)+4;
                    s1 = 4*i+5;
                    s2 = 2*i+3;
                }
                else
                {
                    start = i*(3*i+10)+7;
                    s1 = 2*i+3;
                    s2 = 4*i+7;
                }
                for(int j = start; j < limit; j += s2) 
                {
                    sieve[j >> 5] |= 1 << (j&31);
                    j += s1;
                    if (j >= limit) break;
                    sieve[j >> 5] |= 1 << (j&31);
                }
            }
        }
        int i;
        for(i = 0; count < n; ++i) 
        {
            count += popCount(~sieve[i]);
        }
        --i;
        int mask = ~sieve[i];
        int p;
        for(p = 31; count >= n; --p) 
        {
            count -= (mask >> p) & 1;
        }
            return 3*(p+(i<<5))+7+(p&1);
        }
    
    static int GCD(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        else
        {
            return GCD(b,b%a);
        }
    }

    static long pow(long a,long b)
    {
        long res = 1;
        while(b>0)
        {
            if((b&1)==1)
            {
                res *= a;
            }

            b >>= 1;
            a *=a;
        }
        return res;
    }
  

    public static void main(String[] args) throws Exception
    {
       // in = new Scanner(new File("explicit.in"));
        //out = new PrintWriter("explicit.out");
        new hacker().run();
       
    }

   
    void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String str = sc.next();
        int c=0;
        for(int i=0;i<t;i++)
        {
            if(str.charAt(i)=='8')
            {
                c++;
            }
        }

        System.out.println(Math.min(c,t/11));



    

    }
    

    
  
   
    


   


    
}

   
