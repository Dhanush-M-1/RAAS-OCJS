import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.Math.*;

public class Main{
    
    ArrayList< ii > factor(long x){
        ArrayList< ii > ret = new ArrayList< ii >();
        for(long i=2; i*i<=x; ++i) if(x%i == 0){
            int contains = 0;
            while(x%i == 0){
                ++contains;
                x /= i;
            }
            ret.add(new ii(i, contains));
        }
        if(x!=1)
            ret.add(new ii(x, 1));
        return ret;
    }

    public void go(){
        long ret = Long.parseLong(sc.nextToken());

        ArrayList< ii > a = factor(ret);

        int sumP = 0;
        for(ii i : a) sumP += i.y;

        if(sumP < 2){
            System.out.printf("1\n0\n");
            return;
        }

        if(sumP == 2){
            System.out.printf("2\n");
            return;
        }

        ret = a.get(0).x;
        if(a.get(0).y>1)
            ret *= a.get(0).x;
        else
            ret *= a.get(1).x;
        System.out.printf("1\n%d\n", ret);

    }

    // syntax
    // ArrayList<Integer>[] myMat = (ArrayList<Integer>[]) new ArrayList[nB];

    // Pairs
    public class ii implements Comparable< ii >{
        long x, y;
        public ii(){}
        public ii(long xx, long yy){ x=xx; y=yy; }
        public int compareTo(ii p){ return 1; } //x!=p.x ? x-p.x : y-p.y; }
        // public int hashCode(){ return 31*x+y; }
        public boolean equals(Object o){
            if(!(o instanceof ii)) return false;
            ii p = (ii) o;
            return x==p.x && y==p.y;
        }
        public String toString(){ return "("+x+", "+y+")"; }
    }
/*
    public class pair< X extends Comparable< X >,Y extends Comparable< Y > > implements Comparable< pair< X,Y > >{
        X x;
        Y y;
        public pair(){}
        public pair(X xx, Y yy){ x=xx; y=yy; }
        public int compareTo(pair< X,Y > p){ return x.compareTo(p.x)!=0 ? x.compareTo(p.x) : y.compareTo(p.y); }
        public int hashCode(){ return 31*x.hashCode()+y.hashCode(); }
        public boolean equals(Object o){
            if((o.getClass() != this.getClass())) return false;
            pair< X,Y > p = (pair< X,Y >) o;
            return x.equals(p.x) && y.equals(p.y);
        }
        public String toString(){ return "("+x+", "+y+")"; }
    }
*/
    // my stuff
    public static final int INF = 1000*1000*1000+7;
    public static final double EPS = 1e-9;
    public static final double PI = 2*acos(0.0);
    public void rev(Object[] a){ for(int i=0; i<a.length/2; ++i){ Object t=a[i]; a[i]=a[a.length-1-i]; a[a.length-1-i]=t; } }
    public void rev(int[] a){ for(int i=0; i<a.length/2; ++i){ int t=a[i]; a[i]=a[a.length-1-i]; a[a.length-1-i]=t; } }
    public int bit_count(long x){ return x==0 ? 0 : 1+bit_count(x&(x-1)); }
    public int low_bit(int x){ return x&-x; } // 0011 0100 returns 0000 0100
    public int sign(int x){ return x<0 ? -1 : x>0 ? 1 : 0; }
    public int sign(double x){ return x<-EPS ? -1 : x>EPS ? 1 : 0; }
    int[] unpack(ArrayList< Integer > a){
        int[] ret = new int[a.size()];
        for(int i=0; i<a.size(); ++i) ret[i] = a.get(i);
        return ret;
    }

    // generic main stuff
    static myScanner sc;
    static PrintWriter pw;
    static long startTime;
    public static void main(String[] args) throws Exception{
        // sc = new Scanner(System.in);
        sc = (new Main()).new myScanner(new BufferedReader(new InputStreamReader(System.in)));
        pw = new PrintWriter(System.out);
        startTime = System.nanoTime();
        (new Main()).go();
        // errprintln("nanoTime="+(System.nanoTime()-startTime)/1000000/1000.0);
        pw.flush();
        System.exit(0);
    }

    // capable of reading   2.86M 6dp doubles per second
    //                      2.16M 12dp doubles per second
    //                      2.75M int per second
    public class myScanner{
        private BufferedReader f;
        private StringTokenizer st;
        public myScanner(BufferedReader ff){ f=ff; st=new StringTokenizer(""); }
        public int nextInt(){ return Integer.parseInt(nextToken()); }
        public double nextDouble(){ return Double.parseDouble(nextToken()); }
        public String nextLine(){
            st=new StringTokenizer("");
            String ret="";
            try{ ret=f.readLine(); }catch(Exception e){}
            return ret;
        }
        public String nextToken(){
            while(!st.hasMoreTokens()) try{ st=new StringTokenizer(f.readLine()); } catch(Exception e){}
            return st.nextToken();
        }
    }


}
