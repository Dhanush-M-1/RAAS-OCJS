import java.io.*;
import java.util.*;

public class VKD {
    
    public static void main(String[] args)throws Exception{
        IO.init(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n, k, a, b, c, d;
        n = IO.nextInt();
        k = IO.nextInt();
        a = IO.nextInt();
        b = IO.nextInt();
        c = IO.nextInt();
        d = IO.nextInt();
        
        if(k<=n || n==4){ IO.println(-1);return; }
        out.print(a+" "+c+" ");
        for(int i=1;i<=n;++i){if(i!=a && i!=b && i!=c && i!=d)out.print(i+" ");}
        out.print(d+" "+b+"\n");
        
        out.print(c+" "+a+" ");
        for(int i=1;i<=n;++i){if(i!=a && i!=b && i!=c && i!=d)out.print(i+" ");}
        out.print(b+" "+d+" ");
        out.close();
    }

    static class IO {
        static BufferedReader reader;
        static StringTokenizer tokenizer;
 
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }
 
        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) { 
                tokenizer = new StringTokenizer(reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }

        static void print(Object ... o){
            for(int i=0;i<o.length;++i){
                System.out.print(o[i]);
            }
        }

        static void println(Object ... o){
            for(int i=0;i<o.length;++i){
                System.out.print(o[i]);
            }
            System.out.println();
        }
    }
}

