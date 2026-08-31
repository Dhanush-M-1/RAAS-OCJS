import java.util.Scanner;

public class Rebus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String inputArr[] = input.split(" = ");
		int n = Integer.parseInt(inputArr[1]);
		if (inputArr[0].length() - inputArr[0].replace("?", "").length() > 100 && n > 1000000)
			System.exit(0);
		int plus = inputArr[0].length() - inputArr[0].replace("+", "").length() + 1;
		int minus = inputArr[0].length() - inputArr[0].replace("-", "").length();
		int diff = Math.abs(plus - minus);
		if (plus > minus) {
			if (minus == 0 && plus > n) {
				System.out.println("Impossible");
				System.exit(0);
			}
			inputArr[0] = inputArr[0].replaceFirst("\\?", String.valueOf(n));
			int deficit = plus - 1;
			int minusLeft = minus;
			while (deficit > 0) {
				inputArr[0] = inputArr[0].replaceFirst("\\- \\?", "- " + String.valueOf(deficit > n ? n : deficit));
				deficit -= deficit > n ? n : deficit;
				minusLeft--;
			}
			deficit = minusLeft+1;
			while (deficit > 0) {
				inputArr[0] = inputArr[0].replaceFirst("\\+ \\?", "+ " + String.valueOf(deficit > n ? n : deficit));
				deficit -= deficit > n ? n : deficit;
			}
			inputArr[0] = inputArr[0].replace("?", "1");
			int eval = evaluate(inputArr[0], n);
			if (eval > n && (eval - n) < n && eval != n)
				inputArr[0] = inputArr[0].replaceFirst(String.valueOf(n),
						String.valueOf((Integer.parseInt(inputArr[0].split(" ")[0])) - (eval - n)));
		} else if (minus > plus) {
			if (plus == 1) {
				System.out.println("Impossible");
				System.exit(0);
			} else {
				int deficit = minus;
				int plusLeft = plus;
				inputArr[0] = inputArr[0].replaceFirst("\\?", String.valueOf(n));
				while (deficit > 0) {
					inputArr[0] = inputArr[0].replaceFirst("\\+ \\?", "+ " + String.valueOf(deficit > n ? n : deficit));
					deficit -= deficit > n ? n : deficit;
					plusLeft--;
				}
				deficit = plusLeft;
				while (deficit > 0) {
					inputArr[0] = inputArr[0].replaceFirst("\\- \\?", "- " + String.valueOf(deficit > n ? n : deficit));
					deficit -= deficit > n ? n : deficit;
				}
				inputArr[0] = inputArr[0].replace("?", "1");
			}

		} else {
			inputArr[0] = inputArr[0].replaceFirst("\\?", String.valueOf(n));
			inputArr[0] = inputArr[0].replaceFirst("\\+ \\?", "+ 2");
			inputArr[0] = inputArr[0].replace("?", "1");
		}

		if (evaluate(inputArr[0], n) == n) {
			System.out.println("Possible");
			System.out.println(inputArr[0] + " = " + n);
		} else
			System.out.println("Impossible");
	}

	private static int evaluate(String temp, int n) {
		temp = temp.replace("+ ", "+").replace("- ", "-");
		String tempArr[] = temp.split(" ");
		int ans = 0;
		for (int i = 0; i < tempArr.length; i++) {
			if (Integer.parseInt(tempArr[i]) > n) {
				System.out.println("Impossible");
				System.exit(0);
			}
			ans += Integer.parseInt(tempArr[i]);
		}
		return ans;
	}
}
