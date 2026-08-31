import java.io.*;
import java.util.*;


public class Woodcutters {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[][] a = new int [n][2];
        for (int i = 0; i < 2*n; i++){
            a[i/2][i%2] = sc.nextInt();
        }
        if (n <= 2){
            System.out.println(n);
        }else{
            int ans = 2;
            for (int i = 1; i < n-1; i++){
                if ((a[i][0] - a[i][1]) > a[i-1][0]){
                    ans++;
                } else if ((a[i][0] + a[i][1]) < a[i+1][0]){
                    ans++;
                    a[i][0] = a[i][0] + a[i][1];
                }
            }
            System.out.println(ans);
        }
    }
    
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}
