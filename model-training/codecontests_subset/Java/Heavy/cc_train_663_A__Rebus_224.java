import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Washoum
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        inputClass in = new inputClass(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BRebus solver = new BRebus();
        solver.solve(1, in, out);
        out.close();
    }

    static class BRebus {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            String[] s = sc.nextLine().split(" ");
            int size = s.length;
            int n = Integer.parseInt(s[size - 1]);
            int nbplus = 1;
            int nbmoin = 0;
            for (int i = 1; i < size; i++) {
                if (s[i].equals("+")) {
                    nbplus++;
                } else if (s[i].equals("-")) {
                    nbmoin++;
                }
            }
            int max = nbplus * n - nbmoin;
            int min = (nbmoin * n * -1) + nbplus;
            if (n > max || n < min) {
                out.println("Impossible");
                return;
            }

            out.println("Possible");
            int sum = 0;
            int p;
            for (int i = 0; i < size - 2; i += 2) {
                p = 1;
                if (i > 0 && s[i - 1].equals("-"))
                    p = -1;
                if (p == 1) nbplus--;
                else nbmoin--;

                for (int j = 1; j <= n; j++) {
                    max = sum + p * j + nbplus * n - nbmoin;
                    min = sum + p * j + (nbmoin * n * -1) + nbplus;
                    if (n > max || n < min) {
                        continue;
                    } else {
                        out.print(j + " " + s[i + 1] + " ");
                        sum += j * p;
                        break;
                    }
                }
            }
            out.println(" " + n);

        }

    }

    static class inputClass {
        BufferedReader br;

        public inputClass(InputStream in) {

            br = new BufferedReader(new InputStreamReader(in));
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

