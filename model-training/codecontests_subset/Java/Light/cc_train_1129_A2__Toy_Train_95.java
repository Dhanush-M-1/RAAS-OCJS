import java.util.Arrays;
import java.util.Scanner;

public class p001129a2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] numCandie = new int[n];
		int[] min = new int[n];
		Arrays.fill(min, Integer.MAX_VALUE);
		for(int i = 0; i < m; i++) {
			int from = in.nextInt()-1;
			int to = in.nextInt()-1;
			numCandie[from]++;
			if(to > from) min[from] = Math.min(min[from], to-from);
			else min[from] = Math.min(min[from], n-from+to);
		}
		int max0 = 0;
		int[] t = new int[n];
		for(int i = 0; i < n; i++) {
			if(numCandie[i] == 0) {
				t[i] = Integer.MIN_VALUE/2;
				continue;
			}
			t[i] = (numCandie[i]-1)*n+min[i];
			max0 = Math.max(max0, t[i]+i);
		}
		System.out.print(max0 + " ");
		
		for(int i = 1; i < n; i++) {
			max0 = Math.max(max0-1, t[i-1]+n-1);
			max0 = Math.max(max0, 0);
			System.out.print(max0 + " ");
		}
		System.out.println();
	}
}
