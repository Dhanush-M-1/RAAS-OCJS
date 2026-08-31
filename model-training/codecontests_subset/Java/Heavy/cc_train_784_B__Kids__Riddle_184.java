import java.io.*;
import java.util.Arrays;

public class Main {
    static myScanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader input = new BufferedReader(new FileReader(new File("data.in")));
        sc = new myScanner(input);

        //pw = new PrintWriter(new File("data.out"));
        pw = new PrintWriter(System.out);

        solve();

        pw.flush();
        pw.close();
    }

    static void solve() {
        int n = sc.nextInt();
        String s = Integer.toString(n, 16).toUpperCase();
        int ans=0;
        for (int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '4':
                case '6':
                case '9':
                case '0':
                case 'A':
                case 'D':{
                    ans+=1;
                    break;
                }
                case 'B':
                case '8':{
                    ans+=2;
                    break;
                }
            }
        }
        pw.print(ans);
    }
}

class myScanner {
    private char[] buffer = new char[1 << 8];
    private int pos = 1;

    private BufferedReader reader;

    public myScanner(BufferedReader reader) {
        this.reader = reader;
    }

    public boolean hasNext() {
        return pos > 0;
    }

    private void loadBuffer() {
        pos = 0;
        try {
            for (int i; (i = reader.read()) != -1; ) {
                char c = (char) i;
                if (c != ' ' && c != '\n' && c != '\t' && c != '\r' && c != '\f') {
                    if (pos == buffer.length) buffer = Arrays.copyOf(buffer, 2 * pos);
                    buffer[pos++] = c;
                } else if (pos != 0) break;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String current() {
        return String.copyValueOf(buffer, 0, pos);
    }


    public String next() {
        loadBuffer();
        return current();
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


    public int nextInt() {
        return nextInt(10);
    }

    public long nextLong() {
        return nextLong(10);
    }

    public int nextInt(int radix) {
        loadBuffer();
        int result = 0;
        int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
        for (checkValidNumber(pos > i); i < pos; i++) {
            int digit = buffer[i] - '0';
            checkValidNumber(0 <= digit && digit <= radix - 1);
            result = result * radix + digit;
        }
        return buffer[0] == '-' ? -result : result;
    }

    public long nextLong(int radix) {
        loadBuffer();
        long result = 0;
        int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
        for (checkValidNumber(pos > i); i < pos; i++) {
            int digit = buffer[i] - '0';
            checkValidNumber(0 <= digit && digit <= radix - 1);
            result = result * radix + digit;
        }
        return buffer[0] == '-' ? -result : result;
    }

    public double nextDouble() {
        loadBuffer();
        double result = 0;
        int i = buffer[0] == '-' || buffer[0] == '+' ? 1 : 0;
        long round = 1;
        final int radix = 10;
        boolean hasPoint = false;
        for (checkValidNumber(pos > i); i < pos; i++) {
            int digit = buffer[i] - '0';
            checkValidNumber((0 <= digit && digit <= radix - 1) || (!hasPoint && digit == -2));
            if (digit == -2) hasPoint = true;
            else {
                if (hasPoint) round *= radix;
                result = result * radix + digit;
            }

        }
        return buffer[0] == '-' ? -result / round : result / round;
    }

    private void checkValidNumber(boolean condition) {
        if (!condition) throw new NumberFormatException(current());
    }
}