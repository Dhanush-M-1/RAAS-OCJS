import java.io.BufferedReader;

import java.io.PrintWriter;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int n = in.nextInt(), k = in.nextInt(), i = 1, t = in.nextInt();
        while(i < k)
            k -= i++;
        for(i = 1; i < k; i++)
            t = in.nextInt();
        out.print(t);
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
            while(!st.hasMoreTokens())
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