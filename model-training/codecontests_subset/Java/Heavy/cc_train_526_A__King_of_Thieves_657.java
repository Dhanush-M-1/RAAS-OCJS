import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i + j * 4 < n && (s.charAt(i) == '*')
                        && (s.charAt(i + j) == '*')
                        && (s.charAt(i + 2 * j) == '*')
                        && (s.charAt(i + 3 * j) == '*')
                        && (s.charAt(i + 4 * j) == '*')) {
                    out.println("yes");
                    in.close();
                    out.close();
                    return;
                }
            }
        }
        out.println("no");
        in.close();
        out.close();
    }

}
