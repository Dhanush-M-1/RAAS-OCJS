import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();

		int count = 0;
		for(int i = 0; i < N; i++){
			final int number = sc.nextInt();
			
			final int limit = (int)(Math.sqrt(number));
			
			boolean not_prime = false;
			for(int j = 2; j <= limit; j++){
				if(number % j == 0){
					not_prime = true;
					break;
				}
			}
			
			count += not_prime ? 0 : 1;
		}
		
		System.out.println(count);
		
	}
}