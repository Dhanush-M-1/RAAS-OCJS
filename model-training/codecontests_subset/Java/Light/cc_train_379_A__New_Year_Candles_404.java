import java.util.*;
public class bang
{
	public static void main(String[] arg)
	{
		new bang();
	}
	public bang()
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int cur = a;
		int leftover = 0;
		int answer = 0;
		while(cur > 0)
		{
			answer++;
			cur--;
			leftover++;
			if(leftover == b)
			{
				cur++;
				leftover -= b;
			}
		}
		System.out.println(answer);
		in.close();
	}
}