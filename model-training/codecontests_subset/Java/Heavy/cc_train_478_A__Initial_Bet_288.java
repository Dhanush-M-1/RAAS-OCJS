import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Objects;

public class InitialBet {

    public static void main(String[] args) {
        Reader read = new Reader();

        int sum = 0;
        for(int i=0; i<5; i++)
            sum += read.nextInt();

        if(sum != 0 && sum % 5 == 0)
            System.out.print(sum/5);
        else
            System.out.print(-1);
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
