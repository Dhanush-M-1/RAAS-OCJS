import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		new Main().run();
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		char[] cs=sc.next().toCharArray();
		int[] N=new int[cs.length];
		int K=sc.nextInt();
		for(int i=0;i<cs.length;++i) {
			N[i]=cs[i]-'0';
		}
		long[][][] dp=new long[N.length+1][K+1][2];
		dp[0][0][0]=1;
		for(int i=0;i<N.length;++i) {
			for(int j=0;j<2;++j) {
				for(int k=0;k<=K;++k) {
					for(int next=0;next<=(j==0?N[i]:9);++next) {
						int nj=next<N[i]?1:j;
						int nk=k+(next!=0?1:0);
						if(nk<=K&&nj<=2)
							dp[i+1][nk][nj]+=dp[i][k][j];
					}
				}
			}
		}
		System.out.println(dp[N.length][K][0]+dp[N.length][K][1]);
	}

	static void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}

}
