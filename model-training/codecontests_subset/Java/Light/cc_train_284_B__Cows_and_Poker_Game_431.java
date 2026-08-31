import java.util.Scanner;

public class B_284_Cows_and_Poker_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int ALLIN = 0;
		int IN = 0;
		int FOLDED = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'A')
				ALLIN++;
			if (s.charAt(i) == 'I')
				IN++;
			if (s.charAt(i) == 'F')
				FOLDED++;
		}
		if (IN == 1)
			System.out.println(1);
		else if (ALLIN + FOLDED == n)
			System.out.println(ALLIN);
		else
			System.out.println(0);
	}
}
