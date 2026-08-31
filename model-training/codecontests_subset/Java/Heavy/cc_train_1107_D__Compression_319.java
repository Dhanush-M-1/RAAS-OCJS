import java.io.*;
import java.util.*;
import java.math.*;

public class D {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/d.in"))));
		/**/
		
		int n = sc.nextInt();
		sc.nextLine();
		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			int j = 0;
			for (char c : s.toCharArray()) {
				int num = c-'0';
				if (num>9)
					num = c-'A'+10;
				mat[i][j++] = (num&8)>>3;
				mat[i][j++] = (num&4)>>2;
				mat[i][j++] = (num&2)>>1;
				mat[i][j++] = (num&1);
			}
		}
		int ans = n;
		for (int i = 0; i < n; i++) {
			int num = mat[i][0];
			for (int j = 1; j < n; ++j) {
				if (mat[i][j] != num) {
					ans = gcd(ans, j);
					num = mat[i][j];
				}
			}
		}
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = mat[0][i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] != nums[j]) {
					ans = gcd(ans, i);
					nums[j] = mat[i][j];
				}
			}
		}
		System.out.println(ans);
	}
	
	public static int gcd(int a, int b) {
		if (a>b)
			return gcd(b,a);
		if (a==0)
			return b;
		return gcd(b%a, a);
	}
}