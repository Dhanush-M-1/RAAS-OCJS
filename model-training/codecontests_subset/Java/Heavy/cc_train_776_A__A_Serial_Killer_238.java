import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Alexandr on 19.11.2016.
 */
public class mark {

    public void solve() throws IOException {
        String s1 = nextToken (), s2 = nextToken ();
        int n = nextInt ();
        out.println (s1 + " " + s2);
        for (int i = 0; i < n; i++){
            String t1 = nextToken (), t2 = nextToken ();
            if(s1.length () != t1.length ()){
                s2 = t2;
            }else {
                boolean flag = true;
                for(int j = 0; j < s1.length (); j++) {
                    if(s1.charAt (j) != t1.charAt (j)) flag = false;
                }
                if (flag) {
                    s1 = t2;
                } else {
                    s2 = t2;
                }
            }
            out.println (s1 + " " + s2);
        }
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
        try {
            Locale.setDefault (Locale.US);
        } catch (Exception e) {
        }
        new mark ().run ();
    }

    public void run() {
        try {
            br = new BufferedReader (new InputStreamReader (System.in));
            out = new PrintWriter (System.out);
//            br = new BufferedReader (new FileReader ("skyscraper.in"));
//            out = new PrintWriter (new File ("skyscraper.out"));
            solve ();
            out.close ();
        } catch (IOException e) {
            e.printStackTrace ();
            System.exit (1);
        }
    }
}

