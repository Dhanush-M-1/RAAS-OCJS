
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Runnable{

    public void solve() throws IOException {
        int l = nextInt();
        int r = nextInt();
        
        System.out.println((l==r?l:2));
    }

    public static void main(String[] args) {
        new Main().run();
    }
    
    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;
    
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
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
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }    
}