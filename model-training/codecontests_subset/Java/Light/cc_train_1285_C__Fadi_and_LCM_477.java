/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
public class C1285 {
    public static void main(String args[])throws IOException
        {
            Scanner sc=new Scanner(System.in);
            long n=sc.nextLong(),max=Long.MAX_VALUE,a=0,b=0;
            for(long i=1;i<=(long)Math.sqrt(n);i++)
            {
                if(n%i==0)
                {
                    long t1=i,t2=n/i;
                    long gcd=find(t1,t2);
                    if(gcd==1)
                    {
                        long m=Math.max(t1,t2);
                        if(m<max)
                        {
                            a=t1;b=t2;
                            max=m;
                        }
                    }
                }
            }
            System.out.println(a+" "+b);
        }
    static long find(long a,long b)
    {
        if(b==0)
            return a;
        else
            return find(b,a%b);
    }

}
