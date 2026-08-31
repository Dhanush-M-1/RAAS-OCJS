import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            int ans = 0;
            while (b > 0 && c > 1){
                b --;
                c -= 2;
                ans+=3;
            }
            while(a > 0 && b > 1){
                a--;
                b -= 2;
                ans+=3;
            }
            System.out.println(ans);
        }
    }


    static BufferedReader br;

    static StringTokenizer in = new StringTokenizer("");

    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
