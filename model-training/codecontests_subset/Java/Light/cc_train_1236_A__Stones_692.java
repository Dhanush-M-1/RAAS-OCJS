import java.util.Scanner;

public class stones {
	static int[][][] dp=new int[101][101][101];
	static int[][][] version=new int[101][101][101];
	static int tt;
	static int best(int a, int b, int c) {
		int ans=0;
		if(version[a][b][c]==tt)return dp[a][b][c];
		version[a][b][c]=tt;
		if(a>=1&&b>=2) {
			ans=1+best(a-1,b-2,c);
		}
		if(b>=1&&c>=2) {
			ans=Math.max(ans,1+best(a,b-1,c-2));
		}
		return dp[a][b][c]=ans;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int nq=s.nextInt();
		for(tt=1;tt<=nq;tt++) {
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			System.out.println(3*best(a,b,c));
		}
	}
}
