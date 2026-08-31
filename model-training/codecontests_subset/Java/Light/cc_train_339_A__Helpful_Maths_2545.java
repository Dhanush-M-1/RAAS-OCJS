import java.util.Scanner;
import java.util.Arrays;

public class HelpfulMaths {
	static int[] a = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next().trim();
		StringBuilder t = new StringBuilder();
		String[] c = s.split("\\+");
		Arrays.sort(c);
		for (String o : c) t.append(o).append("+");
		System.out.print(t.substring(0,t.length()-1));
		sc.close();
	}
}