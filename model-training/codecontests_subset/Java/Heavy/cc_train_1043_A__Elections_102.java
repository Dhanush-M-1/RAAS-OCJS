import java.io.*;
import java.util.*;

public class cf519A
{
	public static void main(String[] ar)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] a = new int[n];
		int max=0,sum1=0,sum=0;
		for(int i=0;i<n;i++)
		{
			int num = Integer.parseInt(s[i]);
			if(num>max)
				max=num;
			sum+=num;
		}
		while(sum1<=sum)//insert condition
		{
			sum1=0;
			for(int i=0;i<n;i++)
			{
				sum1+=(max-Integer.parseInt(s[i]));
			}
			if(sum1>sum)break;
			max++;
		}
		out.println(max);
		out.flush();
	}
}

