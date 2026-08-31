/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int l=0;l<t;l++)
        {
            //int x=sc.nextInt();
            //int y=sc.nextInt();
            int n=sc.nextInt();
            int m=sc.nextInt();
            
            //int[] a=new int[n];
            //int[] b=new int[m];
            ArrayList<Integer> a=new ArrayList<>();
            ArrayList<Integer> b=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                //b[i]=sc.nextInt();
                int x=sc.nextInt();
                a.add(x);
            }
            for(int i=0;i<m;i++)
            {
                //a[i]=sc.nextInt();
                int x=sc.nextInt();
                b.add(x);
            }
            int f=0;
            if(n<=m)
            {
                for(int i=0;i<n;i++)
                {
                    if(b.contains(a.get(i)))
                    {
                        System.out.println("YES");
                        System.out.println(1 + " " + a.get(i));
                        f=1;
                        break;
                    }
                }
            }
            else
            {
                for(int i=0;i<m;i++)
                {
                    if(a.contains(b.get(i)))
                    {
                        System.out.println("YES");
                        System.out.println(1 + " " + b.get(i));
                        f=1;
                        break;
                    }
                }
            }
            if(f==0)
            {
                System.out.println("NO");
            }
            
        }
	}
}
