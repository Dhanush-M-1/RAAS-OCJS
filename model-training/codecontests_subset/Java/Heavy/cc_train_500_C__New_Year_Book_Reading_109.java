import java.io.*;
import java.util.*;

public class C {
	
	static int[] order;
	static int[] w;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String[] split = f.readLine().split("\\s+");
		int n = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
		w = new int[n+1];
		split = f.readLine().split("\\s+");
		for(int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(split[i-1]);
		}
		split = f.readLine().split("\\s+");
		order = new int[m];
		for(int i = 0; i < m; i++) order[i] = Integer.parseInt(split[i]);
		
		boolean[] used = new boolean[n+1];
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0; i < order.length; i++) {
			if(!used[order[i]]) {
				used[order[i]] = true;
				a.add(order[i]);
			}
		}
		for(int i = 1; i <= n; i++) {
			if(!used[i]) {
				a.add(i);
			}
		}
		System.out.println(solve(a, order, w));
	}
	
	static void perm(boolean[] used, int at, int[] a) {
		if(at == a.length) {
			ArrayList<Integer> use = new ArrayList<>();
			for(Integer i : a) use.add(i);
			min = Math.min(min, solve(use, order, w));
			return;
		} else {
			for(int i = 0; i < a.length; i++) {
				if(!used[i]) {
					used[i] = true;
					a[at] = i+1;
					perm(used, at+1, a);
					used[i] = false;
				}
			}
		}
	}
	
	static int solve(ArrayList<Integer> a, int[] order, int[] w) {
		int res = 0;
		for(int i = 0; i < order.length; i++) {
			int idx = find(order[i], a);
			int add = 0;
			for(Integer j : a) {
				if(j == order[i]) break;
				add += w[j];
			}
			res += add;
			a.remove(idx);
			a.add(0, order[i]);
		}
		
		return res;
	}
	
	static int find(int num, ArrayList<Integer> a) {
		int count = 0;
		for(Integer i : a) {
			if(i == num) return count;
			count++;
		}
		return -1;
	}
}