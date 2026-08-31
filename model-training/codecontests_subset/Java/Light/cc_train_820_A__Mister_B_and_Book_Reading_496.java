import java.io.*;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class A820
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d=Integer.parseInt(st.nextToken());	
		int v0=Integer.parseInt(st.nextToken());	
		int v1=Integer.parseInt(st.nextToken());	
		int a=Integer.parseInt(st.nextToken());	
		int l=Integer.parseInt(st.nextToken());	
		int sum=0,count=0,c=0;
		while(sum<d)
		{
			if(c==0)
			{
				sum=0;
			}
			else
			{
				sum=sum-l;
			}
			if((v0+c*a)>v1)
			{
				sum=sum+v1;
			}
			else
			{
				sum=sum+v0+c*a;
			}
			c++;
		}
		System.out.println(c);
	}
}