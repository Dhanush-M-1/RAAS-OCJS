
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		
		long mod = 998244353;
		
		int n = sc.nextInt();
		
		long[] arr = new long[n];
		
		int[] count = new int[11];
		
		for(int i = 0; i < n; i++){
			
			arr[i] = sc.nextLong();
		
			count[(int)Math.log10(arr[i]) + 1]++;
		
		}
		
		long ans = 0;
		
		for(int i = 0; i < n; i++){
			
			for(int j = 1; j <= 10; j++){
				
				long local = 0;
				long temp = arr[i];
				long mul = 1;
				int digits = 0;
				
				while(temp != 0 && digits < j){
					
					local = (local + (((temp % 10) * mul) % mod)) % mod;
					
					mul = (mul * 100) % mod;
					
					temp /= 10;
					
					digits++;
					
				}
				
				local = (local + ((mul * temp) % mod)) % mod;
				
				ans = (ans + ((local * count[j])) % mod) % mod;
				
				
				local = 0;
				temp = arr[i];
				mul = 10;
				digits = 1;
				
				while(temp != 0 && digits < j){
					
					local = (local + (((temp % 10) * mul) % mod)) % mod;
					
					mul = (mul * 100) % mod;
					
					temp /= 10;
					
					digits++;
					
				}
				
				local = (local + ((mul * temp) % mod)) % mod;
				
				ans = (ans + ((local * count[j]) % mod)) % mod;
				
								
			}
			
		}
			
		System.out.println(ans % mod);
		
	}
}
