import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class KitaharaHarukisGift {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        
        int N = sc.nextInt();
        
        int one = 0;
        int two = 0;
        for (int i = 0; i < N; i++) {
        	int w = sc.nextInt();
        	if (w == 100) {
        		one++;
        	} else {
        		two++;
        	}
        }
        
        if (two % 2 == 1 && one >= 2) {
        	one -= 2;
        	two++;
        }
        
        if (two % 2 == 0 && one % 2 == 0) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
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