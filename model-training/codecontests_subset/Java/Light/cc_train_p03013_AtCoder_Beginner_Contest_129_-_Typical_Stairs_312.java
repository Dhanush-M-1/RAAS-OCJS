import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int mod = 1000000007;
		int n = in.nextInt();
		int m = in.nextInt();
		int[] ans = new int[n+1];
		for(int i=0;i<m;i++) {
			ans[in.nextInt()] = -1;
		}
		ans[0] = 1;
		if(ans[1]==0) ans[1] = 1;
		for(int i=2;i<=n;i++) {
			if(ans[i]==-1) continue;
			else if(ans[i-1]==-1 && ans[i-2]==-1) ans[i] = 0;
			else if(ans[i-1]==-1) ans[i] = ans[i-2];
			else if(ans[i-2]==-1) ans[i] = ans[i-1];
			else ans[i] = (ans[i-1] + ans[i-2]) % mod;
		}
		System.out.println(ans[n]);
		in.close();

	}

}
