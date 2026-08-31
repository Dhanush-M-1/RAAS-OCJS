
import java.math.*;
import java.util.*;
import java.io.*;
public class Main{
    static StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc=new Scanner(System.in);
    static PrintWriter out=new PrintWriter(System.out);
    //static InputReader sc=new InputReader(System.in);
    static final int inf=10000000;
    public static void main(String args[])throws Exception {
        long mod=998244353;
        int n=getInt();
        int digs[]=new int[15];
        long arr[]=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=getInt();
            digs[len(arr[i])]++;
        }
        long ans=0;

        for(int i=0;i<n;i++){
            long k1[]=new long[15];
            long k2[]=new long[15];
            for(int j=0;j<15;j++){
                k1[j]=1;
                k2[j]=10;
            }
            int p=0;
            long q=0;
            while(arr[i]!=0){
                p++;
                long w=(arr[i])%10;
                for(int j=1;j<=10;j++){
                    q+=digs[j]*k1[j]*w;
                    q+=digs[j]*k2[j]*w;
                    q%=mod;
                }
                for(int j=1;j<p;j++){
                    k1[j]*=10;
                    k1[j]%=mod;
                }
                for(int j=p;j<15;j++){
                    k1[j]*=100;
                    k1[j]%=mod;
                }
                for(int j=1;j<=p;j++){
                    k2[j]*=10;
                    k2[j]%=mod;
                }
                for(int j=p+1;j<15;j++){
                    k2[j]*=100;
                    k2[j]%=mod;
                }
                arr[i]/=10;
            }
            ans+=q;
            ans%=mod;
        }
        System.out.println(ans);
    }
    static int len(long x){
        String s=x+"";
        return s.length();
    }
    static void ssort(int arr[]){
        int len=arr.length;
        for(int i=0;i<len;i++){
            int t=(int)(len*Math.random());
            int temp=arr[t];
            arr[t]=arr[i];
            arr[i]=temp;
        }
        Arrays.sort(arr);
    }
    static int getInt()throws Exception{
        in.nextToken();
        return  (int)in.nval;
    }
}

class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;
    public InputReader(InputStream st) {
        this.stream = st;
    }
    public int read() {
        if (snumChars == -1)
            throw new InputMismatchException();
        if (curChar >= snumChars) {
            curChar = 0;
            try {
                snumChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (snumChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

}
