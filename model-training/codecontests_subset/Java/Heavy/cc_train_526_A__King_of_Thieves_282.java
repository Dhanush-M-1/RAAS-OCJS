import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class A {

    void solve() throws IOException {
        int n=nextInt();
        String s=nextToken();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*') {
                for (int j = i + 1; j < n; j++) {
                    int l = j - i + 1;
                    if (l % 4 == 1) {
                        int st = l / 4;
                        if(s.charAt(i+st)=='*'&&s.charAt(i+2*st)=='*'&&s.charAt(i+3*st)=='*'&&s.charAt(i+4*st)=='*'){
                            out.println("yes");
                            return;
                        }
                    }
                }
            }
        }
        out.println("no");
    }

    public static void main(String[] args) throws IOException {
        new A().run();
    }

    void run() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
//      reader = new BufferedReader(new FileReader("input.txt"));
        tokenizer = null;
        out = new PrintWriter(new OutputStreamWriter(System.out));
//      out = new PrintWriter(new FileWriter("output.txt"));
        solve();
        reader.close();
        out.flush();

    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
