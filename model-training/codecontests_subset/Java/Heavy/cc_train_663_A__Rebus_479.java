import java.util.Scanner;

public class Rebus {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;

		int x = 0;
		char[] allChars = new char[65535];
		while (input.hasNext()) {
			String chars = input.next();
			allChars[x] = (chars.toCharArray())[0];

			if (allChars[x] == '=') {
				n = input.nextInt();
				break;
			}

			x++;
		}

		int positive = 0;
		int negative = 0;

		for (int i = 0; i < allChars.length; i++) {
			if (allChars[i] == 0)
				break;

			if (allChars[i] == '?') {
				if (i == 0)
					positive++;
				else {
					if (allChars[i - 1] == '-')
						negative++;
					else
						positive++;
				}
			}
		}

		int[] positives = new int[positive];
		int[] negatives = new int[negative];

		if (positive == 1 && negative == 0) {
			positives[0] = n;
			System.out.println("Possible");
		} else if ((n * positive - negative) < n || (positive - n * negative) > n) {
			System.out.println("Impossible");
			return;
		} else {
			System.out.println("Possible");

			int negativeSum = negative;
			while (true) {
				if ((n + negative) / positive <= n) {
					{
						if (negative != 0) {
							int neg = negativeSum / negative;
							int remainder = negativeSum % negative;
							for (int i = 0; i < negatives.length; i++) {
								negatives[i] = neg;
								if (remainder > 0) {
									negatives[i]++;
									remainder--;
								}
							}
						} else
							negativeSum = 0;
					}
					{
						int positiveSum = n + negativeSum;
						int pos = positiveSum / positive;
						if (pos == 0) {
							negativeSum++;
							continue;
						}
						int remainder = positiveSum % positive;
						for (int i = 0; i < positives.length; i++) {
							positives[i] = pos;
							if (remainder > 0) {
								positives[i]++;
								remainder--;
							}
						}
					}
					break;
				}
				negativeSum++;
			}

		}

		int in = 0;
		int ip = 0;
		for (int i = 0; i < allChars.length; i++) {
			if (allChars[i] == 0)
				break;

			if (allChars[i] == '?') {
				if (i == 0) {
					System.out.print(positives[in] + " ");
					ip++;
				} else {
					if (allChars[i - 1] == '-') {
						System.out.print("- " + negatives[in] + " ");
						in++;
					} else {
						System.out.print("+ " + positives[ip] + " ");
						ip++;
					}
				}
			}
		}
		System.out.print("= " + n);
		System.out.println();
	}
}
