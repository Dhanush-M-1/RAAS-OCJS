import java.util.*;
public class BarkToUnlock {

	void solve()
	{
		Scanner sc = new Scanner(System.in);
		String p = sc.next();
		int n = sc.nextInt();
		
		ArrayList<Integer> f = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			String x = sc.next();
			
			if(x.equals(p))
			{
				f.add(i);
				s.add(i);
			}
			
			if(x.charAt(1)==p.charAt(0))
				f.add(i);
			if(x.charAt(0)==p.charAt(1))
				s.add(i);
		}
		
		if(!f.isEmpty() && !s.isEmpty())
			System.out.println("YES");
		else
			System.out.println("NO");
		
		
		
	}
	
	public static void main(String[] args) {
		new BarkToUnlock().solve();

	}

}
