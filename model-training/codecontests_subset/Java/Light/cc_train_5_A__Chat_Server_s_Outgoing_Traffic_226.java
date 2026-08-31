import java.util.Scanner;
public class Solution 
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int person = 0;
		int result = 0;
		while (s.hasNext())
		{
			String info=s.nextLine();
			if (info.charAt(0) == '+')
			{
				person++;
			}
			else if(info.charAt(0) == '-')
			{
				person--;
			}
			else
			{
				result+= person*(info.length() - info.indexOf(':')-1);
			}
		}
		System.out.println(result);
	}
}