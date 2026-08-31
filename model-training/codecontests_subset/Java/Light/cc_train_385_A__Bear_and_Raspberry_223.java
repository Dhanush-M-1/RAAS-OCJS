import java.util.*;

public class Z385A {

	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(System.in);
		
		int n = inputScanner.nextInt();
		int c = inputScanner.nextInt();
		
		int lastPrice = 0;
		boolean firstInput = true;
		int optIndex = -1;
		int maxProfit = 0;
		
		for(int i=0;i<n;++i) {
			int newPrice = inputScanner.nextInt();
			
			if(!firstInput) {
				
				if((lastPrice - c - newPrice) > maxProfit) {
					maxProfit = lastPrice - c - newPrice;
					optIndex = i+1;
				}
			}
			else {
				firstInput = false;
			}
			
			lastPrice = newPrice;
		}
		
		System.out.println(maxProfit);
		
	}
}
