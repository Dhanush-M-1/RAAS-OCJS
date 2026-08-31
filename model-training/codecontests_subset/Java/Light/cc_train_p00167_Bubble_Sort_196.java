import java.util.Scanner;

public class Main
{
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n=sc.nextInt();
			if(n==0)
				return;
			int a[]=new int[n];
			int ans=0;
			for(int i=0; i<n; i++)
			{
				a[i]=sc.nextInt();
			}
			
			for(int i=0; i<n; i++)
			{
				for(int j=0;j<n-1; j++)
					if(a[j]>a[j+1])
					{
						int tmp = a[j];
						a[j] =a[j+1];
						a[j+1]=tmp;
						ans++;
					}	
			}
			System.out.println(ans);
		}
	}
}