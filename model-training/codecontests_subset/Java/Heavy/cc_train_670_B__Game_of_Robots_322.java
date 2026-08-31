
/**
 *
 * @author sarthak
 */

import java.util.*;
import java.math.*;
import java.io.*;

public class rnd350_B {
    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    static class P implements Comparable {

        private int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return (x * 31) ^ y;
        }

        public boolean equals(Object o) {
            if (o instanceof P) {
                P other = (P) o;
                return (x == other.x && y == other.y);
            }
            return false;
        }

        public int compareTo(Object obj) {
            P l = (P) obj;
            if (this.x == l.x) {
                if (this.y == l.y) {
                    return 0;
                }
                return (this.y < l.y) ? -1 : 1;
            }
            return (this.x < l.x) ? -1 : 1;
        }
    }
    static class T {
        double f, s, t;
        public T(double f, double s, double t) {
            this.f = f;
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) {

        FastScanner s = new FastScanner(System.in);
        StringBuilder op = new StringBuilder();
        int n = s.nextInt();
        double k = s.nextDouble();
        int[] a = new int[n + 1];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            mp.put(i, s.nextInt());
        }
        T[] tm=new T[n+1];//terms
        tm[1]=new T(1.0,2.0,4.0);
        for(int i=2;i<=n;i++){
            double ft=tm[i-1].f+(double)i;
            double st=ft+(double)i+2.0-2.0;
            double tt=st+(double)i+3.0-2.0;
            tm[i]=new T(ft,st,tt);
        }
        
       T[] cf=new T[n+1];
       for(int i=1;i<=n;i++){
           double A=(tm[i].t-2.0*tm[i].s+tm[i].f)/2.0;
           double B=(8*tm[i].s-3*tm[i].t-5*tm[i].f)/2.0;
           double C=tm[i].f-A-B;
           cf[i]=new T(A,B,C);
       }
       
       for(int i=1;i<=n;i++){
           double n1=(-1.0*cf[i].s-(Math.sqrt(cf[i].s*cf[i].s-4*cf[i].f*cf[i].t+4*cf[i].f*k)) )/(2.0*(cf[i].f));
           double n2=(-1.0*cf[i].s+(Math.sqrt(cf[i].s*cf[i].s-4*cf[i].f*cf[i].t+4*cf[i].f*k)) )/(2.0*(cf[i].f));
           if( (n1>0 &&Math.floor(n1)==Math.ceil(n1)) || (n2>0 &&Math.floor(n2)==Math.ceil(n2)) ){
               System.out.println(mp.get(i));
               return;
           }
           
       }
       
       
       
       
    }

}
