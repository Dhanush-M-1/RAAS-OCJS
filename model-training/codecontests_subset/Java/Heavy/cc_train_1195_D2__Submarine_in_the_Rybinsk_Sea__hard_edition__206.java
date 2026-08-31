import java.io.*;
import java.math.BigInteger;

public class Oao {
    static class Parser {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Parser(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextString(int maxSize) {
            byte[] ch = new byte[maxSize];
            int point = 0;
            try {
                byte c = read();
                while (c == ' ' || c == '\n' || c == '\r')
                    c = read();
                while (c != ' ' && c != '\n' && c != '\r') {
                    ch[point++] = c;
                    c = read();
                }
            } catch (Exception e) {
            }
            return new String(ch, 0, point);
        }

        public int nextBigInteger() {
            int ret = 0;
            boolean neg;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                neg = c == '-';
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                    c = read();
                } while (c > ' ');

                if (neg) return -ret;
            } catch (Exception e) {
            }
            return ret;
        }

        public long nextLong() {
            long ret = 0;
            boolean neg;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                neg = c == '-';
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                    c = read();
                } while (c > ' ');

                if (neg) return -ret;
            } catch (Exception e) {
            }
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            } catch (Exception e) {
            }
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    static BigInteger[] G;
    static String[] v;
    static int[] l, nu;

    public static void main(String[] args) throws FileNotFoundException {
        Parser in = new Parser(System.in);
        //Parser in = new Parser(new FileInputStream("input.txt"));
        G = new BigInteger[101];
        for (int i = 0; i < 101; i++) {
            G[i] = new BigInteger("" + i);
        }
        int n = in.nextBigInteger();

        v = new String[n];
        l = new int[n];
        nu = new int[11];

        for (int i = 0; i < n; i++) {
            v[i] = in.nextString(11);
            l[i] = v[i].length();
            ++nu[l[i]];
        }
        BigInteger co = G[0];
        for (int i = 0; i < n; i++) {
            BigInteger temp1 = G[0];
            //1
            {
                for (int j = 1; j <= l[i] - 1; ++j) {
                    BigInteger temp = G[0];

                    for (int k = 0; k < l[i] - j; ++k) {
                        temp = temp.multiply(G[10]);
                        temp = temp.add(G[v[i].charAt(k) - '0']);
                    }
                    for (int k = 0; k < j; ++k) {
                        temp = temp.multiply(G[100]);
                        temp = temp.add(G[(v[i].charAt(l[i] - j + k) - '0') * 10]);
                    }

                    BigInteger temp2 = new BigInteger(nu[j] + "");
                    temp = temp.multiply(temp2);
                    temp1 = temp1.add(temp);
                }

                {
                    BigInteger temp = G[0];
                    for (int k = 0; k < l[i]; ++k) {
                        temp = temp.multiply(G[100]);
                        temp = temp.add(G[(v[i].charAt(k) - '0') * 10]);
                    }

                    long o = 0;
                    for (int k = l[i]; k <= 10; ++k) o += nu[k];
                    BigInteger temp2 = new BigInteger(o + "");
                    temp = temp.multiply(temp2);
                    temp1 = temp1.add(temp);
                }
            }

            //2
            {
                for (int j = 1; j <= l[i] - 1; ++j) {
                    BigInteger temp = G[0];

                    for (int k = 0; k < l[i] - j; ++k) {
                        temp = temp.multiply(G[10]);
                        temp = temp.add(G[v[i].charAt(k) - '0']);
                    }
                    for (int k = 0; k < j; ++k) {
                        temp = temp.multiply(G[100]);
                        temp = temp.add((G[(v[i].charAt(l[i] - j + k) - '0')]));
                    }

                    BigInteger temp2 = new BigInteger(nu[j] + "");
                    temp = temp.multiply(temp2);
                    temp1 = temp1.add(temp);
                }

                {
                    BigInteger temp = G[0];
                    for (int k = 0; k < l[i]; ++k) {
                        temp = temp.multiply(G[100]);
                        temp = temp.add((G[(v[i].charAt(k) - '0')]));
                    }

                    long o = 0;
                    for (int k = l[i]; k <= 10; ++k) o += nu[k];
                    BigInteger temp2 = new BigInteger(o + "");
                    temp = temp.multiply(temp2);
                    temp1 = temp1.add(temp);
                }
            }
            co = co.add(temp1);
        }
        System.out.println(co.mod(new BigInteger("998244353")));
    }
}
