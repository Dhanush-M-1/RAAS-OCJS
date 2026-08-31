

import java.io.*;
import java.util.*;
public class C1244 {
    public static void main(String args[])throws IOException
        {
            Scanner sc=new Scanner(System.in);
            long n=sc.nextLong();
            long p=sc.nextLong();
            long w=sc.nextLong();
            long d=sc.nextLong();
            if(n*w < p)
                System.out.println(-1);
            else
            {
                
                for(long i=w-1;i>=0;i--)
                {
                    long diff=p - i*d;
                    if(diff>=0)
                    {
                    if(diff%w==0)
                    {
                        long q=i+diff/w;
                        if(q<=n)
                        {
                            System.out.println((diff/w)+" "+i+" "+(n-i-diff/w));
                            System.exit(0);
                        }
                    }
                    }
                }
                System.out.println(-1);
            }
        }

}
