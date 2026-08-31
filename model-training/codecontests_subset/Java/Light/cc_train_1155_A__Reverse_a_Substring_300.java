import java.io.*;
import java.util.*;

public class SolverA {

    StringTokenizer stok;
    BufferedReader br;
    PrintWriter pw;

    String nextToken() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            stok = new StringTokenizer(br.readLine());
        }
        return stok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private void run() throws IOException {
//        br = new BufferedReader(new FileReader("input.txt"));
//        pw = new PrintWriter("output.txt");
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        pw.flush();
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        new SolverA().run();
    }

    private void solve() throws IOException {
        int n = nextInt();
        String str = nextToken();
        for(int i = 1; i < n; i++){
            if(str.charAt(i) < str.charAt(i-1)){
                pw.println("YES");
                pw.print(i);
                pw.print(" ");
                pw.print(i+1);
                return;
            }
        }
        pw.println("NO");
    }


}