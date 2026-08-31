import java.util.Scanner;
import java.util.Stack;

public class P494A
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		char[] in = scan.next().toCharArray();
		int[] paren = new int[in.length];
		int cnt = 0;
		int pound = 0;
		for (int i = 0; i < in.length; i++)
		{
			if (in[i] == '(')
				paren[i] = ++cnt;
			else if (in[i] == ')')
				paren[i] = --cnt;
			else
			{
				paren[i] = cnt;
				pound++;
			}
			if (cnt < 0)
			{
				System.out.println(-1);
				return;
			}
		}
		int left = cnt;
		int min = Integer.MAX_VALUE;
		Stack<Integer> stack = new Stack<>();
		for (int i = in.length-1; i >= 0; i--)
		{
			min = Math.min(min, paren[i]);
			if (in[i] == '#')
			{
				pound--;
				int here = min-pound;
				if (here < 1)
				{
					System.out.println(-1);
					return;
				}
				stack.add(here);
				min -= here;
				left -= here;
			}
		}
		if (left > 0)
		{
			System.out.println(-1);
			return;
		}
		while (!stack.isEmpty())
			System.out.println(stack.pop());
	}
}
