import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	final static int MAXPOS = 1000000;
	final static int THRESH = MAXPOS / 2;

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int prizeCount = scanner.nextInt();
		List<Integer> list = new ArrayList<Integer>(prizeCount);
		
		for (int i = 0; i < prizeCount; ++i)
		{
			list.add(scanner.nextInt());
		}
		
		int minSteps = find(list);
		
		System.out.printf("%d", minSteps);
	}
	
	public static int find(List<Integer> list)
	{
		if (list.get(list.size()-1) <= THRESH)
		{
			return list.get(list.size()-1) - 1;
		}
		else if (list.get(0) > THRESH)
		{
			return MAXPOS - list.get(0);
		}
		else if (list.size() > 2)
		{
			int i = list.get(list.size() / 2);
			
			if (i > THRESH)
			{
				return find(list.subList(0, (list.size() / 2) + 1));
			}
			else
			{
				return find(list.subList((list.size() / 2), list.size()));
			}
		}
		else
		{
			int min1 = list.get(0) - 1;
			int min2 = MAXPOS - list.get(list.size()-1);
			
			return min1 > min2 ? min1 : min2;
		}
	}
}