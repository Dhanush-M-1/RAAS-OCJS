import java.util.*;

public class Test
{
	static Scanner sc = new Scanner(System. in);
	public static void main(String args[])
	{
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a, res = Integer.MAX_VALUE;
		boolean flag = false;
		for(int i = 0;i < n;i++)
		{
			a = sc.nextInt();
			if(k % a != 0)
				continue;
			res = Math.min(res, k / a);
		}
		System.out.println(res);
	}
}
