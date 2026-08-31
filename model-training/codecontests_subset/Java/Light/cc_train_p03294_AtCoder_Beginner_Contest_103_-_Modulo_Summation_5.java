import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int N = keyboard.nextInt();
		long[] A = new long[N];
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			A[i] = keyboard.nextLong();
			sum = sum+A[i]-1;
		}
		
		System.out.println(sum);
		keyboard.close();
	}
}