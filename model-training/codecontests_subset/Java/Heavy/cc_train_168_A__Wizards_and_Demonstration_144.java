import java.io.*;
import java.util.*;
import java.math.*;

public class CF168A {
    public static void main(String[] args) { 
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        Application solver = new Application();
        solver.solve(System.in, out);

        out.close();
    }
}


class Application {
    public void solve(InputStream in, PrintWriter out) {
        Scanner scanner = new Scanner(in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int d = y*n-x*100;
        if (d < 0) d = 0;
        d = (d % 100 == 0) ? (d / 100) : (d / 100 + 1);
        out.println(d);
    }
}
