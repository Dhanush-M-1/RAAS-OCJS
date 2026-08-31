import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Main {

	static class Task {
		
		int NN = 200005;
		int MOD = 1000000007;;
		int INF = 2000000000;
		long INFINITY = 2000000000000000000L;
		
		String s;int n ;
		
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
			int ans = 0;
			if(q == 0) {
				++ans;
				rowToCols.put(1, Arrays.asList(new Integer[] {1}));
				colToRows.put(1, Arrays.asList(new Integer[] {1}));
			}
			while(q-- > 0) {
				int r = in.nextInt(), c = in.nextInt();
				List<Integer> cols = new ArrayList<>();
				if(rowToCols.containsKey(r)) {
					cols = rowToCols.get(r);
				}
				cols.add(c);
				rowToCols.put(r, cols);
				List<Integer> rows = new ArrayList<>();
				if(colToRows.containsKey(c)) {
					rows = colToRows.get(c);
				}
				rows.add(r);
				colToRows.put(c, rows);
			}
			uf = new UnionFind(m);
			ans += prepareDSU(m);			
			int emptyRows = 0;
			for(int i=1;i<=n;++i) {
				if(rowToCols.containsKey(i))
					continue;
				++emptyRows;
			}
			ans += (emptyRows);
			out.println(ans);
		}
		
		int prepareDSU(int m) {
			for(Integer row: rowToCols.keySet()) {
				List<Integer> cols = rowToCols.get(row);
				for(int i=1;i<cols.size();++i) {
					uf.union(cols.get(0), cols.get(i));
				}
			}
			TreeSet<Integer> parents = new TreeSet<>();
			for(int col=1;col<=m;++col) {
				parents.add(uf.find(col));
			}
			return parents.size() - 1;
		}
		
		UnionFind uf;
		Map<Integer, List<Integer>> rowToCols = new HashMap<>();
		Map<Integer, List<Integer>> colToRows = new HashMap<>();

		class UnionFind {
			List<Node> nodes;
			public UnionFind(int n) {
				nodes = new ArrayList<>();
				nodes.add(new Node());
				for(int i=1;i<=n;++i) {
					nodes.add(new Node(i, 0));
				}
			}
			
			int find(int x) {
				return nodes.get(x).parent = (
						nodes.get(x).parent == x ? x :
							find(nodes.get(x).parent));
			}
			
			void union(int x, int y) {
				if(x == y)
					return;
				x = find(x);y = find(y);
				if(x == y)
					return;
				if(nodes.get(x).rank == nodes.get(y).rank) {
					++nodes.get(y).rank;
					nodes.get(x).parent = nodes.get(y).parent;
				} else if(nodes.get(x).rank < nodes.get(y).rank) {
					nodes.get(x).parent = nodes.get(y).parent;
				} else {
					nodes.get(y).parent = nodes.get(x).parent;
				}
			}
		}
		
		class Node {
			Integer parent, rank;
			public Node() {
				
			}
			public Node(Integer parent, Integer rank) {
				this.parent = parent;
				this.rank = rank;
			}
			
		}
		
	}
	
	static void prepareIO(boolean isFileIO) {
		//long t1 = System.currentTimeMillis();
		Task solver = new Task();
		// Standard IO
		if(!isFileIO) {
			InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        InputReader in = new InputReader(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        solver.solve(in, out);
	        //out.println("time(s): " + (1.0*(System.currentTimeMillis()-t1))/1000.0);
	        out.close();
		}
        // File IO
		else {
			String IPfilePath = System.getProperty("user.home") + "/Downloads/ip.in";
	        String OPfilePath = System.getProperty("user.home") + "/Downloads/op.out";
	        InputReader fin = new InputReader(IPfilePath);
	        PrintWriter fout = null;
	        try {
				fout = new PrintWriter(new File(OPfilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	        solver.solve(fin, fout);
	        //fout.println("time(s): " + (1.0*(System.currentTimeMillis()-t1))/1000.0);
	        fout.close();
		}
	}
	
	public static void main(String[] args) {
        prepareIO(false);
	}
	
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        
        public InputReader(String filePath) {
        	File file = new File(filePath);
            try {
				reader = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            tokenizer = null;
        }
        
        public String nextLine() {
        	String str = "";
        	try {
				str = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return str;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        
    }

}