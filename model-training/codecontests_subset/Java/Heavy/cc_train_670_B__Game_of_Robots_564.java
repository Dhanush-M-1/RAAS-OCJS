import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.math.BigInteger;
/**
 * Actual solution is at the top
 * @author Erasyl Abenov
 * 
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        try (PrintWriter out = new PrintWriter(outputStream)) {
            Task solver = new Task();
            solver.solve(1, in, out);
        }
    }
}
class Task {
    public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException{
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; ++i){
            a[i] = in.nextInt();
        }
        int sum = 1;
        long left = 1;
        long right = k;
        while(left < right){
            long mid = (left + right)/2;
            long cnt = (mid + 1)*mid/2;
            if(cnt > k) right = mid;
            else left = mid + 1;
        }
        sum = (int)left;
        if((long)sum*(sum + 1)/2 > k) sum--;
        k -= (long)sum*(sum + 1)/2;
        if(k == 0) k = sum;
        k = Math.max(0, --k);
        out.println(a[k]);
        
    }
}
class InputReader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
        
    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }
        
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public BigInteger nextBigInteger(){
        return new BigInteger(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
}