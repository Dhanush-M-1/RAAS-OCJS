import java.util.*;

public class CompilationErrors 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		ArrayList<Integer> og = new ArrayList<Integer>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		
		for(int i = 0; i < num; i++)
		{
			og.add(sc.nextInt());
		}
		
		for(int i = 0; i < num - 1; i++)
		{
			first.add(sc.nextInt());
		}
		
		for(int i = 0; i < num - 2; i++)
		{
			second.add(sc.nextInt());
		}
		
		Collections.sort(og);
		Collections.sort(first);
		Collections.sort(second);
		
		/*for(Integer i : og)
		{
			System.out.print(i + " ");
		}
		
		System.out.println();
		for(Integer i : first)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		for(Integer i : second)
		{
			System.out.print(i + " ");
		}
		System.out.println();*/
		
		int one = 0;
		int two = 0;
		
		for(int i = 0; i < og.size(); i++)
		{
			if(i < first.size() && (int) og.get(i) != (int) first.get(i))
			{
				one = og.get(i);
				break;
			}
			else
				one = og.get(og.size() - 1);
		}
		
		for(int i = 0; i < first.size(); i++)
		{
			if(i < second.size() && (int) first.get(i) != (int) second.get(i))
			{
				two = first.get(i);
				break;
			}
			else
				two = first.get(first.size() - 1);
		}
		
		System.out.println(one);
		System.out.println(two);
	}
}
