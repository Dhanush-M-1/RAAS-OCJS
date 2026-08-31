import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author ashiqmostofa
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {

    int n;
    int [] x;
    int[] h;
    int[][] dp;

    int fun(int node,int flag){
        if(node==n-1)return 0;

        int ret=dp[node][flag];
        if(ret!=-1)return ret;

        ret=0;

        if(flag==0){
            if(x[node]-h[node]>x[node-1]){
                ret=fun(node+1,0)+1;
            }
            else {
                ret=fun(node+1,0);
                if(x[node]+h[node]<x[node+1]){
                    ret=Math.max(ret,fun(node+1,1)+1);
                }
            }
        }
        else{
            ret=fun(node+1,0);
            if(x[node-1]+h[node-1]<x[node]-h[node]){
                ret=Math.max(ret,fun(node+1,0)+1);
            }
            if(x[node]+h[node]<x[node+1]){
                ret=Math.max(ret,fun(node+1,1)+1);
            }

        }
        return dp[node][flag]=ret;

    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n=in.readInt();

        x=new int[n];
        h=new int[n];
        dp=new int[n+21][2];

        for(int i=0;i<n;i++){
            x[i]=in.readInt();
            h[i]=in.readInt();
        }
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
if(n>1)out.print(fun(1,0)+2);
        else out.print(n);
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

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
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

    public void close() {
        writer.close();
    }

    public void print(int i) {
        writer.print(i);
    }

}
