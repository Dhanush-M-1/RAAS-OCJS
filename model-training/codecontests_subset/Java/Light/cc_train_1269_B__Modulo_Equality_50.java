/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(tk.nextToken());
		int m=Integer.parseInt(tk.nextToken());
		tk=new StringTokenizer(br.readLine());
		int a[]=new int[n];int b[]=new int[n];
		for(int i=0;i<n;i++)
		a[i]=Integer.parseInt(tk.nextToken());
		tk=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		b[i]=Integer.parseInt(tk.nextToken());
		int min=Integer.MAX_VALUE;
		Arrays.sort(a);Arrays.sort(b);
		for(int i=0;i<n;i++)
		{
		    int k=(m+b[0]-a[i])%m;
		    boolean b1=true;
		    for(int j=1;j<n;j++)
		    {
		        int j1=(j+i)%n;
		        if((m+b[j]-a[j1])%m!=k)
		        {
		            b1=false;break;
		        }
		    }
		    if(b1)
		    min=(int)Math.min(min,k);
		}
		System.out.println(min);;
	}
}
