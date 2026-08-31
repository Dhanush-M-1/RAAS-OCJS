import java.util.HashMap;
import java.util.Scanner;

/*
 * http://codeforces.com/problemset/problem/268/A
 */

public class Games
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num_teams = sc.nextInt();
		
		HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < num_teams; ++i)
		{
			int num = sc.nextInt();
			if (!left.containsKey(num))
			{
				left.put(num, 1);
			}
			else
			{
				left.put(num, left.get(num) + 1);
			}
	
			num = sc.nextInt();
			if (!right.containsKey(num))
			{
				right.put(num, 1);
			}
			else
			{
				right.put(num, right.get(num) + 1);
			}
		}
		
		int count = 0;
		for (Integer i : left.keySet())
		{
			if (left.containsKey(i) && right.containsKey(i))
			{
				count += (left.get(i) * right.get(i));
			}
		}
		
		System.out.println(count);
	}
}
