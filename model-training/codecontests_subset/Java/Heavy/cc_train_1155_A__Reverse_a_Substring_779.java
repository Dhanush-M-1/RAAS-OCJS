import java.io.*;
import java.util.*;
import java.lang.*;
 
public class Main {
 
    private static final FS scanner = new FS(System.in);
 
	public static void main(String[] args) throws Exception {
        int q = scanner.nextInt();
        String str = scanner.next();

        int start = 0;
        int end = 0;
        char ch = 'a';
        for (int i = 0; i < q; i++) {
            if (str.charAt(i) < ch) {
                end = i + 1;
                break;
            }
            else {
                start = i + 1;
                ch = str.charAt(i);
            }
        }

        if (start == 0 || end == 0) {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
            System.out.println(start + " " + end);
        }
    }
	
    static class FS {
        BufferedReader br;
        StringTokenizer st;

        public FS(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
 
}