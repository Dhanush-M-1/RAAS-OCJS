import java.util.Scanner;


public class CowsPokerGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		
		int r = 0;
		boolean bIN = false;
		
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'A' && !bIN)
				r++;
			else if (s.charAt(i) == 'I')
				if (!bIN) {
					r = 1;
					bIN = true;
				} else {
					r = 0;
					break;
				}
		}
		
		System.out.println(r);
		sc.close();
	}

}
