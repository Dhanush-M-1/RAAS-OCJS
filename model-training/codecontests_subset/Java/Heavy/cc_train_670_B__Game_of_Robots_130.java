import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by shirsh.bansal on 05/05/16.
 */
public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        long k = sc.nextLong();

        int ids[] = new int[n];
        for(int i = 0; i < n; i++) ids[i] = sc.nextInt();

        long num = 2;
        long sum = 1;
        while((num * (num + 1)) / 2 <= k) {
            sum = (num * (num + 1)) / 2;
            num++;
        }
        out.println(ids[(int)(k-sum-1+num-1)%(int)(num-1)]);


        out.close();
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
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
    }
    //--------------------------------------------------------
}