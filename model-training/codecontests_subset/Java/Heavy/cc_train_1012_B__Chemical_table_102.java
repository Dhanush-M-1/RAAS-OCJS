import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int h;
	public static int w;
	public static int q;
	public static List<Integer>[] picture = new List[400002];
	public static boolean[] visited = new boolean[400002];
	public static int ans = 0;
	
	public static void dfs(int begin) {
		if (visited[begin]) {
			return;
		}
		visited[begin] = true;
		for (int i : picture[begin]) {
			dfs(i);
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in),65536));
		h = Integer.parseInt(in.next());
		w = Integer.parseInt(in.next());
		q = Integer.parseInt(in.next());
		Arrays.fill(visited, 1, 1 + h + w, false);
		for (int i = 1; i <= h + w; i++) {
			picture[i] = new ArrayList<>();
		}
		for (int i = 0, x, y; i < q; i++) {
			x = Integer.parseInt(in.next());
			y = Integer.parseInt(in.next());
			y += h;
			picture[x].add(y);
			picture[y].add(x);
		}
		for (int i = 1; i <= h + w; i++) {
			if (visited[i]) {
				continue;
			}
			ans++;
			dfs(i);
		}
		ans--;
		System.out.println(ans);
		in.close();
	}
}