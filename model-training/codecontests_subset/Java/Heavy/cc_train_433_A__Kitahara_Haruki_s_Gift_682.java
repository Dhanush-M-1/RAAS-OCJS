import java.lang.Math;
import java.io.*;
import java.util.*;
public class Main {
        String INPUT = "";
        void solve()
        {
                int n = i();
                int a= 0,b=0;
                int[] set = new int[n];
                for (int i = 0; i < n; i++) {
                        int x = i();
                        set[i] = x;
                        if(x==200) b++;
                        else a++;
                }
                int sum = 100*a+200*b;
                if(sum%200!=0) {
                        out.println("NO");
                        return;
                }
                if(findSum(set,n,sum/2)){
                        out.println("YES");
                }else {
                        out.println("NO");
                }
        }
        private boolean findSum(int[] set,int n,int sum) {
                boolean[][] par = new boolean[sum+1][n+1];
                for (int i = 0; i <=n  ; i++) {
                        par[0][i] = true;
                }
                for (int i = 0; i <=sum; i++) {
                        par[i][0] = false;
                }
                for (int i = 1; i <= sum  ; i++) {
                        for (int j = 1; j <=n; j++) {
                                par[i][j] = par[i][j-1];
                                if(i>=set[j-1])
                                {
                                        par[i][j] = par[i][j-1]||par[i-set[j-1]][j-1];
                                }
                        }
                }
                return par[sum][n];
        }
        void run() throws Exception{
                is = System.in;
                out = new PrintWriter(System.out);
                solve();
                out.flush();
        }
        public static void main(String[] args)throws Exception {
                new Main().run();
        }
        InputStream is;
        PrintWriter out;
        private byte[] inbuf = new byte[1024];
        public int lenbuf = 0, ptrbuf = 0;

        private int readByte()
        {
                if(lenbuf == -1)throw new InputMismatchException();
                if(ptrbuf >= lenbuf){
                        ptrbuf = 0;
                        try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
                        if(lenbuf <= 0)return -1;
                }
                return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
        private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

        private double d() { return Double.parseDouble(s()); }
        private char c() { return (char)skip(); }

        private String s()
        {
                int b = skip();
                StringBuilder sb = new StringBuilder();
                while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
                        sb.appendCodePoint(b);
                        b = readByte();
                }
                return sb.toString();
        }

        private char[] sa(int n)
        {
                char[] buf = new char[n];
                int b = skip(), p = 0;
                while(p < n && !(isSpaceChar(b))){
                        buf[p++] = (char)b;
                        b = readByte();
                }
                return n == p ? buf : Arrays.copyOf(buf, p);
        }

        private char[][] nm(int n, int m)
        {
                char[][] map = new char[n][];
                for(int i = 0;i < n;i++)map[i] = sa(m);
                return map;
        }

        private int[] ia(int n)
        {
                int[] a = new int[n];
                for(int i = 0;i < n;i++)a[i] = i();
                return a;
        }

        private int i()
        {
                int num = 0, b;
                boolean minus = false;
                while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
                if(b == '-'){
                        minus = true;
                        b = readByte();
                }

                while(true){
                        if(b >= '0' && b <= '9'){
                                num = num * 10 + (b - '0');
                        }else{
                                return minus ? -num : num;
                        }
                        b = readByte();
                }
        }

        private long l()
        {
                long num = 0;
                int b;
                boolean minus = false;
                while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
                if(b == '-'){
                        minus = true;
                        b = readByte();
                }

                while(true){
                        if(b >= '0' && b <= '9'){
                                num = num * 10 + (b - '0');
                        }else{
                                return minus ? -num : num;
                        }
                        b = readByte();
                }
        }


}
