import java.util.Scanner;

public class Main {
	static long solve(int N[] , int idx , int K){
		if(K == 0){
			return 1;
		}
		long len = N.length - idx - 1;
		if(len < 0){
			return 0;
		}
		// N[0] = 
		if(K == 1){
			long pat = len * 9;
			pat += N[idx];
			return pat;
		}else if(K == 2){
			long pat = len * (len - 1) / 2 * 81;
			pat += (N[idx] - 1) * len * 9;
			for(int i = idx + 1 ; i < N.length ; ++i){
				if(N[i] != 0){
					pat += solve(N , i , K - 1);
					break;
				}
			}
			return pat;
		}else{ // K == 3
			long pat = len * (len - 1) * (len - 2) / 6 * 729;
			pat += (N[idx] - 1) * len * (len - 1) / 2 * 81;
			for(int i = idx + 1 ; i < N.length ; ++i){
				if(N[i] != 0){
					pat += solve(N , i , K - 1);
					break;
				}
			}
			return pat;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int K = sc.nextInt();
		int Narr[] = new int[N.length()];
		for(int i = 0 ; i < Narr.length ; ++i){
			Narr[i] = N.charAt(i) - '0';
		}
		System.out.println(solve(Narr, 0 , K));
	}
}
