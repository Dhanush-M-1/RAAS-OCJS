import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Likes {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {

            return Long.parseLong(next());
        }

        BigInteger nextBigIntger() {
            BigInteger bb = new BigInteger(next());
            return bb;
        }
    }

    public static void main(String[] args) {
        FastReader sc= new FastReader();
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;arr[i++]=sc.nextInt());
        int profit = 0;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                profit= Integer.max(profit,(arr[i-1]-arr[i]));
            }
        }
        System.out.println(c>profit?0:(profit-c));
    }
}
