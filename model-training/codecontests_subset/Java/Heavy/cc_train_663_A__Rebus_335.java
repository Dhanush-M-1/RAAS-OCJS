import java.util.Scanner;

public class P664B
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String[] rebus = scan.nextLine().replaceAll(" ", "").split("=");
		int n = Integer.parseInt(rebus[1]);
		String signs = "+" + rebus[0].replaceAll("[?]", "");
		int[] nums = getSigns(signs); //replace with 1's and -1's
		int ans = getSum(nums);
		if (ans < n)
		{
			int index = -1; //start at 0
			while ((index = replaceNextPositive(nums, n, index+1)) != -1)
			{
				ans += n-1;
				if (ans >= n)
				{
					nums[index] -= (ans-n);
					break;
				}
			}
			if (index == -1)
				impossible();
		}
		else if (ans > n)
		{
			int index = -1; //start at 0
			while ((index = replaceNextNegative(nums, n, index+1)) != -1)
			{
				ans -= n-1;
				if (ans <= n)
				{
					nums[index] -= (ans-n);
					break;
				}
			}
			if (index == -1)
				impossible();
		}
		System.out.println("Possible");
		printExpression(nums, n);
		scan.close();
	}
	private static void printExpression(int[] nums, int n)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++)
		{
			if (i != 0)
			{
				sb.append(nums[i] < 0 ? " - " : " + ");
			}
			sb.append(Math.abs(nums[i]));
		}
		sb.append(" = ").append(n);
		System.out.println(sb);
	}
	private static int replaceNextNegative(int[] nums, int n, int start)
	{
		for (int i = start; i < nums.length; i++)
		{
			if (nums[i] == -1)
			{
				nums[i] = -n;
				return i;
			}
		}
		return -1;
	}
	private static void impossible()
	{
		System.out.println("Impossible");
		System.exit(0);
	}
	//replace the next 1 with n
	private static int replaceNextPositive(int[] nums, int n, int start)
	{
		for (int i = start; i < nums.length; i++)
		{
			if (nums[i] == 1)
			{
				nums[i] = n;
				return i;
			}
		}
		return -1;
	}

	private static int[] getSigns(String signs)
	{
		int[] nums = new int[signs.length()];
		for (int i = 0; i < signs.length(); i++)
		{
			if (signs.charAt(i) == '-')
				nums[i] = -1;
			else
				nums[i] = 1;
		}
		return nums;
	}

	private static int getSum(int[] nums)
	{
		int ans = 0;
		for (int i = 0; i < nums.length; i++)
			ans += nums[i];
		return ans;
	}
}
