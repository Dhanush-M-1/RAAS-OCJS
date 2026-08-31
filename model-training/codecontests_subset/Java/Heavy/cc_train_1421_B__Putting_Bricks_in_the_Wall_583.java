import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = 0;
        if(type == 0) T = fs.nextInt();
        else if(type == 1) T = 1;
        for(int t=0;t<T;t++) algo(fs);
    }

    static int type = 0; // 0 - known tcs, 1 - only 1 tcs

    public static void algo(FastScanner fs) {
        int N = fs.nextInt();
        int[] A = new int[4];
        for(int i=0;i<N;i++) {
            String s = fs.next();
            if(i == 0) A[0] = s.charAt(1) - '0';
            if(i == 1) A[1] = s.charAt(0) - '0';
            if(i == N-2) A[2] = s.charAt(N-1) - '0';
            if(i == N-1) A[3] = s.charAt(N-2) - '0';
        }
        if(A[0] == A[1]) {
            if(A[2] == A[3]) {
                if(A[0] != A[2]) {
                    System.out.println(0);
                }
                else {
                    System.out.println(2);
                    System.out.println("1 2");
                    System.out.println("2 1");
                }
            }
            else {
                if(A[0] == A[2]) {
                    System.out.println(1);
                    System.out.println((N-1) + " " + N);
                }
                else if (A[0] == A[3]) {
                    System.out.println(1);
                    System.out.println(N + " " + (N-1));
                }
            }
        }
        else if(A[2] == A[3]) {
            if(A[0] == A[1]) {
                if(A[0] != A[2]) {
                    System.out.println(0);
                }
                else {
                    System.out.println(2);
                    System.out.println("1 2");
                    System.out.println("2 1");
                }
            }
            else {
                if(A[2] == A[0]) {
                    System.out.println(1);
                    System.out.println(1 + " " + 2);
                }
                else if (A[2] == A[1]) {
                    System.out.println(1);
                    System.out.println(2 + " " + 1);
                }
            }
        }
        else {
            System.out.println(2);
            if(A[0] == 0) System.out.println(1 + " " + 2);
            if(A[1] == 0) System.out.println(2 + " " + 1);
            if(A[2] == 1) System.out.println((N-1) + " " + (N));
            if(A[3] == 1) System.out.println((N) + " " + (N-1));
        }
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
