import java.io.InputStream;
import java.io.InputStreamReader;
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

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        double left = -10000;
        double right = 10000;
        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            double dec = getMax(a, mid);
            double asc = getMinusMax(a, mid);
            if (dec < asc) {
                right = mid;
            } else if (dec > asc) {
                left = mid;
            } else {
                break;
            }
        }

        double res = getMax(a, (left + right) / 2);
        out.println(String.format("%.14f", res));
    }

    private double getMax(int[] a, double x) {
        double res = a[0] - x;
        double sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i] - x;
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }

        return res;
    }

    private double getMinusMax(int[] a, double x) {
        double res = -a[0] + x;
        double sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += -a[i] + x;
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }

        return res;
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

