import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int ans = 0;
		for(int i = 0;i < N;i++) {
			int a = scn.nextInt();
			boolean prime = true;
			for(int j = 2;j <= Math.sqrt(a);j++) {
				if(a % j == 0) {
					prime = false;
					break;
				}
			}
			if(prime)ans++;
		}
		System.out.println(ans);
	}

}

