import java.util.Scanner;

public class Driver {

	public static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int c = scanner.nextInt();
		int minPrice = 100000;
		int maxPrice = 0;
		int count = 0;
		int[] prices = new int[n];
		for(int i=0; i<n; i++) {
			prices[i] = scanner.nextInt();
		}
		
		for(int i=0; i<n-1; i++) {
			if(prices[i]>prices[i+1]) {
				count+=(prices[i]-prices[i+1]-c);
			}else {
				continue;
			}
			maxPrice = Math.max(count, maxPrice);
			count=0;
		}
		
		System.out.println(maxPrice);
		
		
		
		
	}
	
}














