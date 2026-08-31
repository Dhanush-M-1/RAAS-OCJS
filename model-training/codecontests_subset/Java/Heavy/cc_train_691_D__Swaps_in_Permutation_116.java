import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static long INF = (long)1e15;
	public static void main(String[] argv)throws IOException {
		
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = in.nextInt(), m = in.nextInt();
        
        int[] perm = new int[n];
        for (int i=0; i<n; i++) perm[i] = in.nextInt();
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i=0; i<n; i++) graph.add(new ArrayList<Integer>());
        for (int i=0; i<m; i++) {
        	int x = in.nextInt()-1, y = in.nextInt()-1;
        	graph.get(x).add(y);
        	graph.get(y).add(x);
        }
        boolean[] visited  = new boolean[n];
        
        for (int i=0; i<n; i++) {
        	if (!visited[i]) {
        		List<Integer> inds = new ArrayList<Integer>();
        		dfs(i, visited, graph, inds);
        		int[] nums = new int[inds.size()];
        		for (int j=0; j<inds.size(); j++) nums[j] = perm[inds.get(j)];
        		Arrays.sort(nums);
        		Collections.sort(inds);
        		for (int j=0; j<inds.size(); j++) perm[inds.get(j)] = nums[nums.length-1-j];
        	}
        }
        for (int i=0; i<perm.length-1; i++) bw.write(String.valueOf(perm[i])+" ");
        bw.write(String.valueOf(perm[perm.length-1]));
        bw.newLine();
        bw.flush();
	}
	
	public static void dfs(int i, boolean[] visited, List<List<Integer>> graph, List<Integer> nums) {
		if (visited[i]) return;
		visited[i] = true;
		nums.add(i);
		for (Integer n: graph.get(i)) {
			dfs(n, visited, graph, nums);
		}
	}
	
	
	
	
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}


