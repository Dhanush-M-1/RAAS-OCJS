import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class TaskB implements Runnable {

	private void solve() {
		List<Integer> size = new ArrayList<Integer>();
		int cntBefore = 1;
		int position = x;
		while (a[position] > -1) {
			++cntBefore;
			position = a[position];
		}
		used = new boolean[n];
		canNext = new boolean[n];
		Arrays.fill(canNext, false);
		for (int i = 0; i < n; ++i) {
			if (a[i] > -1) {
				canNext[a[i]] = true;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (!canNext[i]) {
				boolean foundX = i == x;
				position = i;
				int cnt = 1;
				while (a[position] > -1) {
					++cnt;
					position = a[position];
					if (position == x) {
						foundX = true;
					}
				}
				if (!foundX) {
					size.add(cnt);
				}
			}
		}
		boolean[] can = new boolean[n];
		Arrays.fill(can, false);
		can[0] = true;
		for (int sz: size) {
			for (int i = n-1; i >= 0; --i) {
				if (can[i]) {
					can[i+sz] = true;
				}
			}
		}
		for (int i = 0; i < n; ++i) {
			if (can[i]) {
				out.println(i+cntBefore);
			}
		}
	}
	
	private void readData() {
		n = in.readInt();
		x = in.readInt()-1;
		a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.readInt()-1;
		}
	}
	
	private int x;
	private int n;
	private int[] a;
	private boolean[] used;
	private boolean[] canNext;
	
	private void begin() {
		in = new InputReader(System.in);
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}
	
	private void end() {
		out.flush();
	}
	
	private InputReader in;
	private PrintWriter out;
	
	@Override
	public void run() {
		begin();
		readData();
		solve();		
		end();
	}

	public static void main(String[] args) {
		new TaskB().run();
	}
	
	private class InputReader {
		
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }

	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } 
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }
	    
	    public int readInt() {
	    	return Integer.parseInt(next());
	    }
	    
	    public long readLong() {
	    	return Long.parseLong(next());
	    }
	    
	    public String readString() {
	    	try {
				return reader.readLine();
			} 
	    	catch (IOException e) {				
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	    }
	    
	}

}
