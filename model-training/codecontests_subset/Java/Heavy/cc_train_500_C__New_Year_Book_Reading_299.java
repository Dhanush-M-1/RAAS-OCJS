import java.io.*;
import java.util.*;

public class C {
    class FastReader {
        private BufferedReader br;
        private StringTokenizer stringTokenizer;

        FastReader(InputStream inputStream) throws IOException {
            br = new BufferedReader(new InputStreamReader(inputStream));
            stringTokenizer = new StringTokenizer(br.readLine());
        }

        FastReader(File file) throws IOException {
            this(new FileInputStream(file));
        }

        String next() throws IOException {
            while (!stringTokenizer.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stringTokenizer = new StringTokenizer(s);
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String ... args) throws IOException {
        new C().solve();
    }

    void solve() throws IOException {
        FastReader reader = new FastReader(System.in);

        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = reader.nextInt();
        }
        LinkedList<Integer> books = new LinkedList<>();
        boolean[] met = new boolean[n];
        Arrays.fill(met, false);
        int s = 0;
        for (int i = 0; i < m; i++) {
            int b = reader.nextInt() - 1;
            if (!met[b]) {
                books.addLast(b);
                met[b] = true;
            }
            for (Iterator<Integer> it = books.iterator(); it.hasNext();) {
                int x = it.next();
                if (x == b) {
                    it.remove();
                    books.addFirst(x);
                    break;
                }
                s += w[x];
            }
        }
        System.out.println(s);
    }
}

