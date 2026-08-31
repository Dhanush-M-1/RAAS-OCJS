import java.util.*;
import java.lang.*;
import java.io.*;
public final class gf{

	public static void main(String args[])
        {Scanner sc=new Scanner(System.in);
	    int t,n,i,j,ans=0,a,b,c;
        n=sc.nextInt();
        for(i=0;i<n;i++)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            c=sc.nextInt();
            if(c<a)
                ans=c;
            else
            {
                t=b%c;
                if(t==0)
                    ans=b+c;
                else
                ans=b+c-t;
            }
                System.out.println(ans);
            }
            }
        }