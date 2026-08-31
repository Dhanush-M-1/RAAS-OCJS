import java.util.*;
import java.math.*;
import java.io.*;
import java.util.Collections;

public class Solution {

    static class Solver {

        Solver() {
        }

        public void solve(FastScanner sc, PrintWriter out) throws IOException {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] arr = new int[b+1];
            while(a-- > 0) {
                int n = sc.nextInt();
                for(int i = 0; i < n; i++) {
                    int x = sc.nextInt();
                    arr[x]++;
                }
            }

            boolean f = true;
            for(int i = 1; i < arr.length && f; i++) {
                if(arr[i] == 0) {
                    f = false;
                }
            }

            out.println(f ? "YES" : "NO");
            out.flush();
        }
    } 


    
    public static void main(String[] args) throws IOException{
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        (new Solver()).solve(scanner, out);
        out.flush();

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        boolean hasNextToken() {
            if(st == null) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    
                }
            }
            return st.hasMoreTokens();
        } 

        String next() {
            while(st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        String nextLine() throws IOException{
            return br.readLine();
        }

        byte nextByte() {
            return Byte.parseByte(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }

}

