
import java.lang.*;
import java.util.*;
import java.io.*;

public class CodeforcesB {

    public void solve()throws IOException{
        FastScanner in = new FastScanner();
        StringBuilder ans = new StringBuilder("");
        double x1,x2,e;
        long a,b,c;
        a=in.nextLong();
        b=in.nextLong();
        c=in.nextLong();
        e=Math.pow(b,2)-4*a*c;
        if(a==0)
        {
            if(b!=0) {System.out.println(1);System.out.format("%.10f",1.0*(-c)/b);}
            else if(b==0&&c!=0)System.out.print(0);
            else if(b==0&&c==0)System.out.print(-1);
        }
        else
        {if(e<0)System.out.println(0);
        else if(e>0)
        {
            x1=(-b-Math.sqrt(e))/(2*a);x2=(-b+Math.sqrt(e))/(2*a);
            System.out.println(2);
            System.out.format("%.10f\n%.10f",x1<x2?x1:x2,x1>x2?x1:x2);
        }
        else if(e==0)
        {
            System.out.println(1);
            System.out.format("%.10f",-b*1.0/(2*a));
        }
        }
    }
    public static void main(String[]args)throws IOException{
       try {
           new CodeforcesB().solve();
       }catch (Exception e){
           e.printStackTrace();

       }
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
