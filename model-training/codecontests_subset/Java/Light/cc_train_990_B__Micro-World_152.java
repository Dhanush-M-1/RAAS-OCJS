import java.util.*;
public class B990 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count=n;
		int k = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<n; i++)
		{
			int x = in.nextInt();
			if(map.containsKey(x))
				map.put(x, map.get(x)+1);
			else
			{
				map.put(x, 1);
				list.add(x);
			}
		}
		
		Collections.sort(list);
		n = list.size();
		
		for(int i=1; i<n; i++)
		{
			int l = list.get(i);
			int l2 = list.get(i-1);
			if(l > l2 && l <= l2 + k)
				count -= map.get(l2);	
		}
		
		System.out.println(count);
	}
}
