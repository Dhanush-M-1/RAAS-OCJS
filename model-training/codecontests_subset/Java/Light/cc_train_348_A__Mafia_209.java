

import java.util.Scanner;

public class Mafia {

	private static Scanner scan;
	
	public static void main(String[] args) {
	
		solve();
	}
	
	private static void solve() {
		
		scan = new Scanner(System.in);
		
		while (scan.hasNext()) {
			int n = scan.nextInt();
			
			long total = 0, minRounds = 0;
			for (int j = 0; j < n; j++) {
				long tmp = scan.nextInt();
				total += tmp;
				if (tmp > minRounds) 
					minRounds = tmp;
			}
			
			long rounds = total/(n-1);
		    if(total % (n - 1) > 0){++rounds;}
		    if(rounds < minRounds){rounds = minRounds;}
			
			System.out.println(rounds);
		}
	}
}
