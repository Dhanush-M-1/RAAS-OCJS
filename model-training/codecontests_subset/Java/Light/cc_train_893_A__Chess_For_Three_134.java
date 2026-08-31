import java.util.*;

public class A833 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int spector = 3;
		int win;
		int lose;
		boolean result = true;
		for (int i = 0; i < size; i++) {
			win = sc.nextInt();
			if (win == spector) {
				result = false;
				break;
			}
			lose = spector;
			spector = 6 - win - spector;
		}
		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}