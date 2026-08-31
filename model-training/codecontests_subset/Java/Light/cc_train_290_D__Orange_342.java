import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine().trim();
		word = word.toLowerCase();
		int n = scanner.nextInt();
		StringBuilder result = new StringBuilder(word.length());
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if ((int)c < n + 97) {
				result.append(Character.toUpperCase(c)) ;
			} else {
				result.append(Character.toLowerCase(c));
			}
		}
		System.out.println(result.toString());
		scanner.close();
	}
}
