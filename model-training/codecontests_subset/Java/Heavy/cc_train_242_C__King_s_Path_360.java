
/**
 *
 * @author sarthak
 */
import java.util.*;
import java.math.*;
import java.io.*;

public class rnd149_C {

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

        private int R, C;

        public P(int x, int y) {
            this.R = x;
            this.C = y;
        }

        public int hashCode() {
            return (R * 31) ^ C;
        }

        public boolean equals(Object o) {
            if (o instanceof P) {
                P other = (P) o;
                return (R == other.R && C == other.C);
            }
            return false;
        }

        public int compareTo(Object obj) {
            P l = (P) obj;
            if (this.R == l.R) {
                if (this.C == l.C) {
                    return 0;
                }
                return (this.C < l.C) ? -1 : 1;
            }
            return (this.R < l.R) ? -1 : 1;
        }
    }

   
    public static boolean  v(int r,int c){
        return (r>=1&&r<=1000000000)&&(c>=1&&c<=1000000000);
    }

    public static void main(String[] args) {

        FastScanner s = new FastScanner(System.in);
        StringBuilder op = new StringBuilder();
        int x0 = s.nextInt();
        int y0 = s.nextInt();
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int n = s.nextInt();
        HashSet<P> AV = new HashSet<>();
        while (n != 0) {

            int r = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            for (int i = a; i <= b; i++) {
                AV.add(new P(r, i));
            }
            n--;
        }

        HashMap<P, Long> DIS = new HashMap<>();
        HashSet<P> VIS = new HashSet<>();
        Queue<P> q = new LinkedList<>();
        if (AV.contains(new P(x0, y0))) {
            DIS.put(new P(x0, y0), 0L);
            VIS.add(new P(x0, y0));
            q.add(new P(x0, y0));
        }
        int x[] = {0,-1,-1,1,0,1,1,-1},y[] = {-1,-1,0,-1,1,1,0,1};

        while (!q.isEmpty()) {

            P p = q.poll();
            long d=DIS.get(p);
            for(int i=0;i<8;i++){
                int r=p.R+x[i];int c=p.C+y[i];
                P cp=new P(r,c);
                long dis=d+1;
                if(v(r,c)&&AV.contains(cp)){
                    if(!DIS.containsKey(cp))
                        DIS.put(cp, Long.MAX_VALUE);
                     long cd=DIS.get(cp);
                     DIS.put(cp,Math.min(cd, dis));
                    
                    if(!VIS.contains(cp)){
                        VIS.add(cp);q.add(cp);
                    }
                    
                    
                }
            }   
         
        }
        
        if(!DIS.containsKey(new P(x1,y1)))
             System.out.println(-1);
        else System.out.println(DIS.get(new P(x1,y1)));

    }

}
