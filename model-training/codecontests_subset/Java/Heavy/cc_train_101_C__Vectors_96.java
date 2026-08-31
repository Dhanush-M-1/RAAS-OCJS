import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Comparator;
import java.util.TreeSet;

public class E {
    private static StreamTokenizer in;
    private static PrintWriter out;
    private static BufferedReader inB;
    
    private static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    
    private static String nextString() throws Exception{
        in.nextToken();
        return in.sval;
    }
    
    static{
        inB = new BufferedReader(new InputStreamReader(System.in));
        in = new StreamTokenizer(inB);
        out = new PrintWriter(System.out);
    }
    
    public static void main(String[] args)throws Exception {
        Complex A = new Complex(nextInt(), nextInt());
        Complex B = new Complex(nextInt(), nextInt());
        Complex C = new Complex(nextInt(), nextInt());
        
        boolean was = false;
        for(int i = 0; i<4; i++) {
            Complex cur = B.sub(A.mul(powi(i)));
            if(C.equals(Complex.z)) {
                if(cur.equals(Complex.z))was = true;
            } else {
                if(check(cur, C))was = true;
            }
        }
        
        System.out.println(was ? "YES" : "NO");
    }
    
    private static Complex powi(int n) {
        Complex ans = new Complex(1, 0);
        for(int i = 0; i<n; i++) {
            ans = ans.mul(Complex.i);
        }
        return ans;
    }
    
    private static boolean check(Complex cur, Complex C) {
        Complex tmp = cur.mul(new Complex(C.x, -C.y));
        long m = C.mod();
        return tmp.x % m == 0 && tmp.y % m == 0;
    }
}

class Complex {
    long x, y;
    
    Complex(long x, long y) {
        this.x = x;
        this.y = y;
    }
    
    Complex add(Complex c) {
        return new Complex(c.x + x, c.y + y);
    }
    
    Complex mul(Complex c) {
        return new Complex(c.x*x - c.y*y, c.x*y + c.y*x);
    }
    
    Complex sub(Complex c) {
        return add(c.mul(new Complex(-1,0)));
    }
    
    boolean equals(Complex c) {
        return x == c.x && y == c.y;
    }
    
    long mod() {
        return x*x + y*y;
    }
    
    public String toString() {
        return x + " " + y;
    }
    
    public static final Complex i = new Complex(0, 1);
    public static final Complex z = new Complex(0, 0);
}