
import java.io.*;
import java.util.*;

public class D {

    static int a[];

    public static int check(int m) {        
         for(int i = m + 1; i < a.length; i++){
             if(a[i] > 0){
                 return a[i];
             }
         }
         return -1;
    }

    static class Doit {

        public void solve(InputReader in, PrintWriter out) {
            int n = Integer.parseInt(in.next());
            String s = in.next();

            a = new int[26];

            boolean flag = true;
            int k;
            for (int i = 0; i < n; i++) {
                k = check(s.charAt(i) - 'a');
                if (k != -1) {
                    flag = false;
                    System.out.println("YES");
                    System.out.println((k) + " "+ (i + 1));
                    break;
                }
                a[s.charAt(i) - 'a'] = (i + 1);
            }
            
            if(flag){
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Doit solver = new Doit();
        solver.solve(in, out);
        out.close();
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

    }
}
