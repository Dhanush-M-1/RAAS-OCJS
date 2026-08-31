import java.util.*;
public class CF500C_NewYearBookReading {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] w = new int[n];
		int[] r = new int[m];
		ArrayList <Integer> d = new ArrayList<Integer>();
		for(int i = 0; i < n; i ++) w[i] = in.nextInt();
		for(int i = 0; i < m; i ++) {
			r[i] = in.nextInt() - 1; 
			if(!d.contains(r[i]))d.add(r[i]);
		}
		for(int i = 0; i < n; i ++){
			if(!d.contains(i))d.add(i);
		}
		int ans = 0;
		ArrayList<Integer> deck = reverse(d);
//		System.out.println(deck);
		for(int i = 0; i < m; i ++){
			int loc = deck.indexOf(r[i]);
//			System.out.println(loc);
			for(int j = loc + 1; j < n; j ++){
				ans+=w[deck.get(j)];
//				System.out.println(i + " " + w[deck.get(j)]);
			}
			deck.remove(loc);
			deck.add(r[i]);
//			System.out.println(deck);
		}
		System.out.println(ans);
	}
	public static ArrayList<Integer> reverse(ArrayList<Integer> a){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = a.size() - 1; i > -1; i --)ans.add(a.get(i));
		return ans;
	}
}
