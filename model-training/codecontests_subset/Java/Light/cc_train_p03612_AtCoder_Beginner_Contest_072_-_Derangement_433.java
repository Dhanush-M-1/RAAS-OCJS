import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		boolean[] b = new boolean[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt()-1;
			updateJudge(p, b, i);
		}

		int cnt = 0;
		for (int i = 0; i < n-1; i++) {
			if( !b[i] ) {
				swap(p, i, i+1);
				updateJudge(p, b, i);
				updateJudge(p, b, i+1);
				cnt++;
			}
		}
		int i=n-1;
		if( !b[i] ) {
			swap(p, i, i-1);
			updateJudge(p, b, i);
			updateJudge(p, b, i-1);
			cnt++;
		}

		System.out.println(cnt);
	}

	private static void updateJudge(int[] p, boolean[] b, int i) {
		b[i] = p[i]!=i;
	}

	private static void swap(int[] p, int i, int j) {
		int t = p[i];
		p[i] = p[j];
		p[j] = t;
	}
}