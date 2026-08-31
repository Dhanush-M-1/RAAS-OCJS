import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		//    	File file = new File("src/in.txt");
		//    	Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] n = new int[N+1];

		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			n[x] = 1;
		}
		int cnt = 1;
		long ans = 1;
		for (int i=1;i<=N;i++) {
			if(n[i]!=1) {
				cnt++;
			} else {
				ans = mod(ans * mod(solve(cnt)));
				cnt =0;
			}
		}
		ans = mod(ans * mod(solve(cnt)));
		System.out.println(ans);
	}

	public static long solve(int N) {
		if (N==0) return 0;
		if (N==1||N==2)	return 1;
		long num1 = 1;
		long num2 = 1;
		long tmp = 1;
		for (int i = 1; i < N-1; i++) {
			tmp = mod(num1 + num2);
			num1 = mod(num2);
			num2 = mod(tmp);
		}
		return tmp;

	}

	public static long mod(long N) {

		return (long) N % 1000000007;

	}

}
