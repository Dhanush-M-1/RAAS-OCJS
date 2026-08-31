
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Phan
 */
public class b {
    
    public static void main(String[] args) {
        FS in = new FS(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        boolean[][] num = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            char[] arr = in.next().toCharArray();
            for(int j = 0; j < n/4; j++) {
                int val;
                if(Character.isAlphabetic(arr[j])) val = arr[j]-'A'+10;
                else val = arr[j]-'0';
                for(int k = 0; k < 4; k++) num[i][j*4+k] = (val&(1<<(4-k-1))) != 0;
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            int curr = 1;
            for(int j = 1; j < n; j++) if(num[i][j] != num[i][j-1]) {
                res = gcd(res, curr);
                curr = 1;
            } else curr++;
            res = gcd(res, curr);
        }
        
        
        for(int i = 0; i < n; i++) {
            int curr = 1;
            for(int j = 1; j < n; j++) if(num[j][i] != num[j-1][i]) {
                res = gcd(res, curr);
                curr = 1;
            } else curr++;
            res = gcd(res, curr);
        }
        System.out.println(res);
        
        out.close();
    }
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    
    static class FS {

        BufferedReader in;
        StringTokenizer token;

        public FS(InputStream str) {
            in = new BufferedReader(new InputStreamReader(str));
        }

        public String nextLine() {
            token = new StringTokenizer("");
            try {
                return in.readLine();
            } catch (Exception e) {
                return null;
            }
        }

        public String next() {
            if (token == null || !token.hasMoreElements()) {
                try {
                    token = new StringTokenizer(in.readLine());
                } catch (IOException ex) {
                }
                return next();
            }
            return token.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
