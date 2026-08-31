import java.util.*;
// warm-up
public class Main {

	static void solve() {
		Scanner sc = new Scanner(System.in);
		Set<Integer> s = new HashSet<Integer>();
		int N = sc.nextInt(), i = 1, t = 0;
		while (N-->0) {
			int a = sc.nextInt();
			if (s.contains(a-1) && a==i) t--;
			if (a==i) { 
				if (!s.contains(a-1)) s.add(a); 
				t++; 
			}
			i++;
		}
		System.out.println(t);
		sc.close();		
	}

	public static void main(String args[]) {
		solve();
	}

}