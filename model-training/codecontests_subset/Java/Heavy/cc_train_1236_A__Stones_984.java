import java.util.*;
import java.io.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try{ st = new StringTokenizer(br.readLine()); }
                catch (IOException  e) { e.printStackTrace(); } }
            return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine()  {
            String str = "";
            try{ str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str; }
    }



    public static void main(String[] args) {
        FastReader ip = new FastReader();
        OutputStream output = System.out;
        PrintWriter out = new PrintWriter(output);
        int t=ip.nextInt();
        while(t-->0){
            int a=ip.nextInt();
            int b=ip.nextInt();
            int c=ip.nextInt();
            int y=c/2;
            int a1=0;
            if(b-y>=0){
                b=b-y;
                a1=y;
            }else{
                a1=b;
                b=0;
            }
            int x=b/2;
            int a2=0;
            if(a-x>=0){
                a=a-x;
                a2=x;
            }else{
                a2=a;
                a=0;
            }
            out.println((a1+a2)*3);
        }

        out.close();
    }
}