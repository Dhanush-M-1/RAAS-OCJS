import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CF653B
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			long n=Long.parseLong(br.readLine());
			long count3=0;
			long c=n;
			while(n>=3)
			{
				if(n%3==0) {
					count3++;
					n/=3;
				}
				else break;
			}
			long count2=0;
			while(n>=2)
			{
				if(n%2==0) {
					count2++;
					n/=2;
				}
				else break;
			}
			if(n!=1)
			{
				System.out.println(-1);
				continue;
			}
			if((long)(Math.pow(3, count3)*Math.pow(2, count2))==c)
			{
				if(count3>=count2)
				{
					System.out.println(Math.abs(count3-count2) + Math.max(count3,count2));
					continue;
				}
			}
			System.out.println(-1);
		}
	}
}