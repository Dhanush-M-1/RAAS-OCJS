import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		new TaskC().solve();
	}
}

class TaskC {
	Scanner in = new Scanner(System.in);

	int n;
	int x[];
	int h[];
	int left;
	int cutDown = 0;

	public void solve() {
		n = in.nextInt();
		x = new int[n];
		h = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			h[i] = in.nextInt();
		}

		if (n <= 2) {
			System.out.print(n);
			return;
		}

		cutDown = 2;
		left = x[0];

		for (int i = 1; i < n - 1; i++) {
			if (x[i] - h[i] > left) {
				// try left
				cutDown++;
				left = x[i];
			} else if (x[i] + h[i] < x[i+1]) {
				// try right
				cutDown++;
				left = x[i] + h[i];
			} else {
				// no cut
				left = x[i];
			}
		}
		
		System.out.print(cutDown);
	}

}
