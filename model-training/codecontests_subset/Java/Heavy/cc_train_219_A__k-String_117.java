import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author George Marcus
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
        int k = in.nextInt();
        String s = in.next();
        char[] amount = new char[30];

        for(int i = 0; i < s.length(); i++)
            amount[(int)(s.charAt(i) - 'a')]++;

        for(int i = 0; i <= 'z' - 'a'; i++)
            if(amount[i] % k != 0) {
                out.print(-1);
                return;
            }

        StringBuffer strbuf = new StringBuffer();
        for(int i = 0; i <= 'z' - 'a'; i++)
            for(int j = 0; j < amount[i] / k; j++)
                strbuf.append((char)(i + 'a'));

        for(int i = 0; i < k; i++)
            out.print(strbuf.toString());
	}
}

