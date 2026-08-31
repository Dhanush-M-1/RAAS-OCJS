import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a81420 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        int n;
        int[] a = new int[100000];
        for(int i = 0; i < t; i++) {
            n = sc.nextInt();
            for (int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            if (a[0] + a[1] - a[n-1] <= 0){
                result.append('1');
                result.append(' ');
                result.append('2');
                result.append(' ');
                result.append(n);
            }else{
                result.append(-1);
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }
    private static StringBuilder result = new StringBuilder();

    public static class MyScanner {
        final BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}
