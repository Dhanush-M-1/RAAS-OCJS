import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

@SuppressWarnings("SameParameterValue")
public class Main {

    private PrintWriter pw;
    private Scanner sc;

    private void run(boolean stdio) throws IOException {
        if (stdio) {
            pw = new PrintWriter(System.out);
            sc = new Scanner(System.in);
        } else {
            pw = new PrintWriter("output.txt");
            sc = new Scanner(Paths.get("input.txt"));
        }

        main();

        pw.flush();
        pw.close();
        sc.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run(true);
    }

    private void main() {
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] act = new int[n];
        for (int i = 0; i < n; i++) {
            act[i] = sc.nextInt();
        }

        int cur = 0;
        int move = 0;
        int canDrop = 0;
        for (int i = 0; i < n; ++i) {
            if (act[i] == 0 && cur < 0) {
                move++;
                canDrop = d;
                cur = d;
                continue;
            }
            if (act[i] == 0 && cur - canDrop < 0) {
                canDrop = cur;
            }
            cur += act[i];
            if (cur - canDrop > d) {
                pw.println(-1);
                return;
            }
            if (cur > d) {
                canDrop -= cur - d;
                cur = d;
            }
        }
        pw.println(move);
    }
}
