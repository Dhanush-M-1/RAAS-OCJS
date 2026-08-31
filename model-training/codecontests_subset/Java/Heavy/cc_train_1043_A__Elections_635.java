import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.math.*;
import java.util.*;


// author @fire
public class CodeForces_CA {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int sed=0;
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
            sed+=a[i];
        }
        Arrays.sort(a);
        int k=a[n-1];
        int sk=0;
       // System.out.println(k);
        while(true){
            sk=0;
            for(int i=0;i<n;i++)
                sk+=Math.abs((a[i]-k));
            if(sk>sed)
                break;
            k++;
        }
        System.out.println(k);



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