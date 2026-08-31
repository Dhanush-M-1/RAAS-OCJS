import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 2019/06/09
 * AtCoder Beginner Contest 129
 * 
 * C - Typical Stairs
 * 
 * @author rued97
 */
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int MOD = 1000000007;
		int N = sc.nextInt();
		int M = sc.nextInt();
		Set<Integer> as = new HashSet<>();
		for(int i = 0; i < M; i++) {
			as.add(sc.nextInt());
		}
		
		long pre1 = 0;
		long pre2 = 1;
		long now = 0;
		
		for(int i = 1; i <= N; i++) {
			if(as.contains(i)) {
				now = 0;
			} else {
				now = (pre1 + pre2) % MOD;
			}
			pre1 = pre2;
			pre2 = now;
			if(pre1 == 0 && pre2 == 0) {
				break;
			}
		}
		
		System.out.println(now);
	}
	
}