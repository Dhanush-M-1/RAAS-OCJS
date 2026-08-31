import java.util.*;

public class GameOfRobots
{
	public static void main(String args[])
	{
		int n,k;
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		k=s.nextInt();
		int[] a=new int[n];
		ArrayList al=new ArrayList();
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		/*for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				al.add(a[j]);
			}
		}*/
		for(int i=0;i<n;i++)
		{
			if(k-i>0)
			{
				k=k-i;
			}
			else
			{
				i=n+1;
			}
		}
		System.out.print(a[k-1]);
	}
}