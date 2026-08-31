import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author cgy4ever
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    
    long firstFactor(long n)
    {
        for(long i = 2; i * i <= n; i++)
            if(n % i == 0)
                return i;
        return n;
    }
    
    
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        long factor1 = firstFactor(n);
        if(n == factor1)
        {
            out.println("1");
            out.println("0");
            return;
        }
        long factor2 = firstFactor(n / factor1);
        if(factor2 * factor1 == n)
        {
            out.println("2");
            return;
        }
        out.println("1");
        out.println(factor1 * factor2);
    }
}
