import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cnt = 0, cnt2 = 0;
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			if (a * a + b * b == c * c) cnt++;
			if (a == b) cnt2++;
		}
		System.out.println(cnt + "\n" + cnt2);

	}

}