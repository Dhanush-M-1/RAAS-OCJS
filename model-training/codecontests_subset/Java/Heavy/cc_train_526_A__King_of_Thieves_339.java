import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        new Main().start(in, out); 
        out.close();
    }
    
    public void start(InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String s = in.next();
        int l = s.length();
        if(l < 5)
            out.printLine("no");
        else {
            for(int i=0 ; i<l ; i++) {
                if(s.charAt(i) == '.')
                    continue;
                boolean found = false;
                int count = 1 ;
                int jump = -1;
                int cur = -1;
                for(int j=i+1 ; j<l ; j++) {
                    if(count == 5)
                        break;
                    if(found == false) {
                        if(s.charAt(j) == '.')
                            continue;
                        count++;
                        found = true;
                        jump = j-i;
                        cur = j;
                        j += jump;
                        j--;
                    } else {
                        if(s.charAt(j) != '.') {
                            count++;
                            j += jump;
                            j--;
                        }
                        else {
                            count = 1;
                            found = false;
                            j = cur;
                        }
                    }
                }
                if(count >= 5) {
                    out.printLine("yes");
                    return;
                }
            }
            out.printLine("no");
        }
    }

    public void solve() {
        
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buffer = new byte[10000];
    private int cur;
    private int count;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public static boolean isSpace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public int read() {
        if (count == -1) {
            throw new InputMismatchException();
        }
        try {
            if (cur >= count) {
                cur = 0;
                count = stream.read(buffer);
                if (count <= 0)
                    return -1;
            }
        } catch (IOException e) {
            throw new InputMismatchException();
        }
        return buffer[cur++];
    }

    public int readSkipSpace() {
        int c;
        do {
            c = read();
        } while (isSpace(c));
        return c;
    }

    public int nextInt() {
        int sgn = 1;
        int c = readSkipSpace();
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res = res * 10 + c - '0';
            c = read();
        } while (!isSpace(c));
        res *= sgn;
        return res;
    }

    public String next() {
        int c = readSkipSpace();
        StringBuilder sb = new StringBuilder();
        while (!isSpace(c)) {
            sb.append((char) c);
            c = read();
        }
        return sb.toString();
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

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}