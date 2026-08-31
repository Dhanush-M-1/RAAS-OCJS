import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

public class CopyOfSolution {
    // private T[] arr = new T[2];

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(System.in);
        int mean = 0;
        for (int i = 0; i < 5; i++) {
            mean += in.nextInt();
        }
        out.println((mean != 0 && mean % 5 == 0) ? mean / 5 : -1);
        out.close();
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer s;

        public InputReader(InputStream is) {
            InputStreamReader in = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(in);
            this.reader = reader;
        }

        public String next() {
            while (s == null || !s.hasMoreTokens()) {
                try {
                    s = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return s.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}