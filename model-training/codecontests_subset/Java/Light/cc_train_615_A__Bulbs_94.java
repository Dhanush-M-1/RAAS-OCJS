import java.util.*;

public class sol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Set<Integer> bulb = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			for (int j = 0; j < x; j++) {
				int k = sc.nextInt();
				bulb.add(k);
			}
		}
		if (bulb.size() == m)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}