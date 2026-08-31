import java.util.*;
import java.math.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {

    String in = "", out = "";
    BufferedReader reader;
    PrintWriter writer;
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().start();
    }

    void solve() throws IOException {
        int n = nextInt(), x = nextInt(), y = nextInt();
        int need = (int)Math.ceil(y / 100.0 * n);
        need -= x;
        writer.println(need < 0 ? 0 : need);
    }

    void start() throws IOException {
        try {
            if(in.equals(""))
                reader = new BufferedReader(new InputStreamReader(System.in));
            else
                reader = new BufferedReader(new FileReader(in));

            if(out.equals(""))
                writer = new PrintWriter(new PrintStream(System.out));
            else
                writer = new PrintWriter(new FileWriter(out));

            solve();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            reader.close(); writer.close();
        }
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

    String nextToken() throws IOException {
        while(st == null || !st.hasMoreTokens())
            st = new StringTokenizer(reader.readLine());

        return st.nextToken();
    }
}