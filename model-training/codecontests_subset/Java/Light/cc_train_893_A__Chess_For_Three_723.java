import java.util.ArrayList;
import java.util.Scanner;

public class ggg {
	public static void main(String[] args) {
		Scanner scanny = new Scanner(System.in);
		int x = scanny.nextInt();
		int spec = 3;
		int won = 10000;
		int lost = 0;
		String ans = "YES";
		for (int i = 0; i < x; i++) {
			won = scanny.nextInt();
			if (won == spec) {
				ans = "NO";
				break;
			}
			int nums = 0;
			nums += spec + won;
			if (nums == 3) lost = 3;
			else if (nums == 4) lost = 2;
			else lost = 1;
			if (lost == won) {
				ans = "NO";
				break;
			}
			int temp = lost;
			lost = spec;
			spec = temp;
		}
		System.out.println(ans);
	}
}