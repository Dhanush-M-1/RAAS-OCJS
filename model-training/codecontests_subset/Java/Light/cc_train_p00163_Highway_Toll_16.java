import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int s, g;
		int sh, sm;
		int gh, gm;
		int sTime, gTime;
		int money;
		int map[][] = {{0, 300, 500, 600, 700, 1350, 1650},
				{6, 0, 350, 450, 600, 1150, 1500},
				{13, 7, 0, 250, 400, 1000, 1350},
				{18, 12, 5, 0, 250, 850, 1300},
				{23, 17, 10, 5, 0, 600, 1150},
				{43, 37, 30, 25, 20, 0, 500},
				{58, 52, 45, 40, 35, 15, 0}};

		while (true) {
			s = sc.nextInt();
			if (s == 0) {
				break;
			}
			sh = sc.nextInt();
			sm = sc.nextInt();
			g = sc.nextInt();
			gh = sc.nextInt();
			gm = sc.nextInt();
			int swap = s + g;
			s = Math.min(s, g);
			g = swap - s;
			sTime = sh * 60 + sm;
			gTime = gh * 60 + gm;
			money = map[s - 1][g - 1];
			if (map[g - 1][s - 1] <= 40 && ((17 * 60 + 30 <= sTime && sTime <= 19 * 60 + 30) || (17 * 60 + 30 <= gTime && gTime <= 19 * 60 + 30))) {
				money /= 2;
				if (money % 50 != 0) {
					money = money - (money % 50) + 50;
				}
			}
			System.out.println(money);
		}
	}
}