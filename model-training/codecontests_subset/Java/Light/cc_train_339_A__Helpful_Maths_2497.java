import java.util.*;
public class Main
{
	static Scanner myScan = new Scanner(System.in);
	public static void main(String[] args)
	{
		String sum = myScan.next();
		int[] nums = new int[(sum.length()/2)+1];
		int index = 0;

		for (char c : sum.toCharArray())
		{
			if (c != '+')
			{
				nums[index] = Character.getNumericValue(c);
				index++;
			}
		}
		
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i++)
		{
			System.out.print(nums[i]+"+");
		}
		System.out.print(nums[nums.length-1]);
	}
}