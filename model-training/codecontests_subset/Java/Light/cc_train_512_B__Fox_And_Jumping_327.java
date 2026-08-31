/*
3
100 99 9900
1 1 1
 */
import java.util.*;
public class d {
	public static void main(String[] arg)
	{
		new d().doit();
	}
	public void doit()
	{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		long[] arr = new long[size];
		long[] cost = new long[size];
		
		for(int i = 0; i < arr.length; i++) arr[i] = in.nextLong();
		for(int i = 0; i < size; i++) cost[i] = in.nextLong();
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		
		for(int i = 0; i < arr.length; i++)
		{
			ArrayList<Long> keyset = new ArrayList<Long>();
			for(long key : map.keySet())
				keyset.add(key);
			for(int j = 0; j < keyset.size(); j++)
			{
				long key = keyset.get(j);
				if(key == arr[i]) continue;
				long temp = gcd(arr[i], key);
				if(!map.containsKey(temp))
					map.put(temp, cost[i]+map.get(key));
				else
				{
					if(cost[i]+map.get(key) < map.get(temp))
					{
						map.put(temp, cost[i]+map.get(key));
					}
				}
			}
			if(!map.containsKey(arr[i]))
				map.put(arr[i], cost[i]);
			else
			{
				if(map.get(arr[i]) > cost[i])
					map.put(arr[i], cost[i]);
			}
		}
		//for(long key: map.keySet()) System.out.println(key + " " + map.get(key));
		if(map.containsKey(1L)) System.out.println(map.get(1L));
		else System.out.println(-1);
		in.close();
	}
	public long gcd(long a, long b)
	{
		return b == 0 ? a : gcd(b, a%b);
	}
	
}
