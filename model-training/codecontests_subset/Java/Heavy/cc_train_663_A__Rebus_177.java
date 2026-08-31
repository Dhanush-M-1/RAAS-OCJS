import java.util.Scanner;

public class Rebus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input[] = sc.nextLine().split(" = ");
		int n = Integer.parseInt(input[1]);
		if (input[0].length() - input[0].replace("?", "").length() > 100 && n > 1000000)
			System.exit(0);
		int plus = input[0].length() - input[0].replace("+", "").length() + 1;
		int minus = input[0].length() - input[0].replace("-", "").length();
		if (plus > minus) {
			if (minus == 0 && plus > n)
				printResultAndQuit();
			input[0] = input[0].replaceFirst("\\?", String.valueOf(n));
			int deficit = plus - 1;
			while (deficit > 0) {
				input[0] = input[0].replaceFirst("\\- \\?", "- " + String.valueOf(deficit > n ? n : deficit));
				deficit -= deficit > n ? n : deficit;
				minus--;
			}
			deficit = minus + 1;
			while (deficit > 0) {
				input[0] = input[0].replaceFirst("\\+ \\?", "+ " + String.valueOf(deficit > n ? n : deficit));
				deficit -= deficit > n ? n : deficit;
			}
			input[0] = input[0].replace("?", "1");
			int evaluation = evaluate(input[0], n);
			if (evaluation > n && (evaluation - n) < n)
				input[0] = input[0].replaceFirst(String.valueOf(n),
						String.valueOf((Integer.parseInt(input[0].split(" ")[0])) - (evaluation - n)));
		} else if (minus > plus) {
			if (plus == 1)
				printResultAndQuit();
			else {
				int deficit = minus;
				input[0] = input[0].replaceFirst("\\?", String.valueOf(n));
				while (deficit > 0) {
					input[0] = input[0].replaceFirst("\\+ \\?", "+ " + String.valueOf(deficit > n ? n : deficit));
					deficit -= deficit > n ? n : deficit;
					plus--;
				}
				deficit = plus;
				while (deficit > 0) {
					input[0] = input[0].replaceFirst("\\- \\?", "- " + String.valueOf(deficit > n ? n : deficit));
					deficit -= deficit > n ? n : deficit;
				}
				input[0] = input[0].replace("?", "1");
			}
		} else {
			input[0] = input[0].replaceFirst("\\?", String.valueOf(n));
			input[0] = input[0].replaceFirst("\\+ \\?", "+ 2");
			input[0] = input[0].replace("?", "1");
		}
		if (evaluate(input[0], n) == n) {
			System.out.println("Possible");
			System.out.println(input[0] + " = " + n);
		} else
			printResultAndQuit();
	}

	private static int evaluate(String temp, int n) {
		temp = temp.replace("+ ", "+").replace("- ", "-");
		String tempArr[] = temp.split(" ");
		int ans = 0;
		for (int i = 0; i < tempArr.length; i++) {
			if (Integer.parseInt(tempArr[i]) > n)
				printResultAndQuit();
			ans += Integer.parseInt(tempArr[i]);
		}
		return ans;
	}

	private static void printResultAndQuit() {
		System.out.println("Impossible");
		System.exit(0);
	}
}