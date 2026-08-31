import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] queMarkStr = br.readLine().trim().split("\\s+");
		int plusCount = 1, minusCount = 0, maxValue = 0, minValue = 0, outputNum, totalPositive, totalNegative;

		for (int i = 1; i < queMarkStr.length; i = i + 2) {
			if ((queMarkStr[i]).equals("+")) {
				++plusCount;
			} else if ((queMarkStr[i]).equals("-")) {
				++minusCount;
			}
		}
		outputNum = Integer.parseInt(queMarkStr[queMarkStr.length - 1]);
		minValue = plusCount * 1 - minusCount * outputNum;
		maxValue = plusCount * outputNum - minusCount * 1;

		if ((outputNum <= maxValue) && (outputNum >= minValue)) {
			System.out.println("Possible");

			int[] positiveNum = new int[plusCount];
			int[] minusNum = new int[minusCount];
			totalPositive = plusCount;
			totalNegative = minusCount;
			for (int i = 0; i < plusCount; i++) {
				positiveNum[i] = 1;
			}
			for (int i = 0; i < minusCount; i++) {
				minusNum[i] = 1;
			}
			while (true) {
				if ((totalPositive - totalNegative) > outputNum) {
					for (int i = 0; i < minusCount; i++) {
						if (minusNum[i] < outputNum) {
							minusNum[i]++;
							totalNegative++;
							break;
						}
					}
				} else if ((totalPositive - totalNegative) < outputNum) {
					for (int i = 0; i < plusCount; i++) {
						if (positiveNum[i] < outputNum) {
							positiveNum[i]++;
							totalPositive++;
							break;
						}
					}
				} else {
					int plusPointer = 0, minusPointer = 0;
					System.out.print(positiveNum[0]);
					for (int i = 1; i < queMarkStr.length; i = i + 2) {
						if (queMarkStr[i].equals("+")) {
							System.out.print(" + ");
							plusPointer++;
							System.out.print(positiveNum[plusPointer]);
						} else if (queMarkStr[i].equals("-")) {
							System.out.print(" - ");
							System.out.print(minusNum[minusPointer]);
							minusPointer++;
						}
					}
					System.out.print(" = " + outputNum);
					break;
				}
			}
		} else {
			System.out.println("Impossible");
		}
	}
}