import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//     Test.testing();
        ConsoleIO io = new ConsoleIO();
        new Main(io).solve();
        io.close();
    }

    ConsoleIO io;

    Main(ConsoleIO io) {
        this.io = io;
    }

    ArrayList<ArrayList<Integer>> gr;
    boolean[] visit;

    class Edge {
        public Edge(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }

        public int u;
        public int v;
        public int c;
    }

    long MOD = 1_000_000_007;
    int N, M;
    long K;
    double[][] map;

    public void solve() {
        char[] s = io.readLine().toCharArray();
        int pos = 1;
        int neg = 0;
        int n = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '+')
                pos++;
            if (s[i] == '-')
                neg++;
            if (s[i] == '=') {
                n = Integer.parseInt(new String(s, i + 1, s.length - i - 1).trim());
            }
        }
        int lim = n;
        int min = (pos) - neg * n;
        int max = (pos) * n - neg;
        if (min > n || max < n) {
            io.writeLine("Impossible");
        } else {
            io.writeLine("Possible");
            StringBuilder sb = new StringBuilder();
            boolean p = true;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '?') {
                    if (p) {
                        if (pos + neg == 1) {
                            sb.append(n);
                        } else {
                            int tmax = (pos - 1) * lim - neg;
                            if (tmax < n) {
                                int t = Math.min(lim, n - tmax);
                                sb.append(t);
                                n -= t;
                            } else {
                                sb.append("1");
                                n -= 1;
                            }
                        }
                        pos--;
                    } else {
                        if (pos + neg == 1) {
                            sb.append(-n);
                        } else {
                            int tmin = (pos) - (neg - 1) * lim;
                            if (tmin > n) {
                                int t = Math.min(lim, tmin - n);
                                sb.append(t);
                                n += t;
                            } else {
                                sb.append("1");
                                n += 1;
                            }
                        }
                        neg--;
                    }
                } else {
                    if (s[i] == '-') p = false;
                    if (s[i] == '+') p = true;
                    sb.append(s[i]);
                }
            }
            io.writeLine(sb.toString());
        }
    }

    long gcd(long a, long b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

class ConsoleIO {
    BufferedReader br;
    PrintWriter out;
    public ConsoleIO(){br = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);}
    public void flush(){this.out.flush();}
    public void close(){this.out.close();}
    public void writeLine(String s) {this.out.println(s);}
    public void writeInt(int a) {this.out.print(a);this.out.print(' ');}
    public void writeWord(String s){
        this.out.print(s);
    }
    public int read(char[] buf, int len){try {return br.read(buf,0,len);}catch (Exception ex){ return -1; }}
    public String readLine() {try {return br.readLine();}catch (Exception ex){ return "";}}
    public long[] readLongArray() {
        String[]n=this.readLine().trim().split("\\s+");long[]r=new long[n.length];
        for(int i=0;i<n.length;i++)r[i]=Long.parseLong(n[i]);
        return r;
    }
    public int[] readIntArray() {
        String[]n=this.readLine().trim().split("\\s+");int[]r=new int[n.length];
        for(int i=0;i<n.length;i++)r[i]=Integer.parseInt(n[i]);
        return r;
    }
    public int[] readIntArray(int n) {
        int[] res = new int[n];
        char[] all = this.readLine().toCharArray();
        int cur = 0;boolean have = false;
        int k = 0;
        boolean neg = false;
        for(int i = 0;i<all.length;i++){
            if(all[i]>='0' && all[i]<='9'){
                cur = cur*10+all[i]-'0';
                have = true;
            }else if(all[i]=='-') {
                neg = true;
            }
            else if(have){
                res[k++] = neg?-cur:cur;
                cur = 0;
                have = false;
                neg = false;
            }
        }
        if(have)res[k++] = neg?-cur:cur;
        return res;
    }
    public int readInt() {
        try {
            int r = 0;
            boolean start = false;
            boolean neg = false;
            while (true) {
                int c = br.read();
                if (c >= '0' && c <= '9') {
                    r = r * 10 + c - '0';
                    start = true;
                } else if (!start && c == '-') {
                    start = true;
                    neg = true;
                } else if (start || c == -1) return neg ? -r : r;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    public long readLong() {
        try {
            long r = 0;
            boolean start = false;
            boolean neg = false;
            while (true) {
                int c = br.read();
                if (c >= '0' && c <= '9') {
                    r = r * 10 + c - '0';
                    start = true;
                } else if (!start && c == '-') {
                    start = true;
                    neg = true;
                } else if (start || c == -1) return neg ? -r : r;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    public String readWord() {
        try {
            boolean start = false;
            StringBuilder sb = new StringBuilder();
            while (true) {
                int c = br.read();
                if (c!= ' ' && c!= '\r' && c!='\n' && c!='\t') {
                    sb.append((char)c);
                    start = true;
                } else if (start || c == -1) return sb.toString();
            }
        } catch (Exception ex) {
            return "";
        }
    }
    public void writeIntArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {if (i > 0) sb.append(' ');sb.append(a[i]);}
        this.writeLine(sb.toString());
    }
}
class Pair {
    public Pair(int a, int b) {this.a = a;this.b = b;}
    public int a;
    public int b;
}
class Tri {
    public Tri(int a, int b, int c) {this.a = a;this.b = b;this.c = c;}
    public int a;
    public int b;
    public int c;
}
class PairLL {
    public PairLL(long a, long b) {this.a = a;this.b = b;}
    public long a;
    public long b;
}



