import java.util.*;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n;
		ArrayList<Integer> num = new ArrayList<Integer>();
		int ans = 0, isPrime;
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++){
			num.add(sc.nextInt());
		}
		
		for(int i : num){
			isPrime = 1;
			for(int j = 2; j <= (int)Math.sqrt(i); j++){
				if(i % j == 0){
					isPrime = 0;
					break;
				}
			}
			
			if(isPrime != 0){
				ans ++;
			}
		}
		
		System.out.println(ans);
	}
}