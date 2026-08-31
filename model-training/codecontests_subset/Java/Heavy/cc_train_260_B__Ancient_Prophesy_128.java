import java.io.*;
import java.util.*;

public class ProblemB {
    InputReader in; PrintWriter out;
    final int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    boolean f(char c) {
        return Character.isDigit(c);
    }
    int g(char c) {
        return c - '0';
    }
    void solve() {
        String s = in.next();
        int[][][] num = new int[2100][13][32];
        int len = s.length();
        for (int i = 0; i < len - 9; i++) {
            if (f(s.charAt(i)) && f(s.charAt(i + 1)))
                if (s.charAt(i + 2) == '-')
                    if (f(s.charAt(i + 3)) && f(s.charAt(i + 4)))
                        if (s.charAt(i + 5) == '-')
                            if (f(s.charAt(i + 6)) && f(s.charAt(i + 7)) && f(s.charAt(i + 8)) && f(s.charAt(i + 9))) {
                                int cy = g(s.charAt(i + 6)) * 1000 + g(s.charAt(i + 7)) * 100 + g(s.charAt(i + 8)) * 10 + g(s.charAt(i + 9));
                                int cm = g(s.charAt(i + 3)) * 10 + g(s.charAt(i + 4));
                                int cd = g(s.charAt(i)) * 10 + g(s.charAt(i + 1));
                                if (cy <= 2015 && cm <= 12 && cd <= 31)
                                    num[cy][cm][cd]++;
                            }           
        }
        int ansy = 0, ansm = 0, ansd = 0;
        int ca = 0;
        for (int i = 2013; i <= 2015; i++)
            for (int j = 1; j <= 12; j++)
                for (int k = 1; k <= d[j]; k++) {
                    if (num[i][j][k] > ca) {
                        ansy = i;
                        ansm = j;
                        ansd = k;
                        ca = num[i][j][k];
                    }
                }
        if (ansd < 10)
            out.print("0");
        out.print(ansd + "-");
        if (ansm < 10)
            out.print("0");
        out.print(ansm);
        out.println("-" + ansy);
        
    }
    
    ProblemB(){
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
        new ProblemB();
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