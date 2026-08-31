import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BearAndTwoPaths {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int edges = n + 1;
		if (n == 4 || k < edges) {
			System.out.println(-1);
			return;
		}
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a1.add(a);
		a1.add(c);
		a2.add(c);
		a2.add(a);
		for (int u = 1; u <= n; u++)
			if (u != a && u != b && u != c && u != d) {
				a1.add(u);
				a2.add(u);
			}
		a1.add(d);
		a1.add(b);
		a2.add(b);
		a2.add(d);
		System.out.print(a1.get(0));
		for (int i = 1; i < a1.size(); i++)
			System.out.print(" " + a1.get(i));
		System.out.println();
		System.out.print(a2.get(0));
		for (int i = 1; i < a2.size(); i++)
			System.out.print(" " + a2.get(i));
		System.out.println();
	}
}
