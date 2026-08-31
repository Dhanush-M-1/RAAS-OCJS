import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int M = scan.nextInt();

		boolean[] flg = new boolean[N + 1];
		for(int i = 0; i <= N; i++) {
			flg[i] = true;
		}
		for(int i = 0; i < M; i++) {
			flg[scan.nextInt()] = false;
		}
		int[] b = new int[N + 1];
		b[0] = 1;
		b[1] = 1;

		int mod = 1000000007;
		for(int i = 2; i <= N; i++)
		{
			b[i] = 0;
			if(flg[i - 2]) {
				b[i] += b[i -2];
			}
			if(flg[i - 1]) {
				b[i] += b[i -1];
			}
			b[i] %= mod;
		}

		System.out.println(b[N]);
	}
}