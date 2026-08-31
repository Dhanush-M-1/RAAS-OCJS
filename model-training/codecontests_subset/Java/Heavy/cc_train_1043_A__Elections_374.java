import java.io.*;
import java.util.*;
public class SNCKYEAR
{
	static PrintStream out = new PrintStream(System.out);
	public static void main(String stga[])throws IOException
	{
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(obj.readLine());
		int a[] = new int[n];
		String ip[]=(obj.readLine().trim()).split(" ");
		int ev=0;
		int low=Integer.MIN_VALUE;
		int high=0;
		for(int x=0;x<n;x++)
		{
			a[x]=Integer.parseInt(ip[x]);
			ev+=a[x];
			if(a[x]>low)low=a[x];
		}
		high=ev;
		int k=0;
		for(k=low;;k++)
		{
			int av=0;
			for(int x=0;x<n;x++)
			{
				av+=(k-a[x]);
			}
			if(av>ev)break;
		}
		out.println(k);
	}
}