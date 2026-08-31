import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class nA {

    Scanner in;
    PrintWriter out;

    void solve() {
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int kol[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            kol[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (kol[i] % k != 0) {
                out.println(-1);
                return;
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 26; j++) {
                for (int l = 0; l < kol[j] / k; l++) {
                    out.print((char)(j + 'a'));
                }
            }
        }
    }

    void run() {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        try {
            solve();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new nA().run();
    }

}
