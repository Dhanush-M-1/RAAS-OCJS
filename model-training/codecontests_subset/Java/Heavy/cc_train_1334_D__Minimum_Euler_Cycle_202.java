import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    long f(int n, int h){
        return (long) 2 * h * n - (long) h * (h + 1);
    }

    void solve2() {
        int n = in.nextInt();
        long l = in.nextLong();
        long r = in.nextLong();

        int h = 1;
        while(f(n,h)<l && h<n-1) h++;
        long tmp = l-f(n,h-1);
        boolean tt=tmp%2==1;
        long s = h+(tmp+1)/2;
        if (s==n+1){
            h = n;
        }

        r++;
        int fh = 1;
        while(f(n,fh)<r && fh<n-1) fh++;
        tmp = r-f(n,fh-1);
        boolean ftt=tmp%2==1;
        long fs = fh+(tmp+1)/2;
        if (fs==n+1){
            fh = n;
        }

        while(true){
            if (h==fh && tt==ftt && s==fs){
                break;
            }
            if (h == n) {
                out.print(1);
                break;
            }
            if (tt) {
                out.print(h+" ");
                tt = false;
            }else {
                out.print(s+" ");
                s++;
                if (s == n + 1) {
                    h++;
                    s = h + 1;
                }
                tt = true;
            }
        }
        out.println();
    }

    void solve() {
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            solve2();
        }
    }

    // --------------------SCANNER-------------------------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(boolean debug) {
            if (debug) {
                try {
                    br = new BufferedReader(new FileReader("input.txt"));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextInts(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                String line = br.readLine();
                if (line == null) {
                    throw new RuntimeException("empty line");
                }
                return line;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // --------------------WRITER-------------------------
    public static class MyWriter extends PrintWriter {

        public MyWriter(OutputStream out) {
            super(out);
        }

        void println(int[] arr) {
            String line = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            println(line);
        }

    }
    // --------------------MAIN-------------------------

    public MyScanner in;
    public MyWriter out;

    public static void main(String[] args) {
        Main m = new Main();
        m.in = new MyScanner(args.length > 0);
        m.out = new MyWriter(new BufferedOutputStream(System.out));
        m.solve();
        m.out.close();
    }
}
