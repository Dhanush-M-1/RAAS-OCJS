import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Task1060A {

    public static class FastScanner {

        protected static final int STRBUFFERLENGTH = 0x1000;

        protected DataInputStream dataInputStream;
        protected byte[] buffer = new byte[0x10000];
        protected byte[] strbuffer = new byte[STRBUFFERLENGTH];
        protected int bufferOffset;
        protected int bufferLength;
        protected boolean isEndOfFile;

        public FastScanner() throws IOException {
            dataInputStream = new DataInputStream(System.in);
            Read();
        }

        public FastScanner(final String fileName) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(fileName));
            Read();
        }

        protected void Read() throws IOException {
            final int length = dataInputStream.read(buffer);
            if (length > 0) {
                bufferLength = length;
            } else {
                bufferLength = 0;
                isEndOfFile = true;
            }
            bufferOffset = 0;
        }

        protected byte nextByte() throws IOException {
            if (bufferOffset == bufferLength) {
                if (!isEndOfFile) Read();
                if (isEndOfFile) return 0;
            }
            return buffer[bufferOffset++];
        }

        public int nextInt() throws IOException {
            int a = 0;
            boolean isNegative = false;

            byte b = nextByte();
            while (b <= ' ') b = nextByte();
            if (b == '-') {
                isNegative = true;
                b = nextByte();
            }
            while (b > ' ') {
                a = a * 10 + (b - '0');
                b = nextByte();
            }
            return isNegative ? -a : a;
        }

        public String nextLine() throws IOException {
            String s = "";
            int strbufferOffset = 0;

            byte b = nextByte();
            while (b <= ' ') b = nextByte();

            do {
                strbuffer[strbufferOffset++] = b;
                if (strbufferOffset >= STRBUFFERLENGTH) {
                    s += new String(strbuffer, 0, STRBUFFERLENGTH);
                    strbufferOffset = 0;
                }
                b = nextByte();
            } while (b != '\n' && b != '\r' && b != 0);
            s += new String(strbuffer, 0, strbufferOffset);

            return s;
        }

    }

    public static void main(final String[] args) throws IOException {

        final FastScanner scanner = new FastScanner();

        final String sn = scanner.nextLine();
        final int n = Integer.parseInt(sn);
        final String s = scanner.nextLine();

        int num8 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '8') num8++;
        }

        System.out.println(Math.min(num8, n / 11));
    }

}
