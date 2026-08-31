

import java.util.Scanner;

public class b {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			
			long N = scan.nextLong();
			int M = scan.nextInt();
			int[] gens = new int[M];
			for(int i=0;i<N;i++){
				int a = scan.nextInt()-1;
				gens[a]++;
			}
			
			long ans = N*(N-1)/2;
			for(int i=0;i<M;i++){
				if(gens[i]>=2){
					ans-=(long)gens[i]*((long)gens[i]-1)/2L;
				}
			}
			System.out.println(ans);
		}
	}
}	
