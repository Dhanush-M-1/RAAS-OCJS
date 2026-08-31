// 268A - Games
import java.io.IOException;
import java.io.InputStream; 

public class Games {
	public static void main(String[] args) {
		FastIO io = new FastIO(System.in);

        int teams = io.readInt(); 

        int[] homeJerseys = new int[teams];
        int[] awayJerseys = new int[teams]; 

        for (int i = 0; i < teams; i++) {
            homeJerseys[i] = io.readInt();
            awayJerseys[i] = io.readInt(); 
        }

        Solver solver = new Solver();
        System.out.println(solver.solve(teams, homeJerseys, awayJerseys));
	} 
}

class Solver {
    public int solve(int teams, int[] home, int[] away) {
        int count = 0; 
        for (int i = 0; i < teams; i++) {
            for (int j = 0; j < teams; j++) {
                if (j == i) continue; 

                if (away[i] == home[j]) {
                    count++;
                }
            }
        }
        return count;  
    }
}


class FastIO {
    // Written by Guarav Sen
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastIO(InputStream stream) {
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

    /**
    * @author Bibhuti Bhusan Panda
    */
    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c)) {
                res.appendCodePoint(c);
            }
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
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

    private String readLine0() {
        StringBuilder buf = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buf.appendCodePoint(c);
            }
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0) {
            s = readLine0();
        }
        return s;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}