import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int count = 0;
		for (int i=0; i<n; i++) {
			if(isPrime(stdIn.nextInt()))
				count++;
		}
		System.out.println(count);
	}

	static boolean isPrime(int x){
		for (int i=2; i<=Math.pow(x,0.5); i++) {
			if(x%i == 0)
				return false;
		}
		return x!=1;
	}
}