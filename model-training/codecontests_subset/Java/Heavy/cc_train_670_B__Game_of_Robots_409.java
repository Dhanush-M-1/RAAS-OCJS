import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class B_350 {

    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = nextInt();
        int k = nextInt();
        int []a = new int[N+1];
        for (int i = 1; i <=N ; i++) {
			a[i] = nextInt();
		}
        long i = (-1+(int)Math.sqrt(1+8*k))/2-1;
        while((i*(i+1))/2<k){
        	i++;
        }
        System.out.println(a[(int) (k-(i*(i-1))/2)]);
        pw.close();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
//    private static long nextLong() throws IOException {
//        return Long.parseLong(next());
//    }
//    private static double nextDouble() throws IOException {
//        return Double.parseDouble(next());
//    }
    private static String next() throws IOException {
        while (st==null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}