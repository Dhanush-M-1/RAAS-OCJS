

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class C {

    static StreamTokenizer st;
    static PrintWriter pw;

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    private static String next() throws IOException {
        st.nextToken();
        return (String) st.sval;
    }

    public static void main(String[] args) throws IOException {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(
                System.in)));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                System.out)));
        // -----------begin-------------------------
        int n = nextInt();
        String s = next();
        int f = 0, a = 0, in = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'F') {
                f++;
                continue;
            }
            if (s.charAt(i) == 'A') {
                a++;
                continue;
            }
            in++;
        }
        if (in==1){
            pw.println("1");
            pw.close();
            return;
        }
        if (in >1){
            pw.println("0");
            pw.close();
            return;
        }
        pw.print(a);
        pw.close();
        // ------------end--------------------------
    }

}