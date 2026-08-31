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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Main {

	static class Task {
		
		int NN = 200005;
		int MOD = 1000000007;
		int INF = 2000000000;
		long INFINITY = 2000000000000000000L;
		
		long [][] dp;
		
		long rec(int i, int ten) {
			if(i == n)
				return 0;
			if(dp[i][ten] != -1)
				return dp[i][ten];
			long ret = rec(i + 1, ten);
			for(int j=0;j<6;++j) {
				if(D[i][j][0] == -1)
					continue;
				int newTen = ten + (int)D[i][j][0];
				long damage = D[i][j][1];
				if(newTen >= 10) {
					newTen -= 10;
					damage += D[i][j][2];
				}
				ret = Math.max(ret, damage + rec(i + 1, newTen));
			}
			return dp[i][ten] = ret;
		}
		
		//size totatdamage maxdamage
		long [][][]D;
		int n;
		
		public void solve(InputReader in, PrintWriter out) {
			n = in.nextInt();
			D = new long[n][6][3];
			for(int i=0;i<n;++i) {
				for(int j=0;j<6;++j) {
					for(int k=0;k<3;++k)
						D[i][j][k] = -1;
				}
			}
			for(int ii=1;ii<=n;++ii) {
				int k = in.nextInt();
				List<Long> one = new ArrayList<>();
				List<Long> two = new ArrayList<>();
				List<Long> three = new ArrayList<>();
				while(k-->0) {
					long cost = in.nextLong();
					long damage = in.nextLong();
					if(cost == 1) {
						one.add(damage);
					} else if(cost == 2) {
						two.add(damage);
					} else {
						three.add(damage);
					}
				}
				Collections.sort(one, (i, j) -> j.compareTo(i));
				Collections.sort(two, (i, j) -> j.compareTo(i));
				Collections.sort(three, (i, j) -> j.compareTo(i));
				if(one.size() >= 1) {
					D[ii - 1][0][0] = 1;
					D[ii - 1][0][1] = one.get(0);
					D[ii - 1][0][2] = one.get(0);
				}
				if(one.size() >= 2) {
					D[ii - 1][1][0] = 2;
					D[ii - 1][1][1] = one.get(0) + one.get(1);
					D[ii - 1][1][2] = one.get(0);
				}
				if(one.size() >= 3) {
					D[ii - 1][2][0] = 3;
					D[ii - 1][2][1] = one.get(0) + one.get(1) + one.get(2);
					D[ii - 1][2][2] = one.get(0);
				}
				if(two.size() >= 1) {
					D[ii - 1][3][0] = 1;
					D[ii - 1][3][1] = two.get(0);
					D[ii - 1][3][2] = two.get(0);
				}
				if(three.size() >= 1) {
					D[ii - 1][4][0] = 1;
					D[ii - 1][4][1] = three.get(0);
					D[ii - 1][4][2] = three.get(0);
				}
				if(two.size() >= 1 && one.size() >= 1) {
					D[ii - 1][5][0] = 2;
					D[ii - 1][5][1] = two.get(0) + one.get(0);
					D[ii - 1][5][2] = Math.max(one.get(0), two.get(0));
				}
			}
			dp = new long[n][10];
			for(int i=0;i<n;++i) {
				for(int iii=0;iii<10;++iii) {
					dp[i][iii] = -1;
				}
			}
			out.println(rec(0, 0));
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