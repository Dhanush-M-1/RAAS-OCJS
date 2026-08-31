import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[M+1];
		long[] fib = new long[N+2];
		fib[0] = 1;
		fib[1] = 1;
		fib[2] = 1;
		for(int i = 3; i <= N+1; i++) {
			fib[i] = fib[i-1] + fib[i-2];
			fib[i] %= 1000000007;
		}
		for(int i = 1; i <= M; i++)
			a[i] = sc.nextInt();
		for(int i = 2; i <= M; i++)
			if(a[i] - a[i-1] == 1) {
				System.out.println(0);
				return;
			} 
		List<Long> F = new ArrayList<>();
		for(int i = 2; i <= M; i++)
			F.add(fib[a[i]-a[i-1]-1]);
		if(M != 0) {
			F.add(fib[a[1]]);
			F.add(fib[N-a[M]]);
		}
		else
			F.add(fib[N+1]);
		long ans = 1;
		for(int i = 0; i < F.size(); i++) {
			ans *= F.get(i);
			ans %= 1000000007;
		}
		System.out.println(ans);

	}

}