import java.util.Scanner;

public class Solution {

	int c;
	
	public Solution(Scanner in){
		this.c = in.nextInt();
	}
	
	public String solve(){
		return Integer.toString(ANSWERS[this.c]);
	}

	static int MAX_C = 10000000;
	static int[] ANSWERS;
	static void precompute(){
		int[] sums = new int[MAX_C + 1];
		for(int i=1; i<=MAX_C; i++){
			for(int j=i; j<=MAX_C; j += i){
				sums[j] += i;
			}
		}

		int[] minNs = new int[MAX_C + 1];
		for(int i=0; i<MAX_C + 1; i++){
			minNs[i] = -1;
		}

		for(int i=1; i<=MAX_C; i++){
			int c = sums[i];
			if(c <= MAX_C && minNs[c] == -1){
				minNs[c] = i;
			}
		}
		ANSWERS = minNs;
	}

	public static void main(String[] args){
		precompute();

		try(
			Scanner in = new Scanner(System.in);
			){
			int T = in.nextInt();
			for(int i=1; i<=T; i++){
				Solution solution = new Solution(in);
				System.out.println(solution.solve());
			}
		}
		System.exit(0);
	}

}