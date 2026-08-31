import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] a = new long[M];
		
		long c = 1000000007;
		
		long[] fib = new long[N + 2];
		fib[0] = 1;
		fib[1] = 1;
		fib[2] = 2;
		
		for(int i = 3; i <= N + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			fib[i] = fib[i] % c;
		}
		 
		if(M == 0) {
			System.out.println(fib[N]);
			return;
		}
		
		for(int i = 0; i < M; i++) {
			a[i] = sc.nextInt();
			if(i > 0 && a[i] - 1 == a[i - 1]) {
				System.out.println(0);
				return;
			}
		}
		
		int now = 0;
		int x = 0;
		long sum = 1;
		int temp = 0;
		
		while(temp < N) {
			now++;
			temp++;
			if(x < M) {
				if(temp == a[x]) {
					sum = sum % c * fib[now - 1] % c;
					x++;
					now = -1;
				}
			}
		}
		sum = sum % c * fib[now] % c;
		System.out.println(sum);
	}
}
