import java.util.*;
import java.lang.Math;

public class Main {
	public static void main(String[] args) {

		boolean prime_flag;
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0,j; i < N; i++) {
			 prime_flag = true;
			 j = sc.nextInt();
			 if(j % 2 == 0 && j != 2){
				prime_flag = false;
			 }

			 for (int k = 3; k <= Math.sqrt(j) && prime_flag; k += 2){
				 if(j % k == 0){
					prime_flag = false;
					break;
				 }
			 }
			 if(prime_flag){
				 cnt++;
			 }
		}
		System.out.println(cnt);
	}
}