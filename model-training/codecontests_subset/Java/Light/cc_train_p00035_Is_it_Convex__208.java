import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

class Main {

    public static void main(String[] args) throws IOException {
        doit(args, System.in, System.out);
    }

    static void doit(String[] args, InputStream in, PrintStream out)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] values = line.split(",");
            double[] xs = new double[4];
            double[] ys = new double[4];
            for (int i = 0; i < 4; i++) {
                xs[i] = Double.parseDouble(values[i * 2]);
                ys[i] = Double.parseDouble(values[i * 2 + 1]);
            }

            double[] dxs = new double[4];
            double[] dys = new double[4];
            for (int i = 0; i < 4; i++) {
                dxs[i] = xs[(i + 1) % 4] - xs[i];
                dys[i] = ys[(i + 1) % 4] - ys[i];
            }

            String result = "YES";
            double signum = calcSignum(dxs[3], dys[3], dxs[0], dys[0]);
            for (int i = 0; i < 3; i++) {
                double s = calcSignum(dxs[i], dys[i], dxs[i + 1], dys[i + 1]);
                if (s != signum) {
                    result = "NO";
                    break;
                }
            }
            out.println(result);
        }
    }

    private static double calcSignum(double x1, double y1, double x2, double y2) {
        return Math.signum(x1 * y2 - x2 * y1);
    }
}