import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class ez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int[] price = new int[n];
		for(int i = 0; i < n; i++){
			price[i]=in.nextInt();
		}
		int profit = 0;
		for(int i = 0; i < n-1; i++){
			profit = Math.max(price[i]-price[i+1]-c, profit);
		}
		System.out.println(profit);
	}
}
