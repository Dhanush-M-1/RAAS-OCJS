import java.io.*;
import java.util.*;

public class Main {

    static MyScanner in;
    static PrintWriter out;
    //static Timer t = new Timer();

    public static void main(String[] args) throws Exception {
        in = new MyScanner();
        out = new PrintWriter(System.out, true);

        int n = in.nextInt(), m = in.nextInt();
        int[] w = new int[n+1];
        for(int i = 1; i <= n; i++)
            w[i] = in.nextInt();

        int total = 0;
        List<Book> list = new LinkedList<>();

        while(m-- != 0) {
            int next = in.nextInt();

            if(w[next] != -1) {
                for(Book b : list)
                    total += b.w;
                list.add(0, new Book(w[next], next));
                w[next] = -1;
                continue;
            }

            //w[next] == -1
            Iterator<Book> iter = list.listIterator();
            while(iter.hasNext()) {
                Book b = iter.next();

                if(b.pos == next) {
                    iter.remove();
                    list.add(0, b);
                    break;
                }

                total += b.w;
            }
        }

        out.println(total);
    }
}

class Book {
    int w, pos;

    Book(int w, int pos) {
        this.w = w;
        this.pos = pos;
    }
}

//<editor-fold defaultstate="collapsed" desc="MyScanner">
class MyScanner {

    private final BufferedReader br;
    private StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public MyScanner(String path) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(path)));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    boolean hasNext() {
        if (st != null && st.hasMoreElements())
            return true;

        try {
            while (st == null || !st.hasMoreElements())
                st = new StringTokenizer(br.readLine());
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    String nextLine() throws IOException {
        return br.readLine();
    }

    String[] nextStrings(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = next();
        return arr;
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    int[] nextInts(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    int[][] next2Ints(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = nextInt();
        return arr;
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    long[] nextLongs(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }

    long[][] next2Longs(int n, int m) throws IOException {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = nextLong();
        return arr;
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next().replace(',', '.'));
    }

    double[] nextDoubles(int size) throws IOException {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextDouble();
        return arr;
    }

    boolean nextBool() throws IOException {
        String s = next();
        if (s.equalsIgnoreCase("true") || s.equals("1"))
            return true;

        if (s.equalsIgnoreCase("false") || s.equals("0"))
            return false;

        throw new IOException("Boolean expected, String found!");
    }
}
//</editor-fold>
