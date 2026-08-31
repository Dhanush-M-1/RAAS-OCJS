import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Rene
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
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int capA = in.nextInt();
        int capB = in.nextInt();
        int queries = in.nextInt();
        BITTree tree = new BITTree(n, capA, capB);
        for ( int i = 0; i < queries; i++ ) {
            int z = in.nextInt();
            if ( z == 1 ) {
                int d = in.nextInt();
                int a = in.nextInt();
                tree.add(d, a);
            } else {
                int p = in.nextInt();
                long countB = tree.sumB(p-1);
                long countA = tree.sumA(n) - tree.sumA(p + k - 1);
                out.println(countB + countA);
            }
        }
    }

    class BITTree {
        long[] treeA, treeB, orders;
        int capA, capB, n;
        public BITTree(int n, int capA, int capB) {
            treeA = new long[n+1];
            treeB = new long[n+1];
            orders = new long[n+1];
            this.n = n;
            this.capA = capA;
            this.capB = capB;
        }
        void add(int day, int amount) {
            long old = orders[day];
            orders[day] += amount;
            long deltaA = Math.min(orders[day], capA) - old;
            if ( deltaA > 0 ) update(treeA, day, deltaA);
            long deltaB = Math.min(orders[day], capB) - old;
            if ( deltaB > 0 ) update(treeB, day, deltaB);
        }

        void update(long[] tree, int day, long delta) {
            int index = day;
            while ( index <= n ) {
                tree[index] += delta;
                index += (index & -index);
            }
        }

        long sumA(int day) {
            return sum(treeA, day);
        }
        long sumB(int day) {
            return sum(treeB, day);
        }

        long sum(long[] tree, int day) {
            long answer = 0;
            while ( day > 0 ) {
                answer += tree[day];
                day -= (day & -day);
            }
            return answer;
        }
    }
}

