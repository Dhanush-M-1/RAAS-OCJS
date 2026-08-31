import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Andrey Menkov (nothingelsematters7@gmail.com)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {

    private int[] countChars(String s) {
        int[] count = new int['z' - 'a' + 1];
        Arrays.fill(count, 0);

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        return count;
    }

    public int howMany(int[] str, int[] substr) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str.length; i++) {
            if (substr[i] != 0) result = Math.min(result, str[i] / substr[i]);
        }

        return result;
    }

    public int howMany(int[] str, int[] b, int numB, int[] c) {
        if (numB == 0) return howMany(str, c);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str.length; i++) {
            if (c[i] != 0) {
                result = Math.min(result, (str[i] - b[i] * numB) / c[i]);
            }

            if (result == 0) return 0;
        }

        return result;
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String a = in.nextLine();
        String b = in.nextLine();
        String c = in.nextLine();

        int[] countA = countChars(a);
        int[] countB = countChars(b);
        int[] countC = countChars(c);

        int maxB = howMany(countA, countB);

        int res = 0;
        int resB = 0, resC = 0;

        for (int numB = 0; numB <= maxB; numB++) {
            int curRes = howMany(countA, countB, numB, countC);
            if (curRes + numB > res) {
                res = curRes + numB;
                resB = numB;
                resC = curRes;
            }
        }

        for (int i = 0; i < resB; i++) {
            out.print(b);
        }

        for (int i = 0; i < resC; i++) {
            out.print(c);
        }

        for (int i = 0; i < countB.length; i++) {
            countA[i] -= resB * countB[i];
        }

        for (int i = 0; i < countC.length; i++) {
            countA[i] -= resC * countC[i];
        }

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            int index = ch - 'a';
            for (int i = 0; i < countA[index]; i++) {
                out.print(ch);
            }
        }

        out.println();

    }
}

