/*
[ ( ^ _ ^ ) ]
*/

// problem: cf/1334/D

// package cf.d;

import java.io.*;
import java.util.*;


public class d {
    int INF = (int)1e9;
    long MOD = 1000000007;



    void solve(InputReader in, PrintWriter out) throws IOException {
        long n = in.nextLong();
        long l = in.nextLong();
        long r = in.nextLong();

        long i = 1;
        long p = 0;
        while(i<n) {
            p += 2*(n-i);
            if(l<=p) {
                break;
            }
            i++;
        }
        long start = l - p + 2*(n-i);
        long j = i;
        p -= 2*(n-i);
        while(j<n) {
            p += 2*(n-j);
            if(r<=p) {
                break;
            }
            j++;
        }
        long end = r - p + 2*(n-j);
        if(i==n && j==n) {
            out.println(1);
            return;
        }
        boolean printone = false;
        if(j==n) {
            printone = true;
            j--;
            end = 2*(n-j);
        }
        // show("ij", i, start, j, end, printone);
        // show("start", start);
        while(true) {
            if(i>j) {
                break;
            }
            if(i==j && start>end) {
                break;
            }
            if(start>2*(n-i)) {
                start = 1;
                i++;
                continue;
            }
            if(start%2==1) {
                out.print(i+" ");
            } else {
                out.print(i+start/2+" ");
            }
            start++;
        }
        if(printone) out.print(1);
        out.println();
    }
    

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-- >0) {
            new d().solve(in, out);
        }
        out.close();
    }
    
    public static void show(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    static class InputReader {
        static BufferedReader br;
        static StringTokenizer st;
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
    }
}