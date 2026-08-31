import java.util.*;
import java.io.*;
public class tri
{
	public static void main(String args[]) throws IOException
	{
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=0;
		t=Integer.parseInt(br.readLine());
		while(t!=0)
		{
			int n=0;
			n=Integer.parseInt(br.readLine());
			String arr[]=br.readLine().split(" ");
			boolean brc=false;
			for(int i=0;i<n-2;i++)
			{
				long a=Long.parseLong(arr[i]);
				long b=Long.parseLong(arr[i+1]);
				long c=Long.parseLong(arr[n-1]);
				if(a+b<=c)
				{
					System.out.println((1)+" "+(2)+" "+n);
					brc=true;
					break;
				}
			}
			if(brc==false)
			{
				System.out.println("-1");
			}
			--t;
		}
	}
	catch(Exception e){}
}}