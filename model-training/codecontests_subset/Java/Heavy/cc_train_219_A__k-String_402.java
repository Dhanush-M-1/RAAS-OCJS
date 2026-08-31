import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zhanhb
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] s = cin.next().toCharArray();
		for (char c : s) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		boolean noAns = false;
		for (Map.Entry<Character, Integer> en : map.entrySet()) {
			Character key = en.getKey();
			Integer val = en.getValue();
			if ((val % n) != 0) {
				noAns = true;
				break;
			}
		}
		if (noAns) {
			System.out.println("-1");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<Character, Integer> en : map.entrySet()) {
				Character key = en.getKey();
				Integer val = en.getValue();
				appendNchar(sb, val / n, key);
			}
			String string = sb.toString();
			for (int i = 0; i < n; ++i) {
				System.out.print(string);
			}
			System.out.println();
		}

	}

	private static void appendNchar(StringBuilder sb, int n, char c) {
		for (int i = 0; i < n; ++i) {
			sb.append(c);
		}
	}
}

	 	 			  		 				  		   	 	