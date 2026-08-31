import java.util.*;


import java.lang.*;
import java.math.BigInteger;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class q3
{
	public static void main (String[] args) throws java.lang.Exception
	{
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        long ans=1;
        for(int i=1;i<=n;i++)
        {
            ans*=i;
            ans=ans%1000000007;

        }
        long f=1;
        for(int i=1;i<n;i++)
        {
            f*=2;
            f=f%1000000007;
        }
        long fc=(ans-f)%1000000007;
        if(fc<0)
        {
            fc+=1000000007;
        }
        System.out.println(fc);
           

        
    }
   
}