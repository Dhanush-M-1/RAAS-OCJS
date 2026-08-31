import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
        int rs[]=new int[5];
        int tot=0;
        for (int i = 0; i < 5; i++) {
            rs[i]=in.nextInt();
            tot+=rs[i];
        }
        if(tot%5==0&&tot!=0){
            out.println(tot/5);

        }else out.println(-1);
    }
}

