import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = "";
		int v;
		int cards[][] = new int[4][13];
		for (int i = 0; i < n; i++) {
			s = sc.next();
			v = sc.nextInt();
			if (s.equals("S"))
				cards[0][v - 1] = 1;
			else if (s.equals("H"))
				cards[1][v - 1] = 1;
			else if (s.equals("C"))
				cards[2][v - 1] = 1;
			else if (s.equals("D"))
				cards[3][v - 1] = 1;
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (i == 0 && cards[i][j] != 1)
					System.out.println("S " + (j + 1));
				if (i == 1 && cards[i][j] != 1)
					System.out.println("H " + (j + 1));
				if (i == 2 && cards[i][j] != 1)
					System.out.println("C " + (j + 1));
				if (i == 3 && cards[i][j] != 1)
					System.out.println("D " + (j + 1));
			}
		}
	}
}
