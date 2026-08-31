import java.util.*;

public class Yash 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean a[] = new boolean[m];
		for(int i=0; i<n; i++)
		{
			int k = sc.nextInt();
			for(int j=0; j<k; j++)
			{
				int x = sc.nextInt();
				a[x-1] = true;
			}
		}
		
		for(int i=0; i<m; i++)
		{
			if(a[i]==false)
			{
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}