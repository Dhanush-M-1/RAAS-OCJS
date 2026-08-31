import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces820D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] perm = new int[n];
		for (int i = 0; i < n; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] secondDiff = new long[n];
		for (int i = 0; i < n; i++) {
			if (perm[i] == 1) {
				secondDiff[n-i-1] += (long) n;
				secondDiff[(n-i)%n] -= (long) n;
			}
			else if (perm[i] == n) {
				secondDiff[n-i-1] -= (long) n;
				secondDiff[(n-i)%n] += (long) n;
			}
			else {
				int r = perm[i];
				secondDiff[n-i-1] += (long) (n-2*r+2);
				secondDiff[(n-i)%n] += (long) (2*r-n);
				secondDiff[(n+r-i-1)%n] -= (long) 2;
			}
		}
		
		long[] actval = new long[n];
		for (int i = 0; i < n; i++) {
			actval[0] += (long) Math.abs(i+1-perm[i]);
			actval[1] += (long) Math.abs(i+1-perm[(n+i-1)%n]);
		}
		for (int i = 2; i < n; i++) {
			actval[i] = (long) (2*actval[i-1]-actval[i-2]-secondDiff[i-1]);
		}
		
		int minI = 0;
		long minJ = actval[0];
		for (int i = 1; i < n; i++) {
			if (actval[i] < minJ) {
				minI = i;
				minJ = actval[i];
			}
		}
		
		System.out.println(minJ + " " + minI);

	}

}
