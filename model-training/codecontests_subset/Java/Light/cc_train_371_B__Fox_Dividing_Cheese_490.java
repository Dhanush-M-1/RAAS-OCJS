import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author ocozalp
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        int g = gcd(a, b);

        int result = 0;
        a /= g;
        b /= g;

        int [] divs = new int[]{2, 3, 5};

        for(int i = 0; i<divs.length; i++) {
            while(a % divs[i] == 0) {
                result++;
                a /= divs[i];
            }
        }

        for(int i = 0; i<divs.length; i++) {
            while(b % divs[i] == 0) {
                result++;
                b /= divs[i];
            }
        }

        if(a == 1 && b == 1) out.println(result);
        else out.println(-1);
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
