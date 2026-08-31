import java.util.*;

public class a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0)
		{
			int n = sc.nextInt();
			ArrayList<Integer> tr = new ArrayList<>();
			HashMap<Integer, Integer> h = new HashMap<>();
			boolean ans = true;
			for(int i = 0; i < n; i++)
			{
				int p = sc.nextInt();
				int c = sc.nextInt();
				if(h.containsKey(p))
				{
					if(h.get(p) != c)
					{
						ans = false;
					}
				}
				
				h.put(p, c);
				tr.add(p);
				
			}
			
			
			
			int l = tr.size();
			int p1 = tr.get(0);
			int c1 = h.get(p1);
			if(c1>p1)
				ans = false;
			
			for(int i = 1; i < l; i++)
			{
				int p2 = tr.get(i);
				int c2 = h.get(p2);
				
				if(c2 < c1 || p2 < p1)
					ans = false;
				else if(c2-c1 > p2-p1)
					ans = false;
				else if(c2>p2)
					ans = false;
				
				if(!ans)
					break;
				
				p1 = p2;
				c1 = c2;
				
			}
			
			if(!ans)
			{
				System.out.println("NO");
			}
			
			else
			{
				System.out.println("YES");
			}
		}
	}

}
