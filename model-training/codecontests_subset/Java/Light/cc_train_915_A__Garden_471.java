import java.lang.*;
import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
		{
			int cur = in.nextInt();
			if(k % cur == 0 && cur <= k)
			{
				ans = Math.min(ans, k / cur);
			}
		}
		System.out.println(ans);
	}
}