
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    Scanner input;
    PrintStream output;

    public Main(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    static public void main(String[] arg) {
        Main prog = new Main(new Scanner(System.in), System.out);
        prog.Run();
    }

    void Run() {
        String a, b, c;
        a = input.next();
        b = input.next();
        c = input.next();
        int[] A, B, C;
        A = new int[26];
        B = new int[26];
        C = new int[26];
        for (int i = 0, n = a.length(); i < n; i++) A[a.charAt(i) - 'a']++;
        for (int i = 0, n = b.length(); i < n; i++) B[b.charAt(i) - 'a']++;
        for (int i = 0, n = c.length(); i < n; i++) C[c.charAt(i) - 'a']++;
        boolean flag = false;
        int resb = 0, resc = 0, resbc = 0;
        for (int i = 0; !flag; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) if (B[j] > 0) tmp = Integer.min(tmp, A[j] / B[j]);
            if (tmp + i > resbc) {
                resb = tmp;
                resc = i;
                resbc = resc + resb;
            }
            for (int j = 0; j < 26 && !flag; j++) if (A[j] < C[j]) flag = true;
            if (flag) continue;
            for (int j = 0; j < 26; j++) A[j] -= C[j];
        }
        String res = new String(new char[resb]).replaceAll("\0", b);
        res += new String(new char[resc]).replaceAll("\0", c);
        Arrays.fill(A, 0);
        for (int i = 0, n = a.length(); i < n; i++) A[a.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            char[] ch = new char[A[i] - resb * B[i] - resc * C[i]];
            Arrays.fill(ch, (char) ('a' + i));
            res += new String(ch);
        }
        output.println(res);
    }
}