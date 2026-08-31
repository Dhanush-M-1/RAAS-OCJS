import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int[][] f = new int[n][10];
        long[][] p = new long[n][11];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 10; j++){
                f[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 11; j++){
                p[i][j] = sc.nextLong();
            }
        }
        long ans = -Long.MAX_VALUE;
        for(int i = 1; i < 1024; i++){
            int[] cnt = new int[n];
            for(int j = 0; j < 10; j++){
                if((i >> j) % 2 == 1){
                    for(int k = 0; k < n; k++){
                        if(f[k][j] == 1){
                            cnt[k]++;
                        }
                    }
                }
            }
            long tmp = 0;
            for(int k = 0; k < n; k++){
                tmp += p[k][cnt[k]];
            }
            ans = Math.max(ans,tmp);
        }
        System.out.println(ans);
    }
}

class Restaurant implements Comparable<Restaurant>{
    int p,i;
    String c;
    public Restaurant(int p,int i,String c){
        this.p = p;
        this.i = i;
        this.c = c;
    }
    
    public int compareTo(Restaurant r){
        if(this.c.compareTo(r.c) <= -1){
            return -1;
        }else if(this.c.compareTo(r.c) >= 1){
            return 1;
        }else{
            if(this.p > r.p){
                return -1;   
            }else if(this.p < r.p){
                return 1;
            }else{
                return 0;
            }
        }
    }
}

class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;
    
    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            return tokenizer.nextToken("\n");
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
    
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public double nextDouble() {
         return Double.parseDouble(next());
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nextLong();
        return a;
    } 
}
