import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Set;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author BSRK Aditya (bsrkaditya@gmail.com)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    boolean isD(char x) {
        return '0' <= x && x <= '9';
    }
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        String x = in.next();
        int sz = x.length();
        char [] a = x.toCharArray();

        Counter<String> times = new Counter<String>();

        for(int i = 0; i+10 <= sz; ++i) {
            if(isD(a[i]) && isD(a[i+1]) && a[i+2] == '-'&& isD(a[i+3]) && isD(a[i+4]) && a[i+5] == '-' && a[i+6] == '2' && a[i+7] == '0' && isD(a[i+8]) && isD(a[i+9])) {
                int d = Integer.parseInt(x.substring(i,i+2));
                int m = Integer.parseInt(x.substring(i+3,i+5));
                int y = Integer.parseInt(x.substring(i+8, i+10));

                if(1 <= m && m <= 12 && y >= 13 && y <= 15) {
                    int [] ds = {31,28,31,30,31,30,31,31,30,31,30,31};
                    if(d >= 1 && d <= ds[m-1]) times.add(x.substring(i,i+10));
                }
            }
        }

        String ans = "";
        int ns = 0;
        for(String y : times.keySet()) {
           if(ns < times.get(y)) { ans = y; ns = times.get(ans); }
        }

        out.printLine(ans);
	}
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String next() {
        StringBuilder ans = new StringBuilder();
        int c = read();
        while(isSpaceChar(c)) c = read();
        do {
           ans.append((char)c);
           c = read();
        } while(!isSpaceChar(c));

        return ans.toString();
    }


    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}

class Counter<T> extends HashMap<T, Integer> {
    public void add(T x) {
       int v = 1;
       if(this.containsKey(x)) v += this.get(x);
       this.put(x, v);
    }

    }

