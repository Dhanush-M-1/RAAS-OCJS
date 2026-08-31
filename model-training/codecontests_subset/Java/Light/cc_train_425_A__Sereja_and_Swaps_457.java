import java.util.*;
public class SerejaAndSwaps
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] array = new int[n];
		for(int x = 0; x < n; x++)
		{
			array[x] = in.nextInt();
		}
		
		int result = Integer.MIN_VALUE;
		for(int y = 0; y < array.length; y++)
		{
			for(int z = y; z < array.length; z++)
			{
				ArrayList<Integer> outside = new ArrayList<Integer>();
				ArrayList<Integer> inside = new ArrayList<Integer>();
				
				int current = 0;
				for(int a = 0; a < array.length; a++)
				{
					if(a >= y && a <= z)
					{
						inside.add(array[a]);
						current += array[a];
					}
					else
					{
						outside.add(array[a]);
					}
				}
				
				Collections.sort(outside);
				Collections.sort(inside);
				
				for(int b = 0; b < k && b < outside.size() && b < inside.size(); b++)
				{
					if(inside.get(b) < outside.get(outside.size() - b - 1))
					{
						current += outside.get(outside.size() - b - 1) - inside.get(b);
					}
					else
					{
						break;
					}
				}
				
				result = Math.max(result, current);
			}
		}
		
		System.out.println(result);
	}
}
