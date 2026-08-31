import java.io.IOException;
import java.io.InputStream;
import java.util.*;




public class Solution{
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];

        private int curChar;

        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new RuntimeException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            final StringBuilder stringBuilder = new StringBuilder();
            int c = read();
            while (isSpaceChar(c))
                c = read();
            do {
                stringBuilder.append(c);
                c = read();
            } while (!isSpaceChar(c));
            return stringBuilder.toString();
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }


    public static void main(String[] args) throws InputMismatchException, IOException {

        final Solver solver =new Solver();
        final InputReader reader =new InputReader(System.in);
        int number_of_prizes = reader.readInt();
        int result = Integer.MIN_VALUE;

        int[] prizes =new int[number_of_prizes];
        for(int i = 0;i<number_of_prizes;i++)
            prizes[i] = reader.readInt();


        System.out.println(solver.solve(number_of_prizes, prizes));

    }
}


class Solver {
    //This class contains the logic.
    public int solve(int number_of_prizes, int[] prizes) {

        int[] time = new int[number_of_prizes];
        for(int i = 0;i<number_of_prizes;i++){
            time[i] = Math.min(Math.abs(prizes[i] - 1), Math.abs(1000000 - prizes[i]));
        }
        Arrays.sort(time);
        return time[number_of_prizes-1];


    }
}