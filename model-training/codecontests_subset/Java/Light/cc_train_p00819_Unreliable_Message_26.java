import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);

		final int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			char[] order = new StringBuilder(sc.next()).reverse().toString()
					.toCharArray();
			StringBuilder input = new StringBuilder(sc.next());

			for (char o : order) {
				//System.out.println(input);

				if (o == 'J') {
					if (input.length() != 1) {
						input.insert(0, input.charAt(input.length() - 1))
								.deleteCharAt(input.length() - 1);
					}
				} else if (o == 'C') {
					if (input.length() != 1) {
						input.append(input.charAt(0)).deleteCharAt(0);
					}
				} else if (o == 'E') {
					if (input.length() != 1) {
						CharSequence sb1 = input.subSequence(input.length()
								- input.length() / 2, input.length());
						CharSequence sb2 = input.subSequence(0,
								input.length() / 2);

						StringBuilder s = new StringBuilder();
						if (input.length() % 2 == 1) {
							s.append(input.charAt(input.length() / 2));
						}
						s.insert(0, sb1);
						s.append(sb2);

						input = s;
					}
				} else if (o == 'A') {
					input.reverse();
				} else if (o == 'P') {
					StringBuilder tmp = new StringBuilder();
					char[] array = input.toString().toCharArray();
					for (char c : array) {

						if ('0' <= c && c <= '9') {
							tmp.append((char) ((c - 1) < '0' ? '9' : (c - 1)));
						} else {
							tmp.append(c);
						}
						// System.out.println(tmp);
					}
					input = tmp;
				} else if (o == 'M') {
					StringBuilder tmp = new StringBuilder();
					char[] array = input.toString().toCharArray();
					for (char c : array) {
						if ('0' <= c && c <= '9') {
							tmp.append((char) ((c + 1) > '9' ? '0' : (c + 1)));
						} else {
							tmp.append(c);
						}
					}
					input = tmp;
				}
			}

			System.out.println(input);
		}
	}

}