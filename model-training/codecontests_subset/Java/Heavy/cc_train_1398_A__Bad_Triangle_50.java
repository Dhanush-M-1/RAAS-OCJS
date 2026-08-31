import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Learning {
    public static void main(String[] args) throws Exception {
        FastInput in = new FastInput();
        StringBuilder st = new StringBuilder();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = in.nextInt();
            }
            int a = arr[0];
            int b = arr[1];
            int c = arr[n-1];
           if(a+b<=c){
               st.append(1).append(" ").append(2+" ").append(n);
           }
           else st.append(-1);
            st.append("\n");
        }

        System.out.println(st.toString());
    }

    private static boolean check(int r, int g, int b, int w) {
        if (r >= 0 && g >= 0 && b >= 0 && w >= 0) {
            int odd = 0;
            if (r % 2 == 1) {
                odd++;
            }
            if (g % 2 == 1) {
                odd++;
            }
            if (b % 2 == 1) {
                odd++;
            }
            if (w % 2 == 1) {
                odd++;
            }
            return odd <= 1;
        }
        return false;
    }


}


class FastInput {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String next() throws IOException {
        if (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    Integer nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    Long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}