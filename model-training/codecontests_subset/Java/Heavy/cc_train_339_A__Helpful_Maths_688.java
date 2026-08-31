import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        AHelpfulMaths solver = new AHelpfulMaths();
        solver.solve(1, in, out);
        out.close();
    }

    static class AHelpfulMaths {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            StringBuffer sb = new StringBuffer();
            char[] str = in.scanString().toCharArray();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (char c : str) {
                if (c == '+') {
                    arrayList.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() != 0) {
                arrayList.add(Integer.parseInt(sb.toString()));
            }

            Collections.sort(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                if (i == arrayList.size() - 1) {
                    out.print(arrayList.get(i));
                } else {
                    out.print(arrayList.get(i) + "+");
                }
            }
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public String scanString() {
            int c = scan();
            while (isWhiteSpace(c)) c = scan();
            StringBuilder RESULT = new StringBuilder();
            do {
                RESULT.appendCodePoint(c);
                c = scan();
            } while (!isWhiteSpace(c));
            return RESULT.toString();
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

