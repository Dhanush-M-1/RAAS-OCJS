import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        InputStream is = System.in;
        ScanReader in = new ScanReader(is);
        byte n = Byte.parseByte(in.scanString());
        String s = in.scanString();
        if(s.length() == n) {
            int mp = n / 11;
            int no8 = numOf8(s);
            System.out.println(Math.min(mp, no8));
        }
    }
    
    static int numOf8(String str) {
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.codePointAt(i) == '8') {
                c++;
            }
        }
        return c;
    }

    static class ScanReader {

        private final byte[] buf = new byte[4 * 1024];
        private int index;
        private final BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (IOException e) {
                }
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        public int scanInt() {
            int i = 0;
            int n = scan();
            while (isWhiteSpace(n)) {
                n = scan();
            }
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    i *= 10;
                    i += n - '0';
                    n = scan();
                }
            }
            return neg * i;
        }

        public String scanString() {
            int c = scan();
            while (isWhiteSpace(c)) {
                c = scan();
            }
            StringBuilder RESULT = new StringBuilder();
            do {
                RESULT.appendCodePoint(c);
                c = scan();
            } while (!isWhiteSpace(c));
            return RESULT.toString();
        }

        private boolean isWhiteSpace(int n) {
            return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
        }

    }
}
