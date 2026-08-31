import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pre179
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String args[]) {
        FastReader obj = new FastReader();
        int n = obj.nextInt(), c = obj.nextInt(), arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = obj.nextInt();
        int max = 0;
        for (int i = 0; i < n - 1; i++)
            if (arr[i] - arr[i + 1] - c > max)
                max = arr[i] - arr[i + 1] - c;
            System.out.println(max);
    }
}
