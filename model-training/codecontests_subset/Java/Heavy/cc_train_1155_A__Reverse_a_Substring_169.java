import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            InputReader.OutputWriter out = new InputReader.OutputWriter(outputStream);

            int n = in.nextInt();
            char [] c = in.next().toCharArray();
            int [] lastIndex = new int[26];
            int [] firstIndex = new int[26];
            Arrays.fill(lastIndex,-1);
            Arrays.fill(firstIndex,-1);
            for (int i = 0; i < c.length; i++) {
               lastIndex[c[i]-'a'] = i;
               if(firstIndex[c[i]-'a'] == -1) firstIndex[c[i]-'a']= i;
            }
            boolean flag = false;
            int a = -1;
            int b = -1;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < i; j++) {
                    if(lastIndex[j] > firstIndex[i] && lastIndex[j]!=-1 && firstIndex[i]!=-1) {
                        a = firstIndex[i] + 1;
                        b = lastIndex[j] + 1;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }

            if(flag) {
                out.println("YES");
                out.println(a + " " + b);
            }
            else {
                out.println("NO");
            }



          /*  int n = in.nextInt();
            int count = (n - 11)/2;
            char [] c = in.next().toCharArray();
            int num = 0;
            for (int i = 0; i < c.length - 10; i++) {
                if(c[i] == '8') {
                    num++;
                }
            }
            if(num == 1) {
                out.println("NO");
            }
            else {
                if(num > count) {
                    out.println("YES");
                }
                else {
                    out.println("NO");
                }
            }
*/
           /* int n = in.nextInt();
            int m = in.nextInt();
            long [] a = new long[n];
            long [] b = new long[m];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextLong();
            }
            for (int i = 0; i < b.length; i++) {
                b[i] = in.nextLong();
            }
            boolean found = true;
            long first = a[0];
            for (int i = 0; i < b.length; i++) {
                long interval = b[i];
                found = true;
                for (int j = 1; j < a.length; j++) {
                    if((a[j]-first)%interval!=0) {
                        found = false;
                        break;
                    }
                }
                if(found) {
                    out.println("YES");
                    out.println(first + " " + (i+1));
                    break;
                }
            }

            if(!found) {
                out.println("NO");
            }*/
            out.flush();
        }


}
    class InputReader extends BufferedReader {
        StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            super(new InputStreamReader(inputStream), 32768);
        }

        public InputReader(String filename) {
            super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }
        public Long nextLong() {return  Long.valueOf(next());}

        static class OutputWriter extends PrintWriter {
            public OutputWriter(OutputStream outputStream) {
                super(outputStream);
            }

            public OutputWriter(Writer writer) {
                super(writer);
            }

            public OutputWriter(String filename) throws FileNotFoundException {
                super(filename);
            }

            public void close() {
                super.close();
            }
        }
    }
