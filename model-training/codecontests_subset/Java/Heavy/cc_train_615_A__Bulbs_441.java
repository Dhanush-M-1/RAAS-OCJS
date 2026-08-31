import java.io.*;
import java.util.*;
public class cdf338a
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String str[]=s.split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		int arr[]=new int[m+1];
		for(int i=0;i<n;i++)
		{
			s=br.readLine();
			String ss[]=s.split(" ");
			for(int j=1;j<ss.length;j++)
			{
				int temp=Integer.parseInt(ss[j]);
				arr[temp]=1;
			}
		}
		for(int i=1;i<=m;i++)
		{
			if(arr[i]==0)
			{
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
