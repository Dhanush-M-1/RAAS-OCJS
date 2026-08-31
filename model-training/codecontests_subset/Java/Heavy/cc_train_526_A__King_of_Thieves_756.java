import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ZeptA {

    private static Scanner in;
    private static Output out;
    static boolean isFile = false;

    static HashMap<Integer, Boolean> map = new HashMap<>();

    public static void solve() throws Exception {
        int n = in.nextInt();
        char[] c = in.nextLine().trim().toCharArray();

        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < c.length; i++)
            if (c[i] == '*') l.add(i + 1);

        int index = 0;
        if (l.isEmpty()) {
            out.print("no");
            return;
        }
        while (true) {
            Integer elementIndex = l.get(index);
            if (l.size() - index < 5)
                break;

            outer:
            for (int i = index + 1; i < l.size(); i++) {
                int diff = l.get(i) - elementIndex;
                int current = elementIndex;
                int count = 1;
//                System.out.println();
//                System.out.print(current + " ");
                while (true) {
                    if (count == 5) {
                        out.println("yes");
                        return;
                    }
                    int next = current + diff;
                    int foundIndex = Collections.binarySearch(l, next);
                    if (foundIndex < 0) {
                        continue outer;
                    }
                    current = next;
//                    System.out.print(current+" ");
                    count++;
                }
            }
            index++;
        }

        out.println("no");

    }


    static Exception exception;

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    initReaderWriter();
                    solve();
                    out.close();
                } catch (Exception ex) {
                    exception = ex;
                }
            }
        }, "", 1 << 26);
        thread.start();
        thread.join();

        if (exception != null) {
            throw exception;
        }
    }

    private static void initReaderWriter() throws Exception {
        if (isFile) {
            in = new Scanner("input.txt");
            out = new Output(new File("output.txt"));
        } else {
            in = new Scanner();
            out = new Output(System.out);
        }
    }

    private static boolean log = false;

    public static void log(String msg) {
        if (log) {
            out.println(msg);
            out.flush();
        }
    }

    private static class Scanner {

        StringTokenizer st = null;
        BufferedReader bf;

        public Scanner() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        public Scanner(String fileName) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(fileName));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(bf.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
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

    private static class Output extends PrintStream {

        public Output(OutputStream out) {
            super(new BufferedOutputStream(out));
        }

        public Output(File file) throws FileNotFoundException {
            super(new BufferedOutputStream(new FileOutputStream(file)));
        }
    }
}
