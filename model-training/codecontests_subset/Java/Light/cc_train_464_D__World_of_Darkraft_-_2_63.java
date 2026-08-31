import java.util.Scanner;

public class d {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int maxLevel = Math.min(n, 600);
		double prob = 1d / k;
		double[] base = new double[maxLevel + 1];
		double[] memo = new double[maxLevel + 1];

		int sum = 0;
		for (int i = 1; i <= maxLevel; i++) {
			sum += i;
			memo[i] = base[i] = ((sum + i) / (i + 1d)) * prob;
		}

		for (int monsters = 1; monsters < n; monsters++) {
			for (int level = 1; level <= maxLevel; level++) {
				double value = base[level];// value of roll here
				double levelUpChance = prob / (level + 1);

				value += memo[level] * (1 - levelUpChance);// diff
															// level
				value += memo[Math.min(level + 1, maxLevel)] * levelUpChance;// roll
																				// same
																				// type

				memo[level] = base[level] + (memo[level] * (1 - levelUpChance))
						+ (memo[Math.min(level + 1, maxLevel)] * levelUpChance);
			}
		}

		System.out.println(k * memo[1]);
		in.close();
	}
}