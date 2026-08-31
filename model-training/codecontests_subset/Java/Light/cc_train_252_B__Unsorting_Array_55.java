import java.util.*;
import java.io.*;
import java.lang.*;

public class TaskB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		TaskB solver = new TaskB();
		solver.solve(in, out);
		in.close();
		out.close();
	}

	private void solve(Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int[] a = new int[n];
		boolean eq = true;
		for (int i = 0; i < n; ++i)
			a[i] = in.nextInt();
		for (int i = 0; i < n - 1; ++i)
			if (a[i] != a[i + 1]) {
				eq = false;
				break;
			}
		if (eq || n < 3) {
			out.println(-1);
			return;
		}
		int index1, index2;
		for (index1 = 0; index1 < n; ++index1) {
			for (index2 = index1 + 1; index2 < n; ++index2) {
				if (a[index1] != a[index2]) {
					int temp = a[index1];
					a[index1] = a[index2];
					a[index2] = temp;
					if ( !isSorted(a, (a[index1] < a[index2])) ) {
						out.print(index1 + 1);
						out.print(" ");
						out.println(index2 + 1);
						return;
					}	
					temp = a[index1];
					a[index1] = a[index2];
					a[index2] = temp;
				}
			}
		}
		out.println(-1);
	}

	private boolean isSorted(int[] x, boolean st) {
		for (int i = 1; i < x.length; ++i)
			if ( (x[i] > x[i - 1] && !st) || (x[i] < x[i - 1] && st) )
				return false;
		return true;
	}
}