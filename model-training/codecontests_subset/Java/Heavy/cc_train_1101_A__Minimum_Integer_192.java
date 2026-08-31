

import java.io.*;
import java.math.*;
import java.util.*;


// author @mdazmat9
 public class codeforces{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int test = sc.nextInt();
        for (int ind = 0; ind < test; ind++) {
           long l=sc.nextLong();
           long r=sc.nextLong();
           long d=sc.nextLong();
           if(d<l){
               out.println(d);
           }
           else if(d>r){
               out.println(d);
           }
           else{
               long ans=(long)r/d;
               ans*=d;
               ans+=d;
               out.println(ans);
           }

        }
        out.flush();

        }




    static long gcd(long a , long b)
    {
        if(b == 0)
            return a;
        return gcd(b , a % b);
    }

}
class Scanner {
    public BufferedReader reader;
    public StringTokenizer st;

    public Scanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        st = null;
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            } catch (Exception e) {
                throw (new RuntimeException());
            }
        }
        return st.nextToken();
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

class OutputWriter {
    BufferedWriter writer;

    public OutputWriter(OutputStream stream) {
        writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    public void print(int i) throws IOException {
        writer.write(i);
    }

    public void print(String s) throws IOException {
        writer.write(s);
    }

    public void print(char[] c) throws IOException {
        writer.write(c);
    }

    public void close() throws IOException {
        writer.close();
    }

}