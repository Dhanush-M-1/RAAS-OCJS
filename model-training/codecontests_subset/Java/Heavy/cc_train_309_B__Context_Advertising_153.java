import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B {
	static boolean bit_set(int set, int bit) {
		return ((set>>bit)&1)==1;
	}
	
	static int NBITS = 20;
	static int n;
	static int R;
	static int[][] NW;
	static int score(int i) {
		int score = 0;
		for(int bit=NBITS-1; bit>=0; bit--) {
			if(bit_set(R, bit)) {
				score += NW[bit][i];
				i = i+NW[bit][i];
				if(i==n) return score;
			}
		}
		return score;
	}
	
	static int i(String s) { return Integer.parseInt(s); }
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		n = i(arr[0]);
		R = i(arr[1]);
		int C = i(arr[2])+1; //extra space at the end
		
		String[] W = in.readLine().split(" ");
		int[] A = new int[n];
		for(int i=0; i<n; i++)
			A[i] = W[i].length()+1;
		
		NW = new int[NBITS][n]; //NW[i][j] is how many words fit on 2^i rows starting with word j
		
		int hi = 0;
		int size = 0;
		for(int i=0; i<n; i++) {
			if(i > 0)
				size = size-A[i-1];
			while(hi<n && size+A[hi] <= C) {
				size = size+A[hi];
				hi++;
			}
			NW[0][i] = hi-i;
		}
		for(int l=0; l<NBITS-1; l++) //filling in l+1 
			for(int i=0; i<n; i++) {
				int nxt = i+NW[l][i];
				if(nxt >= n) NW[l+1][i] = NW[l][i];
				else NW[l+1][i] = NW[l][i]+NW[l][nxt];
			}
		
		int best = 0;
		for(int i=0; i<n; i++)
			best = Math.max(best, score(i));
		
		for(int i=0; i<n; i++) {
			if(score(i)==best) {
				StringBuilder out = new StringBuilder();
				for(int row=0; row<R; row++) {
					if(i==n) {
						System.out.print(out);
						return;
					}
					int row_start = i;
					for(int j=0; j<NW[0][row_start]; j++) {
						out.append(W[i]);
						out.append(j==NW[0][row_start]-1?'\n':' ');
						i++;
					}
				}
				System.out.print(out);
				return;
			}
		}
	}
}
