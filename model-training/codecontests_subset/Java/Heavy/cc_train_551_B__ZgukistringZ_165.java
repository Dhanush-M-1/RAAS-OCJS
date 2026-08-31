
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Main {

    private void start(InputReader in, PrintStream out) {
        String a, b, c;

        a = in.next();
        b = in.next();
        c = in.next();

        int map1[] = new int[26], map2[] = new int[26], map3[] = new int[26];

        for (int i = 0; i < a.length(); i++) {
            map1[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            map2[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < c.length(); i++) {
            map3[c.charAt(i) - 'a']++;
        }

        boolean b1 = true;
        int count2 = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map2[i] == 0) {
                continue;
            }
            if (map1[i] < map2[i]) {
                b1 = false;
                count2 = 0;
                break;
            } else {
                count2 = Math.min(count2, map1[i] / map2[i]);
            }
        }

        boolean b2 = true;
        int count3 = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map3[i] == 0) {
                continue;
            }
            if (map1[i] < map3[i]) {
                b2 = false;
                count3 = 0;
                break;
            } else {
                count3 = Math.min(count3, map1[i] / map3[i]);
            }
        }
        
        while (count2 > 0 || count3 > 0) {
            if (count2 > count3) {
                out.print(b);
                for (int i = 0; i < 26; i++) {
                    map1[i] -= map2[i];
                }
            } else {
                out.print(c);
                for (int i = 0; i < 26; i++) {
                    map1[i] -= map3[i];
                }
            }
            
            count2 = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (map2[i] == 0) {
                    continue;
                }
                if (map1[i] < map2[i]) {
                    b1 = false;
                    count2 = 0;
                    break;
                } else {
                    count2 = Math.min(count2, map1[i] / map2[i]);
                }
            }
            
            count3 = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (map3[i] == 0) {
                    continue;
                }
                if (map1[i] < map3[i]) {
                    b2 = false;
                    count3 = 0;
                    break;
                } else {
                    count3 = Math.min(count3, map1[i] / map3[i]);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < map1[i]; j++) {
                out.print((char) (i + 'a'));
            }
        }
        out.println();
        
        /*for (int i = 0; i < count2; i++) {
            out.print(p);
        }
        for (int i = 0; i < 26; i++) {
            map1[i] -= count2 * map2[i];
        }
        count3 = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map3[i] == 0) {
                continue;
            }
            if (map1[i] < map3[i]) {
                b2 = false;
                count3 = 0;
                break;
            } else {
                count3 = Math.min(count3, map1[i] / map3[i]);
            }
        }
        for (int i = 0; i < count3; i++) {
            out.print(q);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < map1[i] - count3 * map3[i]; j++) {
                out.print((char) (i + 'a'));
            }
        }
        out.println();*/
        
        /*if (b1 && !b2) {
            for (int i = 0; i < count2; i++) {
                out.print(b);
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < map1[i] - count2 * map2[i]; j++) {
                    out.print((char) (i + 'a'));
                }
            }
            out.println();
        } else if (!b1 && b2) {
            for (int i = 0; i < count3; i++) {
                out.print(c);
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < map1[i] - count3 * map3[i]; j++) {
                    out.print((char) (i + 'a'));
                }
            }
            out.println();
        } else if (!b1 && !b2) {
            out.println(a);
        } else if (count2 > count3) {
            for (int i = 0; i < count2; i++) {
                out.print(b);
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < map1[i] - count2 * map2[i]; j++) {
                    out.print((char) (i + 'a'));
                }
            }
            out.println();
        } else {
            for (int i = 0; i < count3; i++) {
                out.print(c);
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < map1[i] - count3 * map3[i]; j++) {
                    out.print((char) (i + 'a'));
                }
            }
            out.println();
        }*/
    }

    public static void main(String[] args) throws Exception {
        //InputReader in = new InputReader(new FileInputStream(new File("in.txt")));
        //PrintStream out = new PrintStream("out.txt");

        InputReader in = new InputReader(System.in);
        PrintStream out = System.out;

        new Main().start(in, out);
    }

    private static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }
    }

    private class Pair<K, V> implements Serializable {

        private K key;

        public K getKey() {
            return key;
        }
        private V value;

        public V getValue() {
            return value;
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public int hashCode() {
            return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Pair) {
                Pair pair = (Pair) o;
                if (key != null ? !key.equals(pair.key) : pair.key != null) {
                    return false;
                }
                if (value != null ? !value.equals(pair.value) : pair.value != null) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

}
