import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		int[] cntFrom = new int[n];
		int[] closest = new int[n];
		Arrays.fill(closest, n);
		for(int i=0;i<m;i++) {
			int u = in.nextInt()-1, v = in.nextInt()-1;
			cntFrom[u]++;
			closest[u] = Math.min(closest[u], (v-u+n)%n);
		}
		for(int i=0;i<n;i++) {
			int ans = n*(cntFrom[i]-1)+closest[i];
			int j = (i+1)%n;
			while(j != i) {
				int cur = n*(cntFrom[j]-1)+closest[j];
				cur += (j-i+n)%n;
				if(cntFrom[j] > 0)
					ans = Math.max(ans, cur);
				j = (j+1)%n;
			}
			System.out.println(ans);
		}
		
	}
}
