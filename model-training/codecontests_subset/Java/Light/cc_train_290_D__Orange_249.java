import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] sp;

        String str = in.readLine();
        String out = "";
        int n = Integer.parseInt(in.readLine());

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < n + 97) {
                out += "" + (char) (ch - 'a' + 'A');
            } else {
                out += "" + (char) ch;
            }
        }
        System.out.println(out);
    }
}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
