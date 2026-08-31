import java.io.*;
import java.util.*;

public class Main {
    static FastScanner in;
    static PrintWriter out;
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        //        Scanner in = new Scanner(new File("input.txt"));
        //        Scanner in = new Scanner(System.in);
        //        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt")), true));
        out = new PrintWriter(System.out);
        in = new FastScanner(System.in);
        //        in = new FastScanner("input.txt");
        char s[] = in.next().toCharArray();
        int n = in.nextInt();
        boolean first = false, second = false;
        while (n-- > 0) {
            char ss[] = in.next().toCharArray();
            if (ss[0] == s[0] && ss[1] == s[1]) {
                first = true;
                second = true;
            }
            if (!first) {
                if (ss[0] == s[1])
                    first = true;
            }
            if (!second) {
                if (ss[1] == s[0]) {
                    second = true;
                }
            }
        }
        if (first && second)
            out.println("YES");
        else
            out.println("NO");
        out.close();
    }
}

class Pair {
    public int first; //first member of pair
    public int second; //second member of pair

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair p = (Pair) o;
        return first == p.first && second == p.second;
    }

    @Override
    public int hashCode() {
        int result = (int) first;
        result = 31 * result + (int) second;
        return result;
    }
}

class PairComparable implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.second < o2.second)
            return -1;
        else if (o1.second > o2.second)
            return 1;
        else {
            return 0;
        }
    }
}

class FastScanner {

    BufferedReader br;
    StringTokenizer tokenizer;

    FastScanner(String fileName) throws FileNotFoundException {
        this(new FileInputStream(new File(fileName)));
    }

    FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    String nextLine() throws IOException {
        tokenizer = null;
        return br.readLine();
    }

    String next() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    char nextChar() throws IOException {
        return next().charAt(0);
    }
}