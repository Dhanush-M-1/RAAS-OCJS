/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long x=n;
        long count=0,prime1=0,prime2=0;
        for(long i=2;i*i<=n;i++){
            while(x%i==0){
                x=x/i;
                if(prime1==0) prime1=i;
                else if(prime2==0) prime2=i;
            }
        }
        if(x!=n&&x!=1){prime2=x;}
        //if(prime1*prime2==0) System.out.println(1);
        if(prime1*prime2==n){System.out.println(2);}
        else {
            System.out.println(1);
             System.out.println(prime1*prime2);
        }
        
	}
}
