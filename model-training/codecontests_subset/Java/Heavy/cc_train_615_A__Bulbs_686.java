import java.io.*;
import java.util.*;
/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int m,i,l,c,k;
		    l=1;
		    String s;
		    m = sc.nextInt();
		    sc.nextLine();
		    int a [] =new int[m];
		     
		   for(i=0;i<n;i++)
		   {
		       k=sc.nextInt();
		       while(k>0)
		       {
		           a[sc.nextInt()-1]--;
		           k--;
		       }
		   }
		    c=1;
		    for(i=0;i<m;i++)
		     if(a[i]==0)
		     {
		        
		         c=0;
		         break;
		     }
		     if(c==0)
		    System.out.println("NO");
		    else
		    System.out.println("YES");
		    
		}catch(Exception e) {
		}
	}

}