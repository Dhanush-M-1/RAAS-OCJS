import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        char[] c = in.next().toCharArray();
        int n = in.nextInt();
        boolean a, b1, b2 = a = b1 = false;
        for(int i = 0; i < n; i++) {
            char[] c2 = in.next().toCharArray();
            if(c[0] == c2[0] && c[1] == c2[1])
                a = true;
            if(c[0] == c2[1])
                b1 = true;
            if(c[1] == c2[0])
                b2 = true;
        }
        out.print(((a || (b1 && b2)) ? "YES" : "NO"));
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
        
        public String nextLine() throws IOException {
            if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            String r = st.nextToken("\n");
            st = new StringTokenizer(br.readLine(), " ");
            return r;
        }
        
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}