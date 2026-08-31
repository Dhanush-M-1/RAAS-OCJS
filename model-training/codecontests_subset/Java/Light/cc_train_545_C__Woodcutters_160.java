
import java.util.Scanner;

public class Woodcutters2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] x = new int[n];
		int[] h = new int[n];
		for(int i=0;i<n;i++)
		{
			x[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		int ans = 0; 
		int last = -(int)(1e9+1000);

		for(int i=0;i<n;i++)
		{
			if(x[i]-h[i]>last)
			{
				ans++;
				last = x[i];
			}
			else
			{
				if(i == n-1 || x[i]+h[i]<x[i+1])
				{
					last = x[i] + h[i];
					ans++;
				}
				else
				{
					last = x[i];
				}
			}
		}
		System.out.println(ans);
	}
}