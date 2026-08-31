import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long p = sc.nextLong();
		long ans = 1;
		
		if(n > 50){
			System.out.println(1);
		}else if(n == 1){
			System.out.println(p);
		}else if(n == 2){
			for(int i=2; i<=1000000; i++){
				long npi = 1;
				for(int j=0; j<n; j++){
					npi *= i;
				}
				if(npi == 0){
					break;
				}
				while(p % npi == 0 && npi > 0){
					ans *= i;
					p /= npi;
				}
			}
			
			System.out.println(ans);
		}else{
			for(int i=2; i<=10000; i++){
				long npi = 1;
				for(int j=0; j<n; j++){
					npi *= i;
				}
				if(npi == 0){
					break;
				}
				while(p % npi == 0 && npi > 0){
					ans *= i;
					p /= npi;
				}
			}
			
			System.out.println(ans);
		}
	}
	
	static long[][] factorization(long n){
		int order = 10;
		int scale = 0;
		while(order <= n){
			scale++;
			order *= 10;
		}
		
		long pre_result[][] = new long[scale+2][2];
		long n_cp = n;
		int point = 0;
		for(int i=2; i<=n_cp; i++){
			if(n_cp % i == 0){
				pre_result[point][0] = i;
				while(n_cp % i == 0){
					pre_result[point][1]++;
					n_cp /= i;
				}
				point++;
			}
			if(n_cp == 1){
				break;
			}
		}
		
		long result[][] = new long[point][2];
		for(int i=0; i<point; i++){
			result[i][0] = pre_result[i][0];
			result[i][1] = pre_result[i][1];
		}
		
		return result;
	}
}