import java.io.*;
import java.util.*;

public class ProblemB1 {
    InputReader in; PrintWriter out;
    int db;
    int n, x;
    boolean[][] gr = new boolean[1000][1000];
    boolean[] was = new boolean[1000];
    int[] ksize = new int[1000];
    int knum;
    int kTotal;
    int kdepth;
    int kcur = 0;
    
    void dfs(int v, int depth) {
        if (was[v])
            return;
        if (v == x) {
            knum = kcur;
        }
        was[v] = true;
        ksize[kcur]++;
        for (int i = 0; i < n; i++) {
            if (gr[v][i])
                dfs(i, depth + 1);
        }
    }
    
    void solve() {
        n = in.nextInt();
        x = in.nextInt();
        x--;
        int cur;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                gr[i][j] = false;
        int[] before = new int[n];
        for (int i = 0; i < n; i++) {
            cur = in.nextInt();
            before[i] = cur - 1;
            if (cur != 0) {
                gr[cur - 1][i] = true;
                gr[i][cur - 1] = true;
            }
        }
        
        cur = x;
        kdepth = 0;
        while (cur != -1) {
            cur = before[cur];
            kdepth++;
        }
        /*
        for (int i = 0; i < n; i++, out.println())
            for (int j = 0; j < n; j++)
                if (gr[i][j])
                    out.print('1');
                else
                    out.print('0');
        out.println();
        */
        kcur = 0;
        for (int i = 0; i < n; i++)
            ksize[i] = 0;
        for (int i = 0; i < n; i++) {
            if (!was[i]) {
                dfs(i, 0);
                kcur++;
            }
        }
        kTotal = kcur;
        
//      out.println("knum == " + knum + " kTotal == " + kTotal + " kdepth == " + kdepth);
        
        int tmp = ksize[knum]; ksize[knum] = ksize[kTotal - 1]; ksize[kTotal - 1] = tmp;
        knum = kTotal - 1;

        /*
        out.println("ksize:");
        for (int i = 0; i < kTotal; i++)
            out.print(ksize[i] + " ");
        out.println();
        */
    
        boolean[][] f = new boolean[kTotal][n + 1];
        f[0][kdepth] = true;
        for (int i = 1; i < kTotal; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (j - ksize[i - 1] >= 0)
                    f[i][j] = (f[i][j] || f[i - 1][j - ksize[i - 1]]);
            }
        }
        
        for (int j = 1; j <= n; j++)
            if (f[kTotal - 1][j])
                out.println(j);
        
    }
    
    ProblemB1(){
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            if (oj) {
                in = new InputReader(System.in);
                out = new PrintWriter(System.out);
            }
            else {
                Writer w = new FileWriter("output.txt");
                in = new InputReader(new FileReader("input.txt"));
                out = new PrintWriter(w);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        solve();
        out.close();
    }
    public static void main(String[] args){
        new ProblemB1();
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
    
    public InputReader(FileReader fr) {
        reader = new BufferedReader(fr);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }

}