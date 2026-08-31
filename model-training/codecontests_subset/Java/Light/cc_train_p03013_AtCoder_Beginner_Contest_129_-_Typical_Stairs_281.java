import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1_000_000_007;
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[M];
		int[] flag = new int[2];
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i=0;i<M;i++) {
			a[i] = sc.nextInt();
			set.add(a[i]);
			if (a[i]==1) {
				flag[0]=1;
			} else if(a[i]==2) {
				flag[1]=1;
			}
		}
		if (N==1) {
			System.out.println(1);
		} else {
			int[] ans = new int[N+1];
			if (flag[0]==0) {
				ans[1]=1;
			}
			if (flag[1]==0) {
				ans[2]=1;
			}
			for (int i=0;i<N;i++) {
				if (i!=N-1) {
					if (!set.contains(i+2)) {
						ans[i+2]=(ans[i+2]+ans[i])%mod;
					}
				}
				if (!set.contains(i+1)) {
					ans[i+1]=(ans[i+1]+ans[i])%mod;
				}
			}

			System.out.println(ans[N]);
		}
	}
}