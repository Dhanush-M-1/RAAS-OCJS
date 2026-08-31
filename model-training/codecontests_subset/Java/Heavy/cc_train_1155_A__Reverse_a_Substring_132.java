import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
/* * */

public class E63_A implements Runnable{
    public static void main(String[] args) {
	    new Thread(null, new E63_A(),"Main",1<<27).start();
    }
    @Override
    public void run() {
        FastReader fd = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = fd.nextInt();
        char[] data = fd.next().toCharArray();
        for(int i = 0; i < data.length-1; i++) {
            if(data[i] > data[i+1]) {
                out.println("YES\n"+(i+1)+" "+(i+2));
                out.close();
                return;
            }
        }
        out.println("NO");
        out.close();
    }

    //Helper functions
    static int[] getArray(int n,boolean isSorted, FastReader fd){
        int[] data = new int[n];
        for(int i = 0; i < data.length; i++){ data[i] = fd.nextInt(); }
        if(isSorted) Arrays.sort(data);
        return data;
    }
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static void dfs(ArrayList<ArrayList<Integer>> g, boolean[] visited, int i, int N){
        for(Integer e: g.get(i)){
            if(!visited[e]){
                visited[e]=true;
                dfs(g,visited,e,N);
                //operations to be performed...
            }
        }
    }
    static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }

    static boolean checkDistinct(int next){// check all digits are distinct.

        String process = String.valueOf(next);
        for(int i = 0;i < process.length()-1; i++){
            String character = String.valueOf(process.charAt(i));
            if(process.substring(i+1).contains(character)){ return false; }
        }
        return true;
    }

    static int limit = (int) 1e7 + 1;
    static int[] facts = new int[limit];
    static void sieve() {  // Store the minimum prime factors of 1 to LIMIT
        facts[1] = 1;
        for (int i = 2; i < limit; i++) {
            if (i % 2 == 0 && i > 2) {
                facts[i] = 2;
            } else {
                facts[i] = i;
            }
        }
        for (int i = 3; i * i < limit; i++) {
            if (facts[i] == i) {
                for (int j = i * i; j < limit; j += i)
                    if (facts[j] == j)
                        facts[j] = i;
            }
        }
    }
    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
