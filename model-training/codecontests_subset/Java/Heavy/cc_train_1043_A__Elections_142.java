import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner s = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int n = s.nextInt(), max = 0, sum = 0, u;
        for(int i = 0; i < n; i++) {
            int a = s.nextInt();
            sum += a;
            max = Math.max(max, a);
        }
        u = 2 * sum - max * n;
        out.print(Math.max(max, max + u / n + (u == 0 ? 1 : u / Math.abs(u))));
        out.close();
    }

    static class Scanner {
        BufferedReader in;
        StringTokenizer s;
        
        public Scanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
            s = new StringTokenizer("");
        }
        
        public String next() throws IOException {
            if(!s.hasMoreTokens())
                s = new StringTokenizer(in.readLine());
            return s.nextToken();
        }
        
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}