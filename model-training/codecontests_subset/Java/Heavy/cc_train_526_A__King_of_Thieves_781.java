import java.io.*;
import java.util.*;


public class Source {
    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;
        public FastScanner(InputStream inputStream){
            br = new BufferedReader(new InputStreamReader(inputStream));
        }
        public String next() {
            while (st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored){}
            }
            return st.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String args[]){
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter printer = new PrintWriter(System.out);
        int n = scanner.nextInt();
        String s = scanner.next();
        for(int k=1;k<n;k++){
            for(int i=0;;i++){
                if(i+k*4 >= n){
                    break;
                }
                boolean c1 = s.charAt(i) == '*';
                boolean c2 = s.charAt(i+k) == '*';
                boolean c3 = s.charAt(i+k*2) == '*';
                boolean c4 = s.charAt(i+ k*3) == '*';
                boolean c5 = s.charAt(i+k*4) == '*';
                if(c1 && c2 && c3 && c4 && c5){
                    printer.println("yes");
                    printer.close();
                    return;
                }
            }
        }
        printer.println("no");
        printer.close();
    }
}
