import java.io.*;
import java.util.StringTokenizer;

public class Main implements Runnable {

    void solution() throws IOException {
        int need = nextInt();
        int can = nextInt();
        int len = nextInt();
        int delta = (len*need+can-1)/can - len;
        out.println(delta);
    }

    ///////////////////// Template definitions //////////////////////////
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String l = in.readLine();
            if (l == null) return null;
            st = new StringTokenizer(l);
        }
        return st.nextToken();
    }

    public static void main(String args[]) {
        //Locale.setDefault(Locale.UK);
        new Thread(new Main()).start();
    }

    public void run() {
        try {
            boolean online = true;
            Reader reader = online
                    ? new InputStreamReader(System.in)
                    : new FileReader("my.in");
            in = new BufferedReader(reader);
            out = new PrintWriter(System.out);
            solution();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(202);
        }
    }

    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;
}