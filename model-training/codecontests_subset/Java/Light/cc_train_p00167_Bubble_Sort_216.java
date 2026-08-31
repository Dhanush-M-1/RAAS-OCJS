import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		while(stdIn.hasNext())
		{
			int n = stdIn.nextInt();
			if(n == 0)
			{
				break;
			}
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < n; ++i)
			{
				int a = stdIn.nextInt();
				list.add(a);
			}
			int count = 0;
			for(int i = 0; i < n; ++i)
			{
				for(int j = 0; j < n - i - 1; ++j)
				{
					if(list.get(j) > list.get(j + 1))
					{
						int temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);;
						++count;
					}
				}
			}
			System.out.println(count);
		}
	}
}