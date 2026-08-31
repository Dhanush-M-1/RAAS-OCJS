import java.io.*;
import java.util.*;

public class Solution {
    StreamTokenizer in;
    PrintWriter out;
    int a;
    int b;
    float remainder = 0;
    int result;
    
    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
    
    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
    
    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
    
    void solve() throws IOException {
        result = 0;
        a = nextInt();
        b = nextInt();
        // List<Integer> score = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
            // score.add(nextInt());
        // }
        candleFire(a);
        out.print(result);
    }
    
    void candleFire(int candleCount) {
        result += candleCount;
        remainder += candleCount;
        candleCount = (int) remainder / b;
        remainder = remainder % b;
        
        if (candleCount >= 1) 
            candleFire(candleCount);
    }
}