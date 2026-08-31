import java.io.*;
import java.util.*;

/**
 * @author Vaibhav Mittal
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new FileReader("Input"));
        PrintWriter out = new PrintWriter(System.out);

        int testCases = 1;
        Task solver = new Task();
        for (int i = 1; i <= testCases; ++i)
            solver.solve(in, out);

        in.close();
        out.close();
    }
}

class Task {
    public void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int res = (int) Math.max(0, Math.ceil((double ) n * y / 100.0 - x));
        out.println(res);
    }
}