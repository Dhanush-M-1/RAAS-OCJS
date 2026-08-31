//logic: https://codeforces.com/contest/1107/submission/49013826
//package jan19;

import java.util.Scanner;

public class D1107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int n1 = n;
		int[][] mat = new int[n][n];
		
			/*Making the matrix in binary form */

			for (int k = 0; k < n; k++) {
				String str = scn.next();
				for (int i = 0; i < n1 / 4; i++) {
					 int c = getbinaryfromHex(str.charAt(i));
					for (int j = 3; j >= 0; j--) {
						mat[k][4*i+j] = c % 2;
						c =  (c / 2);
					}

				}
			}
			boolean[] may=new boolean[n];
			/*Basically we are checking squares of x*x */
			for(int i=1; i<n; i++)
			{
				for(int j=0; j<n; j++ )
				{
					if(mat[i][j]!=mat[i-1][j] || mat[j][i]!=mat[j][i-1])
					{
						may[i]=true;
					}
				}
			}
			
			int ans=n;
			for(int i=1; i<n; i++)
			{
				if(may[i]==true)
				{
					ans=gcd(ans, i);
				}
			}
			System.out.println(ans);
			
		

	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	static byte getbinaryfromHex(char x) {
		if (x >= '0' && x <= '9') {
			return (byte) x;
		} else {
			return (byte) (x - 'A' + 10);
		}
	}

}
