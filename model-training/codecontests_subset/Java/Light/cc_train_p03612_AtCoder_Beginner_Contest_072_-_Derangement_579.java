import java.util.Scanner;

public class Main {

	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] p = new int[n];
		for(int i = 0; i < n; i++) p[i] = sc.nextInt() - 1;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(p[i] == i && i != n - 1) {
				ans++;
				swap(p, i);
			} else if(p[i] == i && i == n - 1) {
				ans++;
				swap(p, i);
			}
		}
		System.out.println(ans);
	}

	static int[] swap(int[] p, int pos) {
		if(pos != n - 1) {
			int w = p[pos];
			p[pos] = p[pos + 1];
			p[pos + 1] = w;
		} else {
			int w = p[pos - 1];
			p[pos - 1] = p[pos];
			p[pos] = w;
		}
		return p;
	}

}
