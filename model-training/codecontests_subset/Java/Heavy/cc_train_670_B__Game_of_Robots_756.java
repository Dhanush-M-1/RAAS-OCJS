import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Objects;

public class GameOfRobots {

    public static void main(String[] args) {
        Reader read = new Reader();

        int n = read.nextInt();
        int k = read.nextInt();
        long[] ids = new long[n+1];

        for(int i=1; i<n+1; i++)
            ids[i] = read.nextLong();

        int i = 1;

        while(true) {
            if(k-i > 0) {
                k = k - i;
                i++;
            } else {
                System.out.print(ids[k]);
                break;
            }
        }
    }

    private static class Reader {

        private final BufferedReader reader;
        private final String separator;
        private String ln;
        private String[] tokens;
        private int ptr;

        Reader(String separator, InputStream input) {
            this.reader = new BufferedReader(new InputStreamReader(input));
            this.separator = separator;
            this.ptr = -1;
        }

        Reader(String separator) { this(separator, System.in); }

        Reader() { this(" "); }

        String nextStr(){
            if (Objects.isNull(ln)) {
                try {
                    ln = reader.readLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                if (Objects.nonNull(ln)) {
                    tokens = ln.split(separator);
                    ptr = 0;
                } else {
                    throw new NoSuchElementException("no next element");
                }

            } else if (ptr == tokens.length) {
                ln = null;
                tokens = null;
                ptr = -1;
                return nextStr();
            }

            return tokens[ptr++];
        }

        int nextInt() { return Integer.parseInt(nextStr()); }

        long nextLong() { return Long.parseLong(nextStr()); }

        double nextDouble() { return Double.parseDouble(nextStr()); }
    }
}
