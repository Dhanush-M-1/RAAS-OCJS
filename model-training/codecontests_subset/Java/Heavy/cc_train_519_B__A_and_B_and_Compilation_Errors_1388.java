import java.util.*;

public class Salamander
{
	public static void main(String[] args)
	{	Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++)
		{
			a[i] = s.nextInt();
		}
		Arrays.sort(a);
		int b[] = new int[n-1];
		for(int i=0; i<n-1; i++)
		{
			b[i] = s.nextInt();
		}
		Arrays.sort(b);
		int c[] = new int[n-2];
		for(int i=0; i<n-2; i++)
		{
			c[i] = s.nextInt();
		}
		Arrays.sort(c);
		int ans1 = a[n-1];
		int ans2 = b[n-2];

		for(int i=0; i<n-1; i++)
		{
			if(a[i]!=b[i])
			{
				ans1 = a[i];
				break;
			}
		}
		System.out.println(ans1);
		for(int i=0; i<n-2; i++)
		{
			if(c[i]!=b[i])
			{
				ans2 = b[i];
				break;
			}
		}
		System.out.println(ans2);

	}
}