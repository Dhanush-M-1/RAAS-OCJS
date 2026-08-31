import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author vadimmm
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB1 solver = new TaskB1();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB1 {

    private int graph[][];
    private boolean[] used;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int counter = in.nextInt();
        int beaver = in.nextInt() - 1;
        graph = new int[2][counter];
        used = new boolean[counter];
        List<Integer> size = new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        Set<Integer> maybe = new HashSet<Integer>();
        Set<Integer> append;

        for (int i = 0; i < 2; ++i)
            for (int v = 0; v < counter; ++v)
                graph[i][v] = -1;
        for (int v = 0; v < counter; ++v) {
            int u = in.nextInt() - 1;
            if (u != -1) {
                graph[0][v] = u;
                graph[1][u] = v;
            }
        }

        for (int v = 0; v < counter; ++v)
            if (!used[v])
                size.add(dfs(v, 0) + dfs(v, 1) - 1);

        int interestingSize = dfs(beaver, 0) + dfs(beaver, 1) - 1;
        for (int i = 0; i < size.size(); ++i)
            if (size.get(i) == interestingSize) {
                size.remove(i);
                break;
            }
        int position = dfs(beaver, 0);

        maybe.add(0);
        for (int i = 0; i < size.size(); ++i) {
            append = new HashSet<Integer>(maybe.size());
            for (int s : maybe)
                append.add(s + size.get(i));
            maybe.addAll(append);
        }

        answer.addAll(maybe);
        Collections.sort(answer);

        for (int i : answer)
            out.println(i + position);
    }

    private int dfs(int v, int i) {
        int result = 1;
        used[v] = true;
        if (graph[i][v] != -1)
            result += dfs(graph[i][v], i);
        return result;
    }

}

class InputReader {

    private static BufferedReader bufferedReader;
    private static StringTokenizer stringTokenizer;

    public InputReader(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        stringTokenizer = null;
    }

    public String next() {
        while(stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    }

