import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Weichao Luo
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String dungeon = in.next();
        int [][] jumps = new int[dungeon.length()][dungeon.length()];
        for (int i = 0; i < jumps.length; i ++)
            Arrays.fill(jumps[i], -1);

        boolean good = false;
        for (int i = 0; i < jumps.length; i ++) {

            if (dungeon.charAt(i) == '*') {
                Arrays.fill(jumps[i], 0);
                for (int j = 1; i - j >= 0; j++) {
                    //System.out.println(i - j);
                    if (jumps[i - j][j] != -1)
                        jumps[i][j] = jumps[i - j][j] + 1;
                    if (jumps[i][j] >= 4) good = true;
                    //System.out.println(i + " " + j + " " + jumps[i][j]);
                }
            }
        }
        out.println( good ? "yes" : "no");
    }
}
