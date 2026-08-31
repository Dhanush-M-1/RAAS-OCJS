import java.util.Scanner;

public class FoxDivCheese {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		
		int target = gcd(n, m);
		n /= target;
		m /= target;
		
		int count = 0;
		
		while(n % 2 == 0) {
			n /= 2;
			count++;
		}
		
		while(n % 3 == 0) {
			n /= 3;
			count++;
		}
		
		while(n % 5 == 0) {
			n /= 5;
			count++;
		}
		
		while(m % 2 == 0) {
			m /= 2;
			count++;
		}
		
		while(m % 3 == 0) {
			m /= 3;
			count++;
		}
		
		while(m % 5 == 0) {
			m /= 5;
			count++;
		}
		
		if(m > 1 || n > 1)
			System.out.println(-1);
		else
			System.out.println(count);
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
