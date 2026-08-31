import java.util.*;
import java.lang.*;
import java.io.*;
public class A
{
	public static void main (String[] args)
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a[]=new int[n];
		    int b[]=new int[m];
		    int c[]=new int[1001];
		    
		    for(int i=0;i<n;i++)
		    a[i]=sc.nextInt();
		    for(int i=0;i<m;i++)
		    b[i]=sc.nextInt();
		    
		    boolean sig=true;
		    l:
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<m;j++)
		        {
		            if(a[i]==b[j])
		            {
		                System.out.println("YES\n"+"1 "+a[i]);
		                sig=false;
		                break l;
		            }
		        }
		    }
		    
		    if(sig)
		    System.out.println("NO");
		    
		}
	}
}