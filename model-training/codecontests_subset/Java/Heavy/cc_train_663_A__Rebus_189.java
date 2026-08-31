
/**
 *
 * @author sarthak
 */
import java.util.*;
import java.math.*;
import java.io.*;

public class rnd347_B {

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

    public static int num(String ss) {
        int tbr = 0;
        for (int i = ss.length() - 1; i >= 0; i--) {
            tbr += (ss.charAt(i) - '0') * Math.pow(10, ss.length() - 1 - i);
        }
        return tbr;
    }

    public static String tostr(int n) {
        String tbr = "";
        while (n != 0) {
            tbr = "" + n % 10 + "" + tbr;
            n = n / 10;
        }
        return tbr;
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

    public static void main(String[] args) {

        FastScanner s = new FastScanner(System.in);
        StringBuilder op = new StringBuilder();
        String ip = s.nextLine();
        char[] a=ip.toCharArray();
        int p=1;
        int n=0;
        for(char c:a)
        {
            if(c=='+')p++;
            if(c=='-')n++;
        }
        
     
        int N=num(ip.split(" ")[ip.split(" ").length-1]);
        if(!(N>=p-n*N && N<=p*N-n))
        {
            System.out.println("Impossible");
            return;
        }
        System.out.println("Possible");
        int cs=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]=='=')
                break;
            if(!(a[i]=='?'))
            {
                op.append(a[i]);continue;
            }
            int sign=1;
            if(i>0&&a[i-2]=='-')sign=-1;
            if(sign==1)p--;
            if(sign==-1)n--;
          for(int j=1;j<=N;j++){
                if((cs+j*sign +p-n*N)<=N && N<=(cs+j*sign+p*N-n))
                {
                    op.append(j + "");
                    cs+=j*sign;
                    break;
                    
                }
            }
            
        }
        
        op.append("= " + N);
        System.out.println(op);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
