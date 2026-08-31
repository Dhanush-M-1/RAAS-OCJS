import java.io.*;
import java.util.*;
public class d {
    static int n,sum=0;
    static int[]a;
    public static void main(String args[]) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        n=sc.nextInt();
        a = new int[n];
        sum=0;
        int max=0;
        for(int i =0;i<n;i++){
            a[i]=sc.nextInt();
            sum+=a[i];
            max = Math.max(a[i],max);
        }
        int  l =max,r=10005,ans=0;
        while (l<=r){
           int m =(l+r)/2;
           if(check(m)>sum){
               r=m-1;
               ans = m;
           }
           else
           {
               l=m+1;
           }
        }
        out.print(ans);

        out.close();
    }
    static int check(int m){
        int s=0;
        for(int i =0;i<n;i++){
            s+=m-a[i];
        }
        return s;
    }
    public static void shuffle(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    public static void shuffle(int[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.valueOf(next());
        }

        public double nextDouble() {
            return Double.valueOf(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

    }
}