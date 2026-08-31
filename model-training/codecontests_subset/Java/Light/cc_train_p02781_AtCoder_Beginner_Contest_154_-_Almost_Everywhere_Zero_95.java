import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		int K = sc.nextInt();
		System.out.println(solve(N, K));
//		for(int i=1; i<1000000; i++) {
//			String N = String.valueOf(i);
//			for(int K=1; K<=3; K++) {
//				long ans1 = solve(N, K);
//				long ans2 = solve2(N, K);
//				if(ans1 != ans2) {
//					System.out.println("N=" + N);
//					System.out.println("K=" + K);
//					System.out.println("ans1=" + ans1);
//					System.out.println("ans2=" + ans2);
//					return;
//				}
//			}
//		}
		
		sc.close();
	}
	
	static long solve2(String N, int K) {
		int max = Integer.valueOf(N);
		int ans = 0;
		for(int i=1; i<=max; i++) {
			int v = i;
			int cnt = 0;
			while(v>0) {
				if(v%10>0)
					cnt++;
				v /= 10;
			}
			if(cnt==K)
				ans++;
		}
		return ans;
	}
	
	static long solve(String N, int K) {
		
		int L = N.length();
		int[] d = new int[L];
		for(int i=0; i<L; i++)
			d[i] = N.charAt(i)-'0';
		
		long ans = 0;
		
		int i2 = -1;
		for(int i=1; i<L; i++) {
			if(d[i]!=0) {
				i2 = i;
				break;
			}
		}
		int i3 = -1;
		if(i2>0) {
			for(int i=i2+1; i<L; i++) {
				if(d[i]!=0) {
					i3 = i;
					break;
				}
			}
		}
		
		if(K==1) {
			// 12345
			// x0000
			ans += d[0];
			// .x000
			ans += 9*(L-1);
			// 20345
			// 20300
		} else if(K==2) {
			if(i2 > 0) {
				ans += d[i2];
				ans += 9*(L-i2-1);
			}
			if(d[0]>1 && L>=2) {
				ans += (d[0]-1) * 9 * (L-1);
			}
			if(L>2) {
				ans += 9*9*(L-1)*(L-2)/2;
			}
		} else if(K==3) {
			if(i3 > 0) {
				ans += d[i3];
				ans += 9*(L-i3-1);
			}
			if(i2 > 0) {
				ans += (d[i2]-1) * 9*(L-i2-1);
				ans += 9 * 9*(L-i2-1)*(L-i2-2)/2;
			}
			if(d[0]>1 && L>=3) {
				ans += (d[0]-1) * 9 * 9*(L-1)*(L-2)/2;
			}
			if(L>3) {
				ans += 9*9*9*(L-1)*(L-2)*(L-3)/6;
			}
		}
		
		return ans;
	}

}

