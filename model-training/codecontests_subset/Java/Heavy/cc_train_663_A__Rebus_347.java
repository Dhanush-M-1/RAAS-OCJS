//package baobab;
import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) {
        BIO io = new BIO();
        try {
            Bsolver solver = new Bsolver(io);
        } finally {
            io.close();
        }
    }

}

class Bsolver {

    public Bsolver(BIO io) {
        io.println(solve(io));
    }

    public String solve(BIO io) {
        StringBuilder order = new StringBuilder();
        int countAdd = 1; /* The very first q mark */
        int countSub = 0;
        while (true) {
            String s = io.next();
            if (s.equals("?")) continue;
            if (s.equals("=")) break;
            if (s.equals("-")) countSub++;
            if (s.equals("+")) countAdd++;
            order.append(s);

        }
        long n = io.nextLong();
        StringBuilder sb = new StringBuilder();
        sb.append("Possible\n");

        int diff = countAdd - countSub;
        if (diff > 0) {
            long starter = n - diff + 1;
            if (starter < 1) {
                sb.append("1 ");
                countAdd--;
                long sum = 1 + countAdd * 1;
                List<Long> toSub = new ArrayList<Long>();
                while (sum > 2*n) {
                    toSub.add(n);
                    sum -= n;
                    countSub--;
                }
                if (countSub < 1) {
                    return "Impossible";
                }
                toSub.add(sum-n);
                countSub--;
                sum -= (sum-n);

                while (countSub > 0) {
                    Long val = toSub.remove(0);
                    countSub++;
                    while (countSub >= 2 && val >= 2) {
                        toSub.add(1L);
                        val--;
                        countSub--;
                    }
                    toSub.add(val);
                    countSub--;
                }

                for (int i = 0; i < order.length(); i++) {
                    char c = order.charAt(i);
                    sb.append(c + " ");
                    if (c == '+') {
                        sb.append(1L);
                    } else {
                        sb.append(toSub.remove(0));
                    }
                    sb.append(" ");
                }
            } else {
                sb.append(starter + " ");
                for (int i = 0; i < order.length(); i++) {
                    char c = order.charAt(i);
                    sb.append(order.charAt(i) + " 1 ");
                }
            }

        } else {
            long starter = n;
            sb.append(starter + " ");
            long sum = n - countSub * 1;
            countAdd--;
            List<Long> toAdd = new ArrayList<Long>();
            while (sum < n) {
                long addition = Math.min(n, (n-sum));
                toAdd.add(addition);
                sum += addition;
                countAdd--;
            }
            if (countAdd < 0) {
                return "Impossible";
            }
            if (countAdd > 0) {
                toAdd.clear();
                sum = n - countSub * 1 + countAdd * 1;
                for (int i=1; i<=countAdd; i++) {
                    toAdd.add(1L);
                }
                while (sum < n) {
                    long addition = Math.min(n, (n-sum));
                    toAdd.add(addition);
                    sum += addition;
                }
            }
            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                sb.append(c + " ");
                if (c == '+') {
                    sb.append(toAdd.remove(0));
                } else {
                    sb.append(1L);
                }
                sb.append(" ");
            }
        }
        sb.append("= " + n);
        return sb.toString();
    }
}

class BIO extends PrintWriter {
    private InputStreamReader r;
    private static final int BUFSIZE = 1 << 15;
    private char[] buf;
    private int bufc;
    private int bufi;
    private StringBuilder sb;

    public BIO() {
        super(new BufferedOutputStream(System.out));
        r = new InputStreamReader(System.in);

        buf = new char[BUFSIZE];
        bufc = 0;
        bufi = 0;
        sb = new StringBuilder();
    }

    private void fillBuf() throws IOException {
        bufi = 0;
        bufc = 0;
        while(bufc == 0) {
            bufc = r.read(buf, 0, BUFSIZE);
            if(bufc == -1) {
                bufc = 0;
                return;
            }
        }
    }

    private boolean pumpBuf() throws IOException {
        if(bufi == bufc) {
            fillBuf();
        }
        return bufc != 0;
    }

    private boolean isDelimiter(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f';
    }

    private void eatDelimiters() throws IOException {
        while(true) {
            if(bufi == bufc) {
                fillBuf();
                if(bufc == 0) throw new RuntimeException("IO: Out of input.");
            }

            if(!isDelimiter(buf[bufi])) break;
            ++bufi;
        }
    }

    public String next() {
        try {
            sb.setLength(0);

            eatDelimiters();
            int start = bufi;

            while(true) {
                if(bufi == bufc) {
                    sb.append(buf, start, bufi - start);
                    fillBuf();
                    start = 0;
                    if(bufc == 0) break;
                }

                if(isDelimiter(buf[bufi])) break;
                ++bufi;
            }

            sb.append(buf, start, bufi - start);

            return sb.toString();
        } catch(IOException e) {
            throw new RuntimeException("IO.next: Caught IOException.");
        }
    }

    public int nextInt() {
        try {
            int ret = 0;

            eatDelimiters();

            boolean positive = true;
            if(buf[bufi] == '-') {
                ++bufi;
                if(!pumpBuf()) throw new RuntimeException("IO.nextInt: Invalid int.");
                positive = false;
            }

            boolean first = true;
            while(true) {
                if(!pumpBuf()) break;
                if(isDelimiter(buf[bufi])) {
                    if(first) throw new RuntimeException("IO.nextInt: Invalid int.");
                    break;
                }
                first = false;

                if(buf[bufi] >= '0' && buf[bufi] <= '9') {
                    if(ret < -214748364) throw new RuntimeException("IO.nextInt: Invalid int.");
                    ret *= 10;
                    ret -= (int)(buf[bufi] - '0');
                    if(ret > 0) throw new RuntimeException("IO.nextInt: Invalid int.");
                } else {
                    throw new RuntimeException("IO.nextInt: Invalid int.");
                }

                ++bufi;
            }

            if(positive) {
                if(ret == -2147483648) throw new RuntimeException("IO.nextInt: Invalid int.");
                ret = -ret;
            }

            return ret;
        } catch(IOException e) {
            throw new RuntimeException("IO.nextInt: Caught IOException.");
        }
    }

    public long nextLong() {
        try {
            long ret = 0;

            eatDelimiters();

            boolean positive = true;
            if(buf[bufi] == '-') {
                ++bufi;
                if(!pumpBuf()) throw new RuntimeException("IO.nextLong: Invalid long.");
                positive = false;
            }

            boolean first = true;
            while(true) {
                if(!pumpBuf()) break;
                if(isDelimiter(buf[bufi])) {
                    if(first) throw new RuntimeException("IO.nextLong: Invalid long.");
                    break;
                }
                first = false;

                if(buf[bufi] >= '0' && buf[bufi] <= '9') {
                    if(ret < -922337203685477580L) throw new RuntimeException("IO.nextLong: Invalid long.");
                    ret *= 10;
                    ret -= (long)(buf[bufi] - '0');
                    if(ret > 0) throw new RuntimeException("IO.nextLong: Invalid long.");
                } else {
                    throw new RuntimeException("IO.nextLong: Invalid long.");
                }

                ++bufi;
            }

            if(positive) {
                if(ret == -9223372036854775808L) throw new RuntimeException("IO.nextLong: Invalid long.");
                ret = -ret;
            }

            return ret;
        } catch(IOException e) {
            throw new RuntimeException("IO.nextLong: Caught IOException.");
        }
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

}