import java.util.Scanner;

public class Orange {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String l = s.nextLine();
		String result = "";
		int a = s.nextInt();
		a = a + 97;
		l = l.toLowerCase();
		for (int i = 0; i < l.length(); i++) {
			char x = l.charAt(i);
			if (x<a) {
				result = result + Character.toUpperCase(x);
			} else {
				result = result + Character.toLowerCase(x);
			}
		}
		System.out.println(result);
	}
}
