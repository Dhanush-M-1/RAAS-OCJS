import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    static Main.MyScanner sc = new Main.MyScanner();
    // static Main.Parser sc = new Parser(System.in);
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), a = 0,b = 0,temp;
        for(int i = 0 ; i < n ; i++){
            temp = sc.nextInt();
            a ^= temp;
            b ^= temp;
        }
        for(int i = 1 ; i < n ; i++){
            temp = sc.nextInt();
            a ^= temp;
        }
        out.println(a);
        for(int i = 2 ; i < n ; i++){
            b ^= sc.nextInt();
        }
        out.println(a^b);
        
        out.close();
    }

    private static int foo(char c) {
        // TODO Auto-generated method stub
        if(c == 'Q' || c == 'q')
            return 9;
        if(c == 'r' || c == 'R')
            return 5;
        if(c == 'B' || c == 'b')
            return 3;
        if(c == 'N' || c == 'n')
            return 3;
        if(c == 'p' || c == 'P')
            return 1;
        return 0;
    }

    static private class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int mod(long x) {
            return (int) x % 1000000007;
        }

        public int mod(int x) {
            return x % 1000000007;
        }

        boolean hasNext() {
            if (st.hasMoreElements())
                return true;
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.hasMoreTokens();
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Parser {
        final private int BUFFER_SIZE = 65536; // 2^16, a good compromise for
                                                // some problems
        private InputStream din; // Underlying input stream
        private byte[] buffer; // Self-maintained buffer
        private int bufferPointer; // Current read position in the buffer
        private int bytesRead; // Effective bytes in the buffer read from the
                                // input stream

        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Read the next integer from the input stream.
         * 
         * @return The next integer.
         * @throws IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg)
                return -result;
            return result;
        }

        /**
         * Read the next byte of data from the input stream.
         * 
         * @return the next byte of data, or -1 if the end of the stream is
         *         reached.
         * @throws IOException
         *             if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * 
         * @throws IOException
         *             if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}