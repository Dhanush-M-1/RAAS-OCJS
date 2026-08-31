import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem500B {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		StringTokenizer info = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(info.nextToken());
		int m = Integer.parseInt(info.nextToken());
		int q = Integer.parseInt(info.nextToken());

		boolean transpose = false;
		if (m > n) {
		    int temp = n;
		    n = m;
		    m = temp;
		    transpose = true;
        }
		List<Integer>[] matrix = new List[n];
		for (int i = 0; i < n; i++) {
		    matrix[i] = new ArrayList<>();
        }
		for (int i = 0; i < q; i++) {
		    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		    int x = Integer.parseInt(tokenizer.nextToken()) - 1;
		    int y = Integer.parseInt(tokenizer.nextToken()) - 1;
		    if (transpose) {
		        int temp = x;
		        x = y;
		        y = temp;
            }
		    matrix[x].add(y);
        }
		Map<Integer, Set<Integer>> edges = new TreeMap<>();
		for (int i = 0; i < m; i++) {
		    edges.put(i, new TreeSet<>());
        }
		int numEmptyRows = 0;
		for (int i = 0; i < n; i++) {
		    if (matrix[i].isEmpty()) {
		        numEmptyRows++;
            } else {
                for (int j = 0; j < matrix[i].size() - 1; j++) {
                    int a = matrix[i].get(j);
                    int b = matrix[i].get(j + 1);
                    edges.get(a).add(b);
                    edges.get(b).add(a);
                }
            }
        }
		int answer = numComponents(m, edges) - 1 + numEmptyRows;
		writer.println(answer);

		reader.close();
		writer.close();
	}
	public static int numComponents(int numVertices, Map<Integer, Set<Integer>> edges) {
	    int numComponents = 0;
	    boolean[] visited = new boolean[numVertices];
	    for (int i = 0; i < numVertices; i++) {
	        if (!visited[i]) {
	            bfs(visited, i, edges);
	            numComponents++;
            }
        }
	    return numComponents;
    }
    public static void bfs(boolean[] visited, int current, Map<Integer, Set<Integer>> edges) {
	    Deque<Integer> queue = new ArrayDeque<>();
	    queue.add(current);
	    while (!queue.isEmpty()) {
	        int polled = queue.poll();
	        visited[polled] = true;
	        for (int neighbor : edges.get(polled)) {
	            if (!visited[neighbor]) {
	                queue.add(neighbor);
                }
            }
        }
    }
}
