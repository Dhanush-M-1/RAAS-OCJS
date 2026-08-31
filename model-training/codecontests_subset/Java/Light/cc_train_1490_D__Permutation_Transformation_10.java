

import java.util.Scanner;

public class Forces {
	private static void sport(int[] a) {
		A helper = helper(a, 0, a.length - 1);
		int[] ans = new int[a.length];
		dfs(helper, ans, 0);
		for (int i = 0; i < a.length; i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
	}

	private static void dfs(A root, int[] a, int curr) {
		if (root == null) {
			return;
		}
		a[root.idx] = curr;
		dfs(root.left, a, curr + 1);
		dfs(root.right, a, curr + 1);
	}

	private static A helper(int[] a, int l, int r) {
		if (l > r) {
			return null;
		}
		int max = 0;
		int imax = -1;
		for (int i = l; i <= r; i++) {
			if (max < a[i]) {
				max = a[i];
				imax = i;
			}
		}
		A root = new A(max, imax);
		root.left = helper(a, l, imax - 1);
		root.right = helper(a, imax + 1, r);
		return root;
	}

	private static class A {
		int val;
		int idx;

		public A(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		A left;
		A right;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}
			sport(a);
		}
	}
}
