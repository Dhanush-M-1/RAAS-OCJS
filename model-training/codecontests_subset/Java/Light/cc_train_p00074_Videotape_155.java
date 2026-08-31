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
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            String[] values = line.split(" ");
            int h = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            int s = Integer.parseInt(values[2]);
            if (h == -1 && m == -1 && s == -1) {
                break;
            }
            int time = (h * 60 + m) * 60 + s;
            int rest = 120 * 60 - time;
            out.println(format(rest));
            out.println(format(rest * 3));
        }
    }

    private static String format(int time) {
        int h = time / 3600;
        int m = (time / 60) % 60;
        int s = time % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}