import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}

	private void execute() {
		Scanner sc = new Scanner(System.in);
		final long N = sc.nextLong();
		final long P = sc.nextLong();
		
		long maxGcd = 0;
		
		if(N==1) {
			maxGcd = P;
		}
		else {
			for (int i=1;; i++) {
				long g = (long) Math.pow(i, N);
				if(g>P) {
					break;
				}
				if(P%g == 0) {
					maxGcd = i;
				}
			}
		}
		
		System.out.println(maxGcd);
		//		System.out.println(cnt);
		sc.close();
	}

}
