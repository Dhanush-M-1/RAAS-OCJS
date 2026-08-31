import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.InputStreamReader;

import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        String str1 = in.next(), str2 = in.next();
        out.println(str1 + " " + str2);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            if(str1.equals(in.next()))
                str1 = in.next();
            else
                str2 = in.next();
            out.println(str1 + " " + str2);
        }
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