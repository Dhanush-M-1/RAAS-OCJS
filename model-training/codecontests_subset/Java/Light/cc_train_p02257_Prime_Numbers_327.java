import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		boolean[] prime = new boolean[100000000];
		Arrays.fill(prime,true);
		prime[0] = false;
		prime[1] = false;

		for (int i=2; i<100000000; i++) {
			if (prime[i]) {
				for (int j=i; j<100000000; j+=i) {
					prime[j] = false;
				}
				prime[i] = true;
			}
		}

		int count = 0;
		for (int i=0; i<n; i++) {
			if(prime[stdIn.nextInt()])
				count++;
		}
		System.out.println(count);
	}
}