import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numStores = Integer.parseInt(scanner.nextLine());
		int[] storeWorkdays = new int[numStores];
		int[][] profitTable = new int[numStores][11];

		for (int storeIndex = 0; storeIndex < numStores; storeIndex++) {
			for (String isWorkday :scanner.nextLine().split(" ")) {
				storeWorkdays[storeIndex] <<= 1;
				if (isWorkday.equals("1")) storeWorkdays[storeIndex]++;
			}
		}

		for (int storeIndex = 0; storeIndex < numStores; storeIndex++) {
			String[] strProfits = scanner.nextLine().split(" ");
			for (int profitIndex = 0; profitIndex < 11; profitIndex++) {
				profitTable[storeIndex][profitIndex] = Integer.parseInt(strProfits[profitIndex]);
			}
		}

		int maxProfitSum = Integer.MIN_VALUE;
		for (int openPlan = 1; openPlan < 1024; openPlan++) {
			int profitSum = 0;
			for (int storeIndex = 0; storeIndex < numStores; storeIndex++) {
				profitSum += profitTable[storeIndex][Integer.bitCount(storeWorkdays[storeIndex] & openPlan)];
			}
			if (maxProfitSum < profitSum) maxProfitSum = profitSum;
		}
		System.out.println(maxProfitSum);
	}
}
