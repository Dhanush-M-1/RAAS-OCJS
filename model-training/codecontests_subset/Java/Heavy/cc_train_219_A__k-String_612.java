import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    //=========================================================================
    public static final String INPUT = "";
    public static final String OUTPUT = "";
    //=========================================================================
    BufferedReader br;
    BufferedWriter bw;
    Scanner in;
    PrintWriter out;
    StreamTokenizer st;
    int nextInt() throws IOException { st.nextToken(); return (int)(st.nval); }
    long nextLong() throws IOException { st.nextToken(); return (long)(st.nval); }
    double nextDouble() throws IOException { st.nextToken(); return st.nval; }
    String nextLine() throws IOException { return br.readLine(); }
    //=========================================================================
    public Main() throws IOException {
        br = new BufferedReader(INPUT.isEmpty() ? new InputStreamReader(System.in) : new FileReader(INPUT));
        bw = new BufferedWriter(OUTPUT.isEmpty() ? new OutputStreamWriter(System.out) : new FileWriter(OUTPUT));
        in = new Scanner(br);
        out = new PrintWriter(bw);
        st = new StreamTokenizer(br);
    }       
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    //========================================================================= 
    
    int[] a;

    void f(int x) {
        if (x == 1) return;
        int t = a[x - 1];
        a[x - 1] = a[x - 2];
        a[x - 2] = t;
        f(x - 1);
    }
    
    void run() throws IOException {
        int n = in.nextInt();
        char[] str = in.next().toCharArray();
        int[] count = new int[256];
        for (char c : str) {
            ++count[c];
        }
        int p = 0;
        for (int i = 0; i < 256; ++i) {
            if (count[i] % n != 0) {
                out.println(-1);
                out.flush();
                return;
            }
            while (count[i] != 0) {
                for (int j = 0; j < n; ++j) {
                    str[str.length / n * j + p] = (char)(i);
                }
                ++p;
                count[i] -= n;
            }
        }
        out.println(String.copyValueOf(str));
        out.flush();
    }
}