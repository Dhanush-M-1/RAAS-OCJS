import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nipuna Samarasekara
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		FastPrinter out = new FastPrinter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    /////////////////////////////////////////////////////////////
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
    int n=in.nextInt(),m=in.nextInt();
        int[][] Q= new int[m][4];
        for (int i = 0; i < m; i++) {
            Q[i]=in.readIntArray(4);
        }
       int[] ans= new int[n];
       int[] cur= new int[n];
        Arrays.fill(ans,1000000000);
        Arrays.fill(cur,1000000000);
        TreeSet<Integer>[] ts= new TreeSet[n];
        for (int i = 0; i < n; i++) {
            ts[i]= new TreeSet<>();
        }
      int mct=0;
        for (int i = 0; i < m; i++) {
          int t=Q[i][0];
            if(t==1){
                for (int j = Q[i][1]-1; j < Q[i][2] ; j++) {
                   cur[j]+=Q[i][3];
                }
            }
           else{
                mct++;
                int max=Q[i][3];
                for (int j = Q[i][1]-1; j < Q[i][2] ; j++) {
                    if(cur[j]>max){
                        ans[j]-=(cur[j]-max);
                        cur[j]=max;
                        ts[j].clear();
                        ts[j].add(i);
                    }
                    else if(cur[j]==max){
                        ts[j].add(i);
                    }
                }

            }
        }
        TreeSet<Integer> aa= new TreeSet<>();
        for (int i = 0; i < n; i++) {
            aa.addAll(ts[i]);
        }
        if(aa.size()!=mct){
            out.println("NO");
            return;
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
    }
}

class FastScanner extends BufferedReader {

    public FastScanner(InputStream is) {
        super(new InputStreamReader(is));
    }

    public int read() {
        try {
            int ret = super.read();
//            if (isEOF && ret < 0) {
//                throw new InputMismatchException();
//            }
//            isEOF = ret == -1;
            return ret;
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }

    public int nextInt() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int ret = 0;
        while (c >= 0 && !isWhiteSpace(c)) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            ret = ret * 10 + c - '0';
            c = read();
        }
        return ret * sgn;
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public int[] readIntArray(int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nextInt();
        }
        return ret;
    }

}

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }


}

