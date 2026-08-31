import java.util.*;

public class MultiplyBy2DivideBy6
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int counter = 0;
		boolean multiply = false;
		for (int i = 0; i < t; i++)
		{
			int n = input.nextInt();
			if (n == 1)
			{
				counter = 0;
			}
			else
			{
				multiply = false;
				counter = 0;
				do
				{
					counter++;
					if (n % 6 == 0)
					{
						multiply = false;
						n /= 6;
					}
					else
					{
						if (multiply == true)
						{
							counter = -1;
							break;
						}
						else
						{
							n *= 2;
							multiply = true;
						}
					}
				}
				while (n != 1);
			}
			System.out.println(counter);
		}
	}

}
						 		   	 				 		    	    	