import java.io.*;
import java.math.*;
import java.util.*;
import static java.lang.Math.*;
public class C {
    public static class Fraction {
        public static int gcd(int a, int b){
            return b==0?a:gcd(b, a%b);
        }

        int a; // numerator
        int b; // denominator
        public Fraction(int a, int b) {
            if(b<0) {
                a = -a;
                b = -b;
            }
            int gcd = gcd(a, b);
            this.a = a/gcd;
            this.b = b/gcd;
        }

        public boolean equals(Object o) {
            if(!(o instanceof Fraction)) return false;
            Fraction r = (Fraction)o;
            return a==r.a&&b==r.b;
        }

        public int hashCode() {
            return a*31^b;
        }

        @Override public String toString() {
            return String.format("Fraction: %d / %d", a, b);
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    StringTokenizer st;
    StringBuilder buf = new StringBuilder();
    int rev(int i) {
        int r = 0;
        while(i!=0) {
            r = r*10+i%10;
            i /= 10;
        }
        return r;
    }
    void add(Map<Fraction, Integer> map, Fraction key, int addend) {
        Integer v = map.get(key);
        if(v==null)
            map.put(key, addend);
        else
            map.put(key, v+addend);
    }
    int get(Map<Fraction, Integer> map, Fraction key) {
        Integer v = map.get(key);
        if(v==null)
            return 0;
        return v;
    }
    public C() throws Exception {
        line = br.readLine();
        st = new StringTokenizer(line);
        int maxX = Integer.parseInt(st.nextToken());
        int maxY = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        Fraction[] fx = new Fraction[maxX+1];
        for (int x=1;x<=maxX;x++) {
            fx[x] = new Fraction(x, rev(x));
        }
        Fraction[] fy = new Fraction[maxY+1];
        for (int y=1;y<=maxY;y++) {
            fy[y] = new Fraction(rev(y), y);
        }
        Map<Fraction,Integer> xCount = new HashMap<Fraction,Integer>();
        for (int x=1;x<=maxX;x++) {
            add(xCount, fx[x], 1);
        }
        Map<Fraction,Integer> yCount = new HashMap<Fraction,Integer>();

        long min = Long.MAX_VALUE;
        int rx = -1;
        int ry = -1;
        int y = 0;
        int curW = 0;
        for (int x=maxX;x>=1;x--) {
            while(y<maxY&&curW<w) {
                y++;
                add(yCount, fy[y], 1);
                curW += get(xCount, fy[y]);
            }
            if(curW<w) break;
            if(min>(long)x*y) {
                min = (long)x*y;
                rx = x;
                ry = y;
            }
            add(xCount, fx[x], -1);
            curW -= get(yCount, fx[x]);
        }

        if(rx==-1) 
            buf.append(-1).append('\n');
        else
            buf.append(rx).append(' ').append(ry).append('\n');

        System.out.print(buf);
    }

    public static void main(String[] args) throws Exception { // {{{
        new C();
    } // }}}
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
}
