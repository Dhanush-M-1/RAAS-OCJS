
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int basePrice = sc.nextInt();
		int topPrice = sc.nextInt();
		int baseCal = sc.nextInt();
		int[] topCal = new int[n];
		for(int i=0;i<n;i++){
			topCal[i]=sc.nextInt();
		}
		Arrays.sort(topCal);
		for(int i=n;i>0;i--){
			if((baseCal+topCal[i-1])/(basePrice+topPrice)>=(baseCal/basePrice)){
				baseCal += topCal[i-1];
				basePrice += topPrice;
			}
		}
		System.out.println((int)baseCal/basePrice);

	}

}