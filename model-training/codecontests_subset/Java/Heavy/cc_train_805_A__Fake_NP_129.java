import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TempTest
{

	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer count = 0;

		try
		{
			String[] array = br.readLine().split(" ");
			int min = Integer.parseInt(array[0]);
			int max = Integer.parseInt(array[1]);
			if (max - min == 0 && max % 2 == 0)
			{
				System.out.println("2");
				return;
			}
			else if (max - min == 0 && max % 3 == 0)
			{
				System.out.println("3");
				return;
			}
			else if (max - min == 0 && max % 2 != 0 && max % 3 != 0)
			{
				System.out.println(max);
				return;
			}
			else
			{
				int r2 = max / 2 - (min - 1) / 2;
				int r3 = max / 3 - (min - 1) / 3;
				if (r2 >= r3)
				{
					System.out.println("2");
				}
				else
				{
					System.out.println("3");
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	}