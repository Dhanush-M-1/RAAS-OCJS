import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        StringBuilder s=new StringBuilder();
        int n=Reader.nextInt();
        long k=Reader.nextLong(),arr[]=new long[n];
        for(int i=0;i<n;i++)
            arr[i]=Reader.nextLong();
        int cnt=1,cc=1;
        while(cnt<k)
            cnt+=cc++;
        if(cnt>k) {
            cnt-=--cc;
        }
        int b=(int)k-cnt;
        s.append(arr[b]).append('\n');
        System.out.print(s);
    }
    
}

class Reader {
    
    static StringTokenizer tokenizer;
    static BufferedReader reader;
    
    public static void init(InputStream input) throws UnsupportedEncodingException {
        reader=new BufferedReader(new InputStreamReader(input,"UTF-8"));
        tokenizer=new StringTokenizer("");
    }
    
    public static String next() throws IOException {
        while(!tokenizer.hasMoreTokens())
            tokenizer=new StringTokenizer(reader.readLine());
        return tokenizer.nextToken();
    }
    
    public static String nextLine() throws IOException {
        return reader.readLine();
    }
    
    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    
    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}