import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner str = new Scanner(System.in);
		String s = str.nextLine();
		int tcnt = 0, scnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (String.valueOf(s.charAt(i)).equals("S")) {
				scnt += 1;
			} else {
				if (scnt == 0) {
					tcnt += 1;
				} else {
					scnt -= 1;
				}
			}
		}
		System.out.println(tcnt + scnt);
		str.close();
	}
}
