import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> weighs = new ArrayList<Integer>();
	static ArrayList<Integer> b = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++)
			weighs.add(sc.nextInt());

		HashSet<Integer> saved = new HashSet<Integer>();
		ArrayList<Integer> sq = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			int t = sc.nextInt() - 1;
			if (!saved.contains(t))
				sq.add(t);
			saved.add(t);
			b.add(t);
		}

		for (int i = 0; i < n; i++)
			if (!saved.contains(i))
				sq.add(i);

		long cost = 0L;
		for (int i = 0; i < b.size(); i++) {
			int toBeRead = b.get(i);
			long sum = 0L;
			for (int j = 0; j < sq.size() && sq.get(j) != toBeRead; j++) {
				sum += weighs.get(sq.get(j));
			}

			cost += sum;
			sq.remove(new Integer(toBeRead));
			sq.add(0, toBeRead);
			
		}

		System.out.println(cost);
	}
}
