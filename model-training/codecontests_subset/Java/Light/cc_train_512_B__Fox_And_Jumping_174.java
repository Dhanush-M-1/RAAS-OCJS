import java.util.*;
public class B
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] length = new int[n];
		for(int x = 0; x < n; x++)
		{
			length[x] = in.nextInt();
		}
		
		int[] cost = new int[n];
		for(int y = 0; y < n; y++)
		{
			cost[y] = in.nextInt();
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0));
		
		HashMap<Integer, Long> dist = new HashMap<Integer, Long>();
		dist.put(0, 0L);
		
		while(pq.size() > 0)
		{
			Node node = pq.poll();
			
			if(node.dist == dist.get(node.index))
			{
				for(int z = 0; z < length.length; z++)
				{
					int next = gcd(node.index, length[z]);
					
					long newDist = node.dist + cost[z];
					if(!dist.containsKey(next) || newDist < dist.get(next))
					{
						dist.put(next, newDist);
						pq.add(new Node(newDist, next));
					}
				}
			}
		}
		
		if(!dist.containsKey(1))
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(dist.get(1));
		}
	}
	
	public static int gcd(int a, int b)
	{
		if(b == 0)
		{
			return a;
		}
		else
		{
			return gcd(b, a % b);
		}
	}
	
	static class Node implements Comparable<Node>
	{
		long dist;
		int index;
		
		public Node(long c, int i)
		{
			dist = c;
			index = i;
		}
		
		public int compareTo(Node o)
		{
			return Long.compare(dist, o.dist);
		}
	}
}
