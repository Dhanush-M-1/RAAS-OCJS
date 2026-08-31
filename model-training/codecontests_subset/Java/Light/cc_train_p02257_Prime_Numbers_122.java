import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		boolean flg;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			int x = scan.nextInt();
			flg = isprime(x);
			if ( flg == true) count++;
		}
		
		scan.close();
		System.out.println(count);
	}
	
	public static boolean isprime(int x) {
		
		if (x == 2) return true;
		
		if (x < 2 || x % 2 == 0) return false;
		
		int i = 3;
		
		while ( i <= Math.sqrt((double)x)) {
			if (x % i == 0) return false;
			
			i += 2;
		}
		
		return true;
	}
}

