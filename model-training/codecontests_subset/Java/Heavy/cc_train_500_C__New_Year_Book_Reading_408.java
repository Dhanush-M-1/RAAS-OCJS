import java.util.Scanner;
import java.util.Stack;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] w = new int[n];
		int[] r = new int[m];
		for (int i = 0; i < w.length; i++) {
			w[i] = sc.nextInt();
		}
		for (int i = 0; i < r.length; i++) {
			r[i] = sc.nextInt();
		}
		
		sc.close();
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();

		int cost = 0;
		a.push(r[0]);
		for (int i = 1; i < r.length; i++) {
			int cur = r[i];

			while (true) {
				if (a.isEmpty()) {
					while (!b.isEmpty()) {
						a.push(b.pop());
					}
					a.push(cur);
					break;
				} else {
					int pop = a.pop();
					if (pop == cur) {
						while (!b.isEmpty()) {
							a.push(b.pop());
						}
						a.push(cur);
						break;
					} else {
						cost += w[pop - 1];
						b.push(pop);
					}
				}
			}
		}
		System.out.println(cost);
	}
}