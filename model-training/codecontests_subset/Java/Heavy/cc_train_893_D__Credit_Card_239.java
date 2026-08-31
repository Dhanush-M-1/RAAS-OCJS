import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class d {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt();
		int amounts[] = new int[n];
		int pre[] = new int[n];
		int maxRight[]  = new int[n];
		for(int i = 0; i < n; i++) amounts[i] = in.nextInt();
		pre[0] = amounts[0];
		for(int i = 1 ; i < n; i++) {
			pre[i] = amounts[i] + pre[i-1]; 
		}
		maxRight[n-1] = pre[n-1];
		for(int i = n-2; i > -1; i--) {
			maxRight[i] = Math.max(maxRight[i+1], pre[i]);
		}
		
		int dx = 0;
		int ans = 0;
		for(int i = 0; i < n ;i++) {
		//	System.out.println(dx + " " + pre[i] + " " + maxRight[i] );
			if(dx +  pre[i] > k) {
				System.out.println(-1);
				return;
			}
			if(amounts[i] == 0) {
				if(dx + pre[i] < 0) {
					int mx = maxRight[i] + dx;
					int amt = k - mx;
					dx += amt;
					if(dx + pre[i] < 0) {
						System.out.println(-1);
						return;
					}
					ans ++;
				}
			}
		}
		System.out.println(ans);
	}
}
