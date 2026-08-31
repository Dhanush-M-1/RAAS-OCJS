import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class b307 {

	public static void main(String[] args) {
		String strA, strB, strC;
		char[] a, b, c;
		int[] freqA = new int[26];
		int[] freqB = new int[26];
		int[] freqC = new int[26];
		int numB = 0, numC = 0, max = 0;
		Scanner in = new Scanner(System.in);
		strA = in.nextLine();
		strB = in.nextLine();
		strC = in.nextLine();
		in.close();
		a = strA.toCharArray();
		b = strB.toCharArray();
		c = strC.toCharArray();
		for (char aa : a)
			freqA[aa - 'a']++;
		for (char bb : b)
			freqB[bb - 'a']++;
		for (char cc : c)
			freqC[cc - 'a']++;
		int maxPossB = a.length / b.length;
		for (int i = 0; i < maxPossB; i++) {
			boolean broke = false;
			for (int j = 0; j < freqB.length; j++)
				if (freqA[j] - i * freqB[j] < 0) {
					broke = true;
					break;
				}
			if (broke)
				break;
			int minC = count(freqA, freqB, freqC, i);
			if (max < i + minC) {
				max = i + minC;
				numB = i;
				numC = minC;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		for (int i = 0; i < numB; i++)
			out.print(strB);
		for (int i = 0; i < numC; i++)
			out.print(strC);
		for (int i = 0; i < freqA.length; i++) {
			freqA[i] -= (numB * freqB[i] + numC * freqC[i]);
			for (int j = 0; j < freqA[i]; j++)
				out.print((char) (i + 'a'));
		}
		out.flush();
	}

	private static int count(int[] freqA, int[] freqB, int[] freqC, int idx) {
		int minC = Integer.MAX_VALUE;
		for (int i = 0; i < freqC.length; i++) {
			if (freqC[i] == 0)
				continue;
			minC = Math.min(minC, (freqA[i] - idx * freqB[i]) / freqC[i]);
		}
		if (minC <= 0 || minC == Integer.MAX_VALUE)
			return 0;
		return minC;
	}
}
