import java.util.*;
import java.text.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public*/
public class Equation
{
    static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
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
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
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
    }
    
    static class Node {
        
        long pp;
        long a, b;
        
        Node(long x, long y) {
            a = x;
            b = y;
            pp = a * b;
        }
    }
    static class Comp implements Comparator<Node> {
        
        public int compare(Node o1, Node o2) {
            if (o1.pp > o2.pp) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        DecimalFormat ft=new DecimalFormat("#.########");
        //your code starts here
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int ans=-69; double roots[]=new double[2];
        if(a==0 && b==0 && c==0) ans=-1; //infinite roots
        else if(a==0 && b==0 && c!=0) ans=0; //no roots satisfy
        else if(a==0 && b!=0 && c==0) 
        {
            out.println("1 \n0.0000000000"); out.close();return;
        }
        else if(a==0 && b!=0 && c!=0){
            double res=(-1)*((double)c/(double)b); out.println("1 \n"+String.format("%.8f", res)); out.close(); return;
        }
        else{
            long D=(long)b*b-4*(long)a*c;
            if(D<0) ans=0;
            else{
                roots[0]=(-(double)b+Math.sqrt(D))/(2.0*(double)a);
                roots[1]=(-(double)b-Math.sqrt(D))/(2.0*(double)a);
                Arrays.sort(roots);
                if(D==0) //equal roots
                {
                    out.println("1 \n"+String.format("%.8f",roots[0])); out.close(); return;
                }
            }
        }
        if(ans==-69) //both roots present
        {
            out.println("2");
            out.println(String.format("%.8f",roots[0]));
            out.println(String.format("%.8f", roots[1]));
        }
        else out.println(ans);
        out.close();
    }
}
