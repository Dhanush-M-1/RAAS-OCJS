import java.io.*;
import java.util.*;

public class mymy 
{
	
	public static void main(String[] args)throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		int[] a=new int[n];

		for(int i=0;i<n;i++)
		{
			a[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(a);
		int i=n/2;
		long min=Math.abs(a[i]-k);
		

		if(k>a[i])
		{
			int j=i;
			j++;
			while(j<n&&a[j]<k)
			{
				min+=Math.abs(a[j]-k);
				j++;
			}
		}
		else if(k<a[i])
		{
			i--;
			while(i>=0&&a[i]>k)
			{
				min+=(a[i]-k);
				i--;
			}

		}
		System.out.println(min);	

		
	}
}