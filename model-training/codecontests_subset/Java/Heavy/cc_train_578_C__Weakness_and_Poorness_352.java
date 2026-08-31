import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public void solve() throws IOException {
        int n = nextInt ();
        double a[] = new double[n];
        for (int i = 0; i < n; i++) a[i] = nextDouble ();

        double l = -10000.0, r = 10000.0;
        int cnt = 0;
        while (cnt < 100) {
            cnt++;
            double mid1 = l + (r - l) / 3;
            double mid2 = l + (r - l) / 3 * 2;
            double max1 = 0.0, min2 = 0.0, max2 = 0.0, min1 = 0.0;
            double pr1 = 0.0, pr2 = 0.0;
            for (int i = 0; i < n; i++) {
                pr1 += a[i] - mid1;
                min1 = Math.min (min1, pr1);
                max1 = Math.max (max1, pr1);
                pr2 += a[i] - mid2;
                min2 = Math.min (min2, pr2);
                max2 = Math.max (max2, pr2);
            }
            if (Math.abs (max1 - min1) <= Math.abs (max2 - min2)) {
                r = mid2;
            } else {
                l = mid1;
            }
        }
        double pr = 0.0, max = 0.0, min = 0.0;
        for (int i = 0; i < n; i++) {
            pr += a[i] - l;
            min = Math.min (min, pr);
            max = Math.max (max, pr);

        }
        out.print (Math.abs (max- min));
    }

    BufferedReader br;
    StringTokenizer sc;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (sc == null || !sc.hasMoreTokens ()) {
            try {
                sc = new StringTokenizer (br.readLine ());
            } catch (Exception e) {
                return null;
            }
        }
        return sc.nextToken ();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt (nextToken ());
    }

    public boolean hasNext() {
        while (sc == null || !sc.hasMoreTokens ()) {
            try {
                String s = br.readLine ();
                if (s == null) {
                    return false;
                }
                sc = new StringTokenizer (s);
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
        return sc.hasMoreTokens ();
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble (nextToken ());
    }

    public long nextLong() throws IOException {
        return Long.parseLong (nextToken ());
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault (Locale.US);
        new Main ().run ();
    }

    public void run() {

        try {
            out = new PrintWriter (System.out);
            br = new BufferedReader (new InputStreamReader (System.in));
//            br = new BufferedReader (new FileReader ("umbrella.in"));
//            out = new PrintWriter (new File ("umbrella.out"));

            solve ();
            out.close ();
        } catch (IOException e) {
            e.printStackTrace ();
            System.exit (1);
        }
    }
}


