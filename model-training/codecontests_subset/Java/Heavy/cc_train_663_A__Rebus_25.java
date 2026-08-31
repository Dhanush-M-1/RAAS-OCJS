import java.io.*;
import java.util.*;

public class C {

    void solve() {
        String s = in.next();
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        int count = 1;
        int pluscount = 1;
        int minuscount = 0;
        while (!s.equals("=")) {
            if (s.equals("-")) {
                in.next();
                count--;
                minuscount++;
                items.add(-1);
            } else if (s.equals("+")) {
                in.next();
                count++;
                pluscount++;
                items.add(1);
            }
            s = in.next();
        }
        int n = in.nextInt();
        if ((count <= 0 && minuscount > (pluscount - 1) * n ) || (count > n && pluscount - minuscount * n > n)) {
            out.println("Impossible");
            return;
        }
        out.println("Possible");
        boolean first = true;
        if (count > 0 && count <= n) {
            for (int i = 0; i < items.size(); i++) {
                int numb = 1;
                if (items.get(i) == 1) {
                    if (!first) {
                        out.print(" + ");
                    } else {
                        first = false;
                        numb = n - count + 1;
                    }
                } else {
                    out.print(" - ");
                }
                out.print(numb);
            }
            out.print(" = " + n);
        } else if (count <= 0) {
            int splitPlus = Math.abs(count-1)/(pluscount-1);
            int rest = Math.abs(count-1) % (pluscount - 1);
            for (int i = 0; i < items.size(); i++) {
                int numb = 1;
                if (items.get(i) == 1) {
                    if (!first) {
                        out.print(" + ");
                        numb += splitPlus;
                        if (rest > 0){
                            rest--;
                            numb++;
                        }
                    } else {
                        first = false;
                        numb = n;
                    }
                } else {
                    out.print(" - ");
                }
                out.print(numb);
            }
            out.print(" = " + n);
        } else if (count >n){
            int splitMinus = (count-n)/minuscount;
            int rest = (count-n) % minuscount;
            for (int i = 0; i < items.size(); i++) {
                int numb = 1;
                if (items.get(i) == 1) {
                    if (!first) {
                        out.print(" + ");
                    } else {
                        first = false;
//                        numb = n;
                    }
                } else {
                    numb += splitMinus;
                    if (rest > 0){
                        rest--;
                        numb++;
                    }
                    out.print(" - ");
                }
                out.print(numb);
            }
            out.print(" = " + n);
        }
    }

    FastScanner in;
    PrintWriter out;

    void run() {
        try {
            in = new FastScanner(new File("C.in"));
            out = new PrintWriter(new File("C.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        new C().runIO();
    }
}