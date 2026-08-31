import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		ArrayList<String> word = new ArrayList<>();

		String password = sc.next();

		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			String word_i = sc.next();
			word.add(word_i);
		}

		ArrayList<String> mix = new ArrayList<>();

		for (int i = 0; i < word.size(); i++) {
			for (int j = 0; j < word.size(); j++) {
				String word_i = word.get(i);
				String word_j = word.get(j);
				String mix_ij = word_i + word_j;
				mix.add(mix_ij);
			}
		}

		Boolean bool = false;
		for (String mox : mix) {
			if (mox.contains(password)) {
				bool = true;
			}
		}
		System.out.println(bool ? "YES" : "NO");

		sc.close();

	}

}