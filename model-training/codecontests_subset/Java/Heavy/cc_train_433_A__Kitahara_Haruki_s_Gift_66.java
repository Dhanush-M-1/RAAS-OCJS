import java.util.*;
public class TestDemo
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n>=1&&n<=100)
		{
			int[] array = new int[n];
			int sum = 0;
			for(int i = 0;i<n;i++)
			{
				array[i] = input.nextInt();
			}
			int count = 0;
			for(int i = 0;i<n;i++)
			{
				if(array[i]==200)
				{
					count++;
				}
			}
			for(int i = 0;i<n;i++)
			{
				sum = sum + array[i];
	 		}
			if(count%2!=0&&count==n)
			{
				System.out.println("NO");
			}
			else if((sum/100)%2==0)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
		input.close();
	}
}