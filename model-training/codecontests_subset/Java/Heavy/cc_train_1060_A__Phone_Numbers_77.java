import java.io.*;
import java.util.*;
public class Mohammad  {
    public static void Mohammad_AboHasan() throws IOException{
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s = fs.next().replaceAll("[ 0 1 2 3 4 5 6 7 9 ]", "");
        System.out.println(Math.min(s.length(), n/11));
    }
    public static void main(String[] args) throws IOException{
        Mohammad_AboHasan();
    }
    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException{
            while (st == null || !st.hasMoreElements()) {
                    st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException{
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
        String nextLine() throws IOException{
            String s = br.readLine();
            return s;
        }
    }
}