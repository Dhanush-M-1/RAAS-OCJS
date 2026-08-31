import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;

public class A {
static class Node{
    int x;
    int y;

    public Node(int x,int y){
        this.x=x;
        this.y=y;

    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Node){
            Node c = (Node)o;
            return x==c.x && y==c.y;
        }
        return false;
    }
    public int hashCode(){
        return x+y;//for simplicity reason
    }

}

    //public static PrintWriter pw;
    public static PrintWriter pw = new PrintWriter(System.out);

    public static void solve() throws IOException {
//	pw=new PrintWriter(new FileWriter("C:\\Users\\shree\\Downloads\\small_output_in"));
        FastReader sc = new FastReader();
        long a[]=new long[2];
        long b[]=new long[2];
        long c[]=new long[2];
        a[0]=sc.L(); a[1]=sc.L(); b[0]=sc.L(); b[1]=sc.L(); c[0]=sc.L(); c[1]=sc.L();
        double d1=getDistance(a,b);
        double d2=getDistance(b,c);
        double d3=getDistance(a,c);
        if((c[1]-b[1])*(b[0]-a[0])==(b[1]-a[1])*(c[0]-b[0])) pw.println("No");
        else if(getS(a,b)==getS(b,c)) pw.println("Yes");
        else pw.println("No");


     pw.close();


    }
    static long getS(long a[],long b[]){
        return ((a[0]-b[0])*(a[0]-b[0]))+((a[1]-b[1])*(a[1]-b[1]));
    }
    static double getDistance(long a[],long b[]){
        return Math.sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
    }
    static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
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