import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class a339 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		char[] str = stdin.nextLine().toCharArray();
		ArrayList<Character> t = new ArrayList<>();
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '+') continue;
			t.add(str[i]);
		}
		
		Collections.sort(t);
		
		for (int i = 0; i < t.size() - 1; i ++) {
			System.out.print(t.get(i)+"+");
		}
		System.out.println(t.get(t.size()-1));
	}
}
