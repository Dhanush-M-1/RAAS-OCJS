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
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Main {

	static class Task {
		
		int NN = 200005;
		int MOD = 1000000007;;
		int INF = 2000000000;
		long INFINITY = 2000000000000000000L;
		
		
		int idx(char c) {
			if(c >= '0' && c<='9')
				return c-'0';
			return (c-'A')+10;
		}
		
		String [] data = new String[] {
				"0000",
				"0001",
				"0010",
				"0011",
				"0100",
				"0101",
				"0110",
				"0111",
				"1000",
				"1001",
				"1010",
				"1011",
				"1100",
				"1101",
				"1110",
				"1111"
		};
		
		public void solve(InputReader in, PrintWriter out) {
			n = in.nextInt();
			a = new int[n][n];
			sm = new int[n][n];
			for(int i=0;i<n;++i) {
				String s = in.next();
				int jj = 0;
				for(int j=0;j<s.length();++j) {
					String str = data[idx(s.charAt(j))];
					for(int k=0;k<4;++k) {
						a[i][j*4+k] = 0;
						if(str.charAt(k) == '1')
							a[i][j*4+k] =1;
					}
				}
			}
			for(int i=0;i<n;++i) {
				int sum = 0;
				for(int j=0;j<n;++j) {
					sum += a[i][j];
					sm[i][j] = sum;
				}
			}
			int ans = 1;
			for(int i=1;i*i<=n;++i) {
				if(n%i != 0)
					continue;
				int f1 = i;
				int f2 = n / i;
				if(ok(f1))
					ans = Math.max(ans, f1);
				if(f2 != f1 && ok(f2))
					ans = Math.max(ans, f2);
			}
			out.println(ans);
		}
		int [][]a;
		int [][]sm;int n;
		
		boolean ok(int x) {
			for(int i=0;i + x-1 <n;i+=x) {
				for(int j=0;j+x-1<n;j+=x) {
					int sum= 0;
					for(int k=i;k<i+x;++k) {
						sum += sm[k][j+x-1] - (j>0?sm[k][j-1]:0);
					}
					if(sum == 0 || sum == x*x)
						continue;
					return false;
				}
			}
			return true;
		}

		
		
		
		
		
		
		
		class Pair {
			Integer first, second;

			public Pair(Integer first, Integer second) {
				super();
				this.first = first;
				this.second = second;
			}

			public Pair() {
				super();
				// TODO Auto-generated constructor stub
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