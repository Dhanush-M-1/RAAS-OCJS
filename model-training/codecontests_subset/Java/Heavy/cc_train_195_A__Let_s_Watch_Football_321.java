import java.io.*;
import java.util.*;

public class CodeForces {
    static boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;


    void runCase(int caseNum) throws IOException {
        //out.print("Case #" + caseNum + ":");
        double a = nextInt();
        double b = nextInt();
        double c = nextInt();
        double t = (a * c) / b - c;
        out.println((int)Math.ceil(t));
    }


    public static void main(String[] args) throws IOException {
        if (ONLINE_JUDGE){
            System.out.println();
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }else{
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
        new CodeForces().runIt();
        out.flush();
        out.close();
        return;
    }

    static BufferedReader in;
    private StringTokenizer st;
    static PrintWriter out;

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }


    void runIt() throws IOException {
        st = new StringTokenizer("");

//        int N = nextInt();
//        for (int i = 0; i < N; i++) {
//            runCase(i + 1);
//        }
        runCase(0);

        out.flush();
    }

}
