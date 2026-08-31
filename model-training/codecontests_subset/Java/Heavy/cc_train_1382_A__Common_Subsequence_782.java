
import java.util.*;

public class codeforces {
	static int count[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		A: while (t-- > 0) {
			int n = sc.nextInt(), m = sc.nextInt();
			HashSet<Integer> a = new HashSet<>(), b = new HashSet<>();
			for (int i = 0; i < n; i++)
				a.add(sc.nextInt());
			boolean bool = false;
			for (int i = 0; i < m; i++) {
				int v = sc.nextInt();
				if (a.contains(v) && !bool) {
					sb.append("YES\n");
					sb.append(1 + " " + v);
					bool = true;
				}
			}
			if (!bool)
				sb.append("NO");
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
