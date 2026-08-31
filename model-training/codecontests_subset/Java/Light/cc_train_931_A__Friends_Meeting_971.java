import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static int sum(int n) {
        return ((n + 1) * n) / 2;
    }
    
    public static void main(String[] args) throws IOException {
        int n = Math.abs(in.nextInt() - in.nextInt()), m1 = n / 2, m2 = n - m1;
        out.print(sum(m1) + sum(m2));
        out.close();
    }
    
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;
        
        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }
        
        public String next() throws IOException {
            if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}