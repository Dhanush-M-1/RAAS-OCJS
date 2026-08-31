import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h, m, s;
		h = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextInt();
		while (h != -1 && m != -1 && s != -1) {
			int rest = 120 * 60 - (h * 3600 + m * 60 + s);
			System.out.printf("%02d:%02d:%02d\n", rest / 3600, (rest % 3600) / 60, rest % 60);
			rest *= 3;
			System.out.printf("%02d:%02d:%02d\n", rest / 3600, (rest % 3600) / 60, rest % 60);
			
			h = sc.nextInt();
			m = sc.nextInt();
			s = sc.nextInt();
		}
	}
}