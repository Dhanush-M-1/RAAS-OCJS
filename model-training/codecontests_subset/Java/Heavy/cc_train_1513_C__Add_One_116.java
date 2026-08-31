import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int [] dp = new int[200015];
        int mod = 1000000007;
        for(int i=0; i<10; ++i) dp[i] = 1;
        for(int i=10; i<200015; ++i) dp[i] = (dp[i-10]+dp[i-9])%mod;

        AReader input = new AReader();
        AWriter output = new AWriter();
        int t = input.nextInt();
        for(int i=0; i<t; ++i){
            int n = input.nextInt();
            int m = input.nextInt();
            int ans = 0;
            for(char c: String.valueOf(n).toCharArray()){
                int cNum = c-'0';
                ans += dp[cNum+m];
                ans %= mod;
            }
            output.println(ans);
        }
    }

}

class AReader {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

class AWriter implements Closeable {
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) throws IOException {
        writer.write(object.toString());
        writer.flush();
    }

    public void println(Object object) throws IOException {
        writer.write(object.toString());
        writer.write("\n");
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}