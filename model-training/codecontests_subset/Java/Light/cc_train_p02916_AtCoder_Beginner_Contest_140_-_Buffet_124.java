import java.util.*;

class Main {
	Scanner sc;
	int N;
	int[] a, b, c;

	Main() {
		sc = new Scanner(System.in);
	}
	
	void calc() {
		N = sc.nextInt();
		a = new int[N+1];
		b = new int[N+1];
		c = new int[N];
		
		for (int i = 0; i < N; i++) a[i+1] = sc.nextInt();
		for (int i = 0; i < N; i++) b[i+1] = sc.nextInt();
		for (int i = 1; i < N; i++) c[i] = sc.nextInt();
		
		int s = 0;
		for (int i = 1; i <= N; i++) {
			s += b[a[i]];
			if (i < N && (a[i]+1) == a[i+1]) s += c[a[i]];
		}
		
		System.out.println(s);
	}

	public static void main(String[] args) {
		new Main().calc();
	}

}