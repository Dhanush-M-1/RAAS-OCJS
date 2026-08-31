import java.util.Scanner;

public class PairProgramming {
	
	public static void Solve(int k, int n, int m, int[] nArr, int[] mArr) {
		
		int nPt = 0;
		int mPt = 0;
		int[] sequence = new int[n+m];
		int seqPt = 0;
		while (seqPt<(n+m)) {
			if (nPt >=0 && nPt<n && nArr[nPt] == 0) {
				k++;
				sequence[seqPt++] = nArr[nPt++];
			}
			else if (nPt >=0 && nPt<n && nArr[nPt] <= k) {
				sequence[seqPt++] = nArr[nPt++];
			}
			else {
				if (mPt >=0 && mPt<m && mArr[mPt] == 0) {
					k++;
					sequence[seqPt++] = mArr[mPt++];
				}
				else if (mPt >=0 && mPt<m && mArr[mPt] <= k) {
					sequence[seqPt++] = mArr[mPt++];
				}
				else {
					System.out.println("-1");
					return;
				}
			}
		}
		for (int val : sequence) {
			System.out.print(val + " ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int k = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt();
			int[] nArr = new int[n];
			int[] mArr = new int[m];
			for (int j=0; j<n; j++) {
				nArr[j] = in.nextInt();
			}
			for (int j=0; j<m; j++) {
				mArr[j] = in.nextInt();
			}
			Solve(k, n, m, nArr, mArr);
		}
		in.close();
		
	}

}
