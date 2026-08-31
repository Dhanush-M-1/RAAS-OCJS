import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		int sHold = 0;
		int deleteChar = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'S')
				sHold++;
			if (str.charAt(i) == 'T') {
				if (sHold > 0) {
					deleteChar += 2;
					sHold--;
				}
			}
		}
		System.out.println(str.length() - deleteChar);
	}
}