import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Tifuera
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            r[i] = in.nextInt();
        }

        String xAns = getAnsForPoints(x);
        String yAns = getAnsForPoints(y);

        out.println(xAns);
        out.println(yAns);
    }

    private String getAnsForPoints(int[] points) {
        List<String> ansByPoint = new ArrayList<>(points.length);
        for (int i = 0; i < points.length; i++) {
            ansByPoint.add(getAnsForPoint(points[i], i));
        }

        String ans = ansByPoint.get(0);

        for (int i = 1; i < ansByPoint.size(); i++) {
            ans = getSum(ans, ansByPoint.get(i));
        }

        return ans;
    }

    private String getAnsForPoint(int point, int idx) {
        String argument = getDiff("t", String.valueOf(idx));

        String firstFunc = getDiff("1", getAbs(argument));
        String secondFunc = getAbs(argument);

        String diff = getDiff(firstFunc, secondFunc);
        String absDiff = getAbs(diff);

        String mainFunc = getSum(diff, absDiff);

        return getMult(String.valueOf(point / 2), mainFunc);
    }

    private String getMult(String first, String second) {
        return "(" + first + "*" + second + ")";
    }

    private String getSum(String first, String second) {
        return "(" + first + "+" + second + ")";
    }

    private String getDiff(String first, String second) {
        return "(" + first + "-" + second + ")";
    }

    private String getAbs(String str) {
        return "abs(" + str + ")";
    }

}

class InputReader {
    private BufferedReader reader;
    private String[] currentArray;
    private int curPointer;

    public InputReader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }


    public int nextInt() {
        if ((currentArray == null) || (curPointer >= currentArray.length)) {
            try {
                currentArray = reader.readLine().split(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            curPointer = 0;
        }
        return Integer.parseInt(currentArray[curPointer++]);
    }

}

