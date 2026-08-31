import java.util.*;

public class Main{
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long prime = (long)1e9 + 7;
		
		boolean[] ok = new boolean[N + 1];
		Arrays.fill(ok, true);
		for(int i = 0; i < M; i++) {
			ok[sc.nextInt()] = false;
		}
		sc.close();
		
		long stair[] = new long[N + 1];
		Arrays.fill(stair, 0);
		stair[0] = 1;
		for(int i = 0; i < N + 1; i++) {
			if(i < N)stair[i + 1] = (stair[i + 1] + ((ok[i + 1])?stair[i]:0)) % prime;
			if(i < N - 1)stair[i + 2] +=  (stair[i + 2] + ((ok[i + 2])?stair[i]:0)) % prime;
		}
		
		System.out.println(stair[N]);
	}
}