import static java.lang.System.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int card[][] = new int[14][5];
		for(int a = 1; a <= count; a++) {
			String mark = sc.next();
			int num = sc.nextInt();
			switch(mark) {
			case "S":
				card[num][1] = 1;
				break;
			case "H":
				card[num][2] = 1;
				break;
			case "C":
				card[num][3] = 1;
				break;
			case "D":
				card[num][4] = 1;
				break;
			}
		}
		for(int a = 1; a <= 4; a++) {
			for(int b = 1; b <= 13; b++) {
				if(card[b][a] != 1) {
					switch(a) {
					case 1:
						out.println("S " + b);
						break;
					case 2:
						out.println("H " + b);
						break;
					case 3:
						out.println("C " + b);
						break;
					case 4:
						out.println("D " + b);
						break;
					}
				}
			}
		}
	}
}
