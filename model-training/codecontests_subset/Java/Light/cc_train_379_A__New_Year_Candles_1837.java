
import java.util.Scanner;

public class A_262 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		int sum = n;
		
		while( n >= m ){
			int s = n / m;
			int k = n % m;
			sum += s;
			n = s + k;
		}
		
		System.out.println(sum);
	}
}