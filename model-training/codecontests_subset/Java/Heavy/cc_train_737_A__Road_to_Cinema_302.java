import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;

public class A {
    static class Node implements Comparable<Node>{
        long price;
        long cap;
        public Node(long price, long cap){
            this.price=price;
            this.cap=cap;
        }
        public int compareTo(Node c){
            return Long.compare(this.cap,c.cap);
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof Node){
                Node c = (Node)o;

            }
            return false;
        }
    }
    //public static PrintWriter pw;
    public static PrintWriter pw = new PrintWriter(System.out);

    public static void solve() throws IOException {
//	pw=new PrintWriter(new FileWriter("C:\\Users\\shree\\Downloads\\small_output_in"));
        FastReader sc = new FastReader();
        int n =sc.I(); int k=sc.I();
        long s=sc.L(); long t=sc.L();
        Node p[]=new Node[n];
        for(int i=0;i<n;i++){
            long price=sc.L(); long cap=sc.L();
            p[i]=new Node(price,cap);
        }

        gas=new long[k];
        for(int i=0;i<k;i++) gas[i]=sc.L();
        Arrays.sort(gas);
        long ans=Long.MAX_VALUE;
        long l=0,h=(long)1e9;
        while(l<=h){
            long cap=(l+h)/2;
            if(can(cap,k,s,t)){
                for(int i=0;i<n;i++){
                    if(p[i].cap>=cap) ans=Math.min(ans,p[i].price);
                }
                h=cap-1;
            }else l=cap+1;

        }
        if(ans==Long.MAX_VALUE) pw.println(-1);
        else
        pw.println(ans);
        pw.close();


    }
static long gas[];
    static boolean can(long cap,int k,long s,long time){
        long prev=0;
        long tme=0;
        for(int i=0;i<k;i++){
            long d=gas[i]-prev;
            if(cap<d)return false;
            long dfast=Math.min(d,cap-d);
            tme+=dfast+2*(d-dfast);
            prev=gas[i];
        }
        long d=s-prev;
        if(cap<d)return false;
        long dfast=Math.min(d,cap-d);
        tme+=dfast+2*(d-dfast);
        if(tme>time) return false;
        return true;
    }
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {

                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();

    }

    static BufferedReader br;
    static long M = (long) 1e9 + 7;

    static class FastReader {

        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            //br=new BufferedReader(new FileReader("C:\\Users\\shree\\Downloads\\B-small-practice.in"));
            br = new BufferedReader(new InputStreamReader(System.in));

        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int I() {
            return Integer.parseInt(next());
        }

        long L() {
            return Long.parseLong(next());
        }

        double D() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public boolean hasNext() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return false;
                }
                st = new StringTokenizer(s);
            }
            return true;
        }

    }
}