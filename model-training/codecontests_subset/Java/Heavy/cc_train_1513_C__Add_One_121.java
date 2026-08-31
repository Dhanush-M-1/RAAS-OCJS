import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    static final long MOD = 1000000007;
    
    public static void main(String[] args) {
    
        var sc = new FastScanner(System.in);
        var pw = new PrintWriter(System.out);
        
        var c = new long[10][200001];
        for(int i = 0; i <= 9; i++){
            var a = new long[10];
            a[i] = 1;
            for(int j = 1; j <= 200000; j++){
                var b = new long[10];
                System.arraycopy(a, 0, b, 1, 9);
                b[0] = a[9];
                b[1] += a[9];
                for(int k = 0; k <= 9; k++){
                    b[k] %= MOD;
                    c[i][j] += b[k];
                }
                c[i][j] %= MOD;
                System.arraycopy(b, 0, a, 0, 10);
            }
        }
        
        int T = Integer.parseInt(sc.next());
        for(int t = 0; t < T; t++){
            String n = sc.next();
            int m = Integer.parseInt(sc.next());
            long ans = 0;
            for(int i = 0; i < n.length(); i++){
                int j = Integer.parseInt(n.substring(i, i+1));
                ans += c[j][m];
                ans %= MOD;
            }
            pw.println(ans);
        }
        pw.flush();
    }
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}