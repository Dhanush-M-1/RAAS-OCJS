import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();       
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");

    private void run() throws IOException {
        if (new File("input.txt").exists())
            in = new BufferedReader(new FileReader("input.txt"));
        else
            in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }
    

    private void solve() throws IOException {
        
        int n = 5;
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) 
            sum += a[i];
        if (sum % 5 == 0 && sum > 0)
            out.println(sum / 5);
        else
            out.println(-1);
        
    }
    
    void chk(boolean b) {
        if (b)
            return;
        System.out.println(new Error().getStackTrace()[1]);
        exit(999);
    }
    void deb(String fmt, Object... args) {
        System.out.printf(Locale.US, fmt + "%n", args);
    }
    String nextToken() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    String nextLine() throws IOException {
        st = new StringTokenizer("");
        return in.readLine();
    }
    boolean EOF() throws IOException {
        while (!st.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null)
                return true;
            st = new StringTokenizer(s);
        }
        return false;
    }
}
