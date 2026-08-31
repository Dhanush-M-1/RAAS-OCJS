import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
    
    public void solve() {
        InputReader in = new InputReader();
        int n = in.nextInt();
        int k = in.nextInt();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
        		int t = in.nextInt();
        		if(k%t == 0) {
        			if(k/t < min) {
        				min = k/t;
        			}
        		}
        }
        System.out.println(min);
    }
 
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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
 
    }
}