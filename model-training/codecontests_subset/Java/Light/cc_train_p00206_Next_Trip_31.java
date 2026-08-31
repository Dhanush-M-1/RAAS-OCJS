import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		while(stdIn.hasNext())
		{
			int price = stdIn.nextInt();
			if(price == 0)
			{
				break;
			}
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < 12; ++i)
			{
				int in = stdIn.nextInt();
				int out = stdIn.nextInt();
				list.add(in - out);
			}
			boolean endFlag = false;
			int sum = 0;
			for(int i = 0; i < 12; ++i)
			{
				sum += list.get(i);
				if(sum >= price)
				{
					System.out.println(i + 1);
					endFlag = true;
					break;
				}
			}
			if(!endFlag)
			{
				System.out.println("NA");
			}
		}
	}
}