import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static int[] color;
	public static LinkedList<Integer>[] adj;
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] w = new int[n];
		int[] b = new int[m];
		for(int i = 0; i < n; i++) {
			w[i] = in.nextInt();
		}
		boolean[] visited = new boolean[n];
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i < m; i++) {
			b[i] = in.nextInt() - 1;
			if(!visited[b[i]]) {
				stack.add(b[i]);
				visited[b[i]] = true;
			}
		}
		int weight = 0;
		for(int i = 0; i < m; i++) {
			int lw = 0, j = 0;
			for(; stack.get(j) != b[i]; j++) {
				lw += w[stack.get(j)];
			}
			stack.addFirst(stack.remove(j));
			weight += lw;
		}
		System.out.println(weight);
	}
}