
import java.io.*;
import java.util.*;

public class Main {
    private static Scanner sc;
    private static Printer pr;
    static long aLong=(long )1e9+7;
    static long Mod=998244353;
    static ArrayList<Integer>[]list;
    static boolean[]vis1;
    static int []input;
    private static void solve() throws IOException {
        //in the name of god
        // you are anything and we are nothing
        // khodaya khieli chakretim
        // ya ali
        int n=sc.nextInt(),m=sc.nextInt();
        list=new ArrayList[n+1];
        input=new int[n+1];
        for (int i=1;i<=n;++i)
            input[i]=sc.nextInt();
        for (int i=1;i<=n;++i)
            list[i]=new ArrayList<>();
        vis1=new boolean[n+1];
        while (m-->0){
            int u=sc.nextInt(),v=sc.nextInt();
            list[u].add(v);
            list[v].add(u);
        }
        for (int i=1;i<=n;++i){
            if (!vis1[i]) {
                ArrayList<Integer>path=new ArrayList<>();
                dfs_1(i,path);
                ArrayList<Integer>val=new ArrayList<>();
                for (int j=0;j<path.size();++j)
                    val.add(input[path.get(j)]);
                Collections.sort(path);
                Collections.sort(val,Collections.reverseOrder());
                for (int j=0;j<path.size();++j)
                    input[path.get(j)]=val.get(j);
            }
        }
        for (int i=1;i<=n;++i)
            pr.print(input[i]+" ");
    }
    public static void dfs_1(int src,ArrayList<Integer>path){
        vis1[src]=true;
        path.add(src);
        for (int v:list[src]){
            if (!vis1[v])
                dfs_1(v,path);
        }
    }
    public static int[] radixSort(int[] f) {
        int[] to = new int[f.length];
        {
            int[] b = new int[65537];
            for (int i = 0; i < f.length; i++) b[1 + (f[i] & 0xffff)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < f.length; i++) to[b[f[i] & 0xffff]++] = f[i];
            int[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < f.length; i++) b[1 + (f[i] >>> 16)]++;
            for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
            for (int i = 0; i < f.length; i++) to[b[f[i] >>> 16]++] = f[i];
            int[] d = f;
            f = to;
            to = d;
        }
        return f;
    }
    public static long []primeFactor(int n){
        long []prime=new long[n+1];
        prime[1]=1;
        for (int i=2;i<=n;i++)
            prime[i]=((i&1)==0)?2:i;
        for (int i=3;i*i<=n;i++){
            if (prime[i]==i){
                for (int j=i*i;j<=n;j+=i){
                    if (prime[j]==j)
                        prime[j]=i;
                }
            }
        }
        return prime;
    }
    public static long gcd(long a,long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        pr = new Printer(System.out);
        solve();

        pr.close();
        // sc.close();
    }
    private static class Scanner {
        BufferedReader br;

        Scanner (InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        private boolean isPrintable(int ch) {
            return ch >= '!' && ch <= '~';
        }

        private boolean isCRLF(int ch) {
            return ch == '\n' || ch == '\r' || ch == -1;
        }

        private int nextPrintable() {
            try {
                int ch;
                while (!isPrintable(ch = br.read())) {
                    if (ch == -1) {
                        throw new NoSuchElementException();
                    }
                }

                return ch;
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        String next() {
            try {
                int ch = nextPrintable();
                StringBuilder sb = new StringBuilder();
                do {
                    sb.appendCodePoint(ch);
                } while (isPrintable(ch = br.read()));

                return sb.toString();
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        int nextInt() {
            try {
                // parseInt from Integer.parseInt()
                boolean negative = false;
                int res = 0;
                int limit = -Integer.MAX_VALUE;
                int radix = 10;

                int fc = nextPrintable();
                if (fc < '0') {
                    if (fc == '-') {
                        negative = true;
                        limit = Integer.MIN_VALUE;
                    } else if (fc != '+') {
                        throw new NumberFormatException();
                    }
                    fc = br.read();
                }
                int multmin = limit / radix;

                int ch = fc;
                do {
                    int digit = ch - '0';
                    if (digit < 0 || digit >= radix) {
                        throw new NumberFormatException();
                    }
                    if (res < multmin) {
                        throw new NumberFormatException();
                    }
                    res *= radix;
                    if (res < limit + digit) {
                        throw new NumberFormatException();
                    }
                    res -= digit;

                } while (isPrintable(ch = br.read()));

                return negative ? res : -res;
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        long nextLong() {
            try {
                // parseLong from Long.parseLong()
                boolean negative = false;
                long res = 0;
                long limit = -Long.MAX_VALUE;
                int radix = 10;

                int fc = nextPrintable();
                if (fc < '0') {
                    if (fc == '-') {
                        negative = true;
                        limit = Long.MIN_VALUE;
                    } else if (fc != '+') {
                        throw new NumberFormatException();
                    }
                    fc = br.read();
                }
                long multmin = limit / radix;

                int ch = fc;
                do {
                    int digit = ch - '0';
                    if (digit < 0 || digit >= radix) {
                        throw new NumberFormatException();
                    }
                    if (res < multmin) {
                        throw new NumberFormatException();
                    }
                    res *= radix;
                    if (res < limit + digit) {
                        throw new NumberFormatException();
                    }
                    res -= digit;

                } while (isPrintable(ch = br.read()));

                return negative ? res : -res;
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                int ch;
                while (isCRLF(ch = br.read())) {
                    if (ch == -1) {
                        throw new NoSuchElementException();
                    }
                }
                StringBuilder sb = new StringBuilder();
                do {
                    sb.appendCodePoint(ch);
                } while (!isCRLF(ch = br.read()));

                return sb.toString();
            } catch (IOException e) {
                throw new NoSuchElementException();
            }
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
//				throw new NoSuchElementException();
            }
        }
    }
    private static class Printer extends PrintWriter {
        Printer(PrintStream out) {
            super(out);
        }
    }
}