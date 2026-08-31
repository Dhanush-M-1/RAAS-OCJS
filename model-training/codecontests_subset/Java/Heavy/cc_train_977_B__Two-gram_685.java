import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class TwoGram977B {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		String s = scanner.nextLine();
		
		HashMap<String, Integer> l = new HashMap<>();

		for (int i = 0; i < s.length() - 1; i++) {
			if (l.containsKey(s.substring(i, i + 2))) {
				l.put(s.substring(i, i + 2), (l.get(s.substring(i, i + 2)) + 1) );
			} else {
				l.put(s.substring(i, i + 2), 1);
			}
		}

		System.out.println(Collections.max(l.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey());

	}//main

}