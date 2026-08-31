import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
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
        long n = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();
        long need = n * y;
        if (need % 100 == 0){
            need = need / 100;
            if (need - x >= 0)   {
                out.println(need - x);
                return;
            }else{
                out.println(0);
            }
        } else{
            need = need / 100;
            need++;
            if (need - x >= 0)   {
                out.println(need - x);
                return;
            }else{
                out.println(0);
            }
        }
    }
}

