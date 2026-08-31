
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 *
 * @author jigsaw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStream inputstream = System.in;
        OutputStream outputstream = System.out;
        InputReader in = new InputReader(inputstream);
        OutputWriter outt = new OutputWriter(outputstream);
        int n = in.readInt();
        int a;
        int hun = 0,twohun = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            a = in.readInt();
            if(a==100)
                hun++;
            else
                twohun++;
            sum += a;
            
        }
        sum = hun + twohun*2;
        if(hun==0&&twohun%2!=0)
            outt.printLine("NO");
        else if(sum%2==0)
            outt.printLine("YES");
        else
            outt.printLine("NO");
        /*if(hun%2==0&&twohun%2==0)
            outt.printLine("YES");
        if(hun%2==0&&twohun%2!=0){
            if(hun/2>twohun){
                hun -= twohun*2;
                if(hun%2==0)
                    outt.printLine("YES");
                else
                    outt.printLine("NO");
            }
            if(hun/2==twohun){
                outt.printLine("YES");
            }
            if(hun/2<twohun){
                twohun -= hun/2;
                if(twohun%2==0)
                    outt.printLine("YES");
                else
                    outt.printLine("NO");
            }
        }
        if(hun%2!=0)
            outt.printLine("NO");*/
        
        outt.close();
    }
}
class InputReader {
 
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;
 
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
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
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
    }}

