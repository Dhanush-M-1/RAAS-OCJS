import java.util.*;
import java.lang.*;

// https://codeforces.com/contest/1421/problem/B
public class B1421 {

	static Scanner sc;
	public static void solve() {
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			char[] s = sc.next().toCharArray();
			for(int j = 0; j < n; j++) {
				if(s[j] == 'S' || s[j] == 'F') {
					map[i][j] = -1;
				} else {
					map[i][j] = Integer.parseInt(s[j]+"");
				}
			}
		}
		int start = map[0][1] + map[1][0];
		int end = map[n-1][n-2] + map[n-2][n-1];
		
		if((start == 0 || start == 2) && start + end == 2) {
			System.out.println(0);
			return;
		}
		

		List<int[]> ans = new ArrayList();

		// if end is fine and start needs one switch
		if(end == 2 || end == 0) {
			int target = map[n-1][n-2];
			if(map[0][1] == target) ans.add(new int[] {0, 1});
			if(map[1][0] == target) ans.add(new int[] {1, 0});
		}
		// if start is fine and end needs one switch
		else if(start == 2 || start == 0) {
			int target = map[0][1];
			if(map[n-1][n-2] == target) ans.add(new int[] {n-1, n-2});
			if(map[n-2][n-1] == target) ans.add(new int[] {n-2, n-1});
		}
		else if (start == 1 || end == 1) {
			int target = map[n-1][n-2];
			if(map[0][1] == target) ans.add(new int[] {0, 1});
			if(map[1][0] == target) ans.add(new int[] {1, 0});
			
			if(map[n-1][n-2] != target) ans.add(new int[] {n-1, n-2});
			if(map[n-2][n-1] != target) ans.add(new int[] {n-2, n-1});
		}
		
		System.out.println(ans.size());
		for(int[] c: ans) {
			System.out.println((c[0]+1) +" "+ (c[1]+1));
		}
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			solve();
		}
		
		System.out.println("");
		sc.close();
	}

}
