import java.util.Scanner;
import java.util.TreeSet;
import java.util.LinkedList;

public class D1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> adj[] = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<>();
		}
		int v, w;
		for (int i = 0; i < n - 1; i++) {
			v = sc.nextInt(); w = sc.nextInt();
			adj[v].add(w);
			adj[w].add(v);
		}
		for (int i = 1; i <= n; i++) {
			if (adj[i].size() == 2) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}