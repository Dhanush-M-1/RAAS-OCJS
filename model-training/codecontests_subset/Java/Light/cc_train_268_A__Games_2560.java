import java.util.*;

public class codeforce
{
	public static void main(String args[])
	{
		Scanner sj = new Scanner(System.in);

		int n = sj.nextInt();
		int a[] = new int[101];
		for(int i=1;i<100;i++)
			a[i] = 0;
		int x[][] = new int[n][2];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<2;j++)
			{
				x[i][j] = sj.nextInt();
				
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(j==1)
				{
					a[x[i][j]]++;
				}
			}
		}
		int count = 0;
		for(int i=0;i<n;i++)
		{
			int p = x[i][0];
			if(a[p]!=0)
			{
				count += a[p];
			}
		}
		System.out.println(count);

	}
}