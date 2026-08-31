
/*
 * @author romit17
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class D1008{
    
    void solve() throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("");
        int r,rr, astate;
        int a = 0, b = 0;
        boolean unknown = false;
        r = ask(a,b);
        if(r==0)
        {
            handleeq(a,b,29); return;
        }
        
        for(int i=29;i>=0;i--)
        {
            if(unknown)
            {
                r = ask(a,b);
                unknown = false;
                if(r==0)
                {
                    handleeq(a,b,i); return;
                }
            }
            
            rr = ask(a | 1<<i, b | 1<<i);
            if(r==1)//a is greater
            {
               if(rr == -1)
               {
                   a = a | 1 << i; unknown = true; continue;//r value unknown
               }
               rr = ask(a | 1<<i, b);
               if(rr==-1)
               {
                   a |= 1<<i;
                   b |= 1<<i;
               }
            }
            else
            {
                if(rr == 1)
                {
                    b |= 1<<i; unknown = true; continue;
                }
                rr = ask(a, b | 1<<i);
                if(rr == 1)
                {
                    a |= 1<<i;
                    b |= 1<<i;
                }
            }
        }
        System.out.println("! "+a+" "+b);
    }
    
    int ask(int a, int b)
    {
        System.out.println("? "+a+" "+b);
        return ni();
    }
    
    void handleeq(int a, int b, int ii)//from i inclusive equality starts
    {
        int r;
        for(int i=ii;i>=0;i--)
        {
            r = ask(a | 1<<i, b);
            if(r==-1)
            {
                a |= 1<<i;
                b |= 1<<i;
            }
        }
        System.out.println("! "+a+" "+b);
    }
    
    public static void main(String[] args) throws IOException {
        new D1008().solve();
    }    
    
    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;    
    InputStream is = System.in;

    private int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
        }
        return inbuf[ptrbuf++];
    }
    
    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }
    
    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }
    
    private double nd() {
        return Double.parseDouble(ns());
    }
    
    private char nc() {
        return (char) skip();
    }
    
    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = ns(m);
        }
        return map;
    }
    
    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }
    
    private int[] na1(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = ni();
        }
        return a;
    }
    
    private long[] nb(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nl();
        }
        return a;
    }
    
    private long[] nb1(int n) {
        long[] a = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = nl();
        }
        return a;
    }
    
    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
}
