import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main{

    void solve(){
        String N = ns();
        int K = ni();
        int firstnonzero = Integer.valueOf(N.substring(0,1));
        int secondnonzero = -1;
        int secondnonzeroindex = 0;
        int thirdnonzero = -1;
        int thirdnonzeroindex = 0;
        for(int i=1; i<N.length(); i++){
            if(N.charAt(i)!='0'){
                if(secondnonzero == -1){
                    secondnonzero = Integer.valueOf(N.substring(i,i+1));
                    secondnonzeroindex = i;
                }else{
                    thirdnonzero = Integer.valueOf(N.substring(i,i+1));
                    thirdnonzeroindex = i;
                    break;
                }
            }
        }
        
        long ans = 0;
        if(K == 1){
            ans += 9*(N.length()-1);
            ans += Integer.valueOf(N.substring(0, 1));
        }else if(K==2){
            if(N.length()>=3){
                ans += 9*9*(N.length()-1)*(N.length()-2)/2;
            }
            if(N.length()>=2){
                ans += (firstnonzero-1)*9*(N.length()-1);
                if(secondnonzero != -1){
                    ans += secondnonzero;
                    ans += 9*(N.length()-secondnonzeroindex-1);
                }
            }
        }else if(K==3){
            if(N.length()>=4){
                ans += 9*9*9*(N.length()-1)*(N.length()-2)*(N.length()-3)/6;
            }
            if(N.length()>=3){
                ans += (firstnonzero-1) *9*9*(N.length()-1)*(N.length()-2)/2;
                if(secondnonzero != -1){
                    if(N.length()-secondnonzeroindex-1>=2){
                        ans += 9*9*(N.length()-secondnonzeroindex-1)*(N.length()-secondnonzeroindex-2)/2;
                    }
                    ans += (secondnonzero-1) * 9 * (N.length()-secondnonzeroindex-1);
                    if(thirdnonzero != -1){
                        ans += thirdnonzero;
                        ans += 9*(N.length()-thirdnonzeroindex-1);
                    }
                }
            }
        }


        out.println(ans);
        out.flush();
    } 


    public static void main(String[] args){
        Main m = new Main();
        m.solve();
    }

    Main(){
        this.scan = new FastScanner();
        this.out = new PrintWriter(System.out);
    }

    private FastScanner scan;
    private PrintWriter out;
    private final int MOD = 1_000_000_007;
    private final int INF = 2_147_483_647;
    private final long LINF = 9223372036854775807L;

    // Scanner
    int ni(){ return scan.nextInt();}
    int[] ni(int n){int[] a = new int[n]; for(int i = 0; i < n; i++){a[i] = ni();} return a;}
    int[][] ni(int y, int x){int[][] a = new int[y][x];
        for(int i = 0; i < y; i++){for(int j = 0; j < x; j++){a[i][j] = ni();}} return a;}
    long nl(){return scan.nextLong();}
    long[] nl(int n){long[] a = new long[n]; for(int i = 0; i < n; i++){a[i] = nl();} return a;}
    long[][] nl(int y, int x){long[][] a = new long[y][x];
        for(int i = 0; i < y; i++){for(int j = 0; j < x; j++){a[i][j] = nl();}} return a;}
    String ns(){return scan.next();}
    String[] ns(int n){String[] a = new String[n]; for(int i = 0; i < n; i++){a[i] = ns();} return a;}
    String[][] ns(int y, int x){String[][] a = new String[y][x];
        for(int i = 0; i < y; i++){for(int j = 0; j < x; j++){a[i][j] = ns();}} return a;}
}
class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;
    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        }else{
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }
    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
    public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return minus ? -n : n;
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
    public int nextInt() {
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
        return (int) nl;
    }
    public double nextDouble() { return Double.parseDouble(next());}
}
