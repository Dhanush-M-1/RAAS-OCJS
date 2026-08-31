
import java.util.Scanner;

public class Zadacha_A {

	
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in); 
		int num = sc.nextInt();
		int v = sc.nextInt();
		int dlina = sc.nextInt();
		int all = num * dlina;
		int k = 0;
		int sum = 0;
		while (sum < all) {
			sum =  v * k;
			if ( sum + (v * dlina) >= all) {
				break;
			}
			k++;
		}
		System.out.println(k);
}
	}