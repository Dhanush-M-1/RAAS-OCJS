import java.io.*;
import java.util.*;
public class q1
{
	public static void main(String args[])throws IOException
	{
	    Scanner in=new Scanner(System.in);
	    int n=in.nextInt();
	    int arr[]=new int[n];
	    int flag[]=new int[3];
	    flag[2]=1;
	    for(int i=0;i<n;i++)
	    arr[i]=in.nextInt();
	    int f=0;
	    for(int i=0;i<n;i++)
	    {
	        if(flag[arr[i]-1]==1)
	        {
	            f=1;
	           // break;
	        }
	        else
	        {
	            	int ii=0;
	                for(ii=0;ii<3;ii++)
	                {
	                    if(flag[ii]==0 && arr[i]!=ii+1)
	                    break;
	                }
	                flag[ii]=1;
	                for(int j=0;j<3;j++)
	                if(ii!=j && flag[j]==1)
	                flag[j]=0;
	         
	          }
	         /* for(int k=0;k<3;k++)
	          System.out.print(flag[k]+" ");
	          System.out.println();*/
	    }
	    if(f==0)
	    System.out.println("YES");
	    else
	    System.out.println("NO");
	 	}
}