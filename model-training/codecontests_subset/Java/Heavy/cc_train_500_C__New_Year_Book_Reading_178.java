import java.util.*;

public class main
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		int[] weights = new int[n+1];
		int weight=0;
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		for(int h=1;h<=n;h++)
		{
			weights[h]=s.nextInt();
		}
		
		for(int h=0;h<m;h++)
		{
			int a = s.nextInt();
			if(l.contains(a))
			{
				LinkedList<Integer> in = new LinkedList<Integer>();
				while(l.getLast()!=a)
				{
					int r = l.removeLast();
					weight+=weights[r];
					in.add(r);
				}
				l.removeLast();
				while(in.size()!=0)
				{
					l.add(in.removeLast());
				}
				l.add(a);
			}
			else
			{
				for(int y=0;y<l.size();y++)
					weight+=weights[l.get(y)];
				l.add(a);
			}
		}
		
		System.out.println(weight);
	}
}