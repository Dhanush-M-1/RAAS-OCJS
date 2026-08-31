import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String nstr = scan.next();
		int k = scan.nextInt();
		int l = nstr.length();
		int[] n = new int[l];
		for(int i = 0; i<l; i++) {
			n[i] = Integer.parseInt(nstr.substring(i, i+1));	//n[i] : nのi+1桁目
		}

		int[][] dp0 = new int[l][k+1];
		int[][] dp1 = new int[l][k+1];

		dp0[0][0] = 1;
		dp0[0][1] = n[0]-1;
		dp1[0][0] = 0;
		dp1[0][1] = 1;

		int n0cnt = 1;	//非0の桁のカウント
		for(int i = 1; i < l; i++ ) {
			dp0[i][0] = 1;
			dp1[i][0] = 0;
			int nm1 = 0;	//n[i]-1 ただし，n[i] = 0のとき，0とする
			if(n[i] > 0) {
				nm1 = n[i]-1;
				n0cnt++;
			}
			for(int j = 1; j < k+1; j++) {
				dp0[i][j] = dp0[i-1][j] + dp0[i-1][j-1]*9 + dp1[i-1][j-1]*(nm1);
				if(n[i] > 0) {
					dp0[i][j] += dp1[i-1][j];
				}
				if(j == n0cnt) {
					dp1[i][j] = 1;
				}else {
					dp1[i][j] = 0;
				}
			}
		}


		System.out.println((dp0[l-1][k] + dp1[l-1][k]));
	}
}
