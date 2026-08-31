import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner s = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int n = s.nextInt(), m = 0;
        char[] c = s.next().toCharArray();
        for(int i = 0; i < n; i++)
            if(c[i] == '8')
                m++;
        out.print(Math.min(n / 11, m));
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