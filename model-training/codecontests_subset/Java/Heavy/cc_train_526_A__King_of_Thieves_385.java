import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class zepto2015A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();

		HashSet<Integer> h = new HashSet<>();
		LinkedList<Integer> l = new LinkedList<>();

		boolean found = false;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '*') {
				l.add(i);
				h.add(i);
			}
		}

		for (int j = 1; j < n; j++) {

			for (int i = 0; i < l.size(); i++) {
				int cur = l.get(i);

				int step = j;

				for (int jumps = 1; jumps < 5; jumps++) {
					if (h.contains(cur + step))
						step += j;
					else
						break;

					if (jumps == 4)
						found = true;
				}
			}

		}
		System.out.println(found ? "yes" : "no");
	}
}
