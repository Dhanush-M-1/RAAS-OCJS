import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		(new Main()).solve();
	}

	public Main() {
	}
	
	MyReader in = new MyReader();
	PrintWriter out = new PrintWriter(System.out);
	
	void solve() throws IOException {
		//BufferedReader in = new BufferedReader(new
		//InputStreamReader(System.in));
		//Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt() - 1;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt() - 1;
		}
		boolean[] use = new boolean[n];
		List<Integer> counts = new ArrayList<Integer>();
		int before = 0, after = 0;
		int len = 0;
		for (int i = 0; i < n; i++) {
			if (!use[i]) {
				int cur = i;
				boolean flag = true;
				while (flag) {
					flag = false;
					for (int j = 0; j < n; j++) {
						if (a[j] == cur) {
							cur = j;
							flag = true;
							break;
						}
					}
				}				
				
				int count = 1;
				boolean bef = false;

				while (a[cur] > -1) {
					if (cur == x) {
						after = count - 1;
						bef = true;
						count = 0;
					} 
					if (bef) {
						before++;
					} else {
						count++;
					}
					use[cur] = true;
					cur = a[cur];
				}
				use[cur] = true;
				if (count > 0) {
					if (cur == x) {
						after = count - 1;
					} else {
						counts.add(count);
						len += count;
					}
				}
			}
		}
		len = len + before + after + 1;
		int rest = n - len;
		for (int i = 0; i < rest; i++) {
			counts.add(1);
		}
		boolean[] can = new boolean[n];
		boolean[] can2 = new boolean[n];
		can[0] = true;
		for (int t : counts) {
			for (int i = 0; i < n; i++) {
				if (can[i] && i + t < n) {
					can2[i + t] = true;
				}
			}
			for (int i = 0; i < n; i++) {
				can[i] = can[i] || can2[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (can[i]) {
				out.println(i + before + 1);
			}
		}
		
		out.close();
		
	}

	
};

class MyReader {
	private BufferedReader in;
	String[] parsed;
	int index = 0;

	public MyReader() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public int nextInt() throws NumberFormatException, IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return Integer.parseInt(parsed[index++]);
	}

	public long nextLong() throws NumberFormatException, IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return Long.parseLong(parsed[index++]);
	}
	
	public double nextDouble() throws NumberFormatException, IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return Double.parseDouble(parsed[index++]);
	}
	
	public String nextString() throws IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return parsed[index++];
	}

	private void read() throws IOException {
		parsed = in.readLine().split(" ");
		index = 0;
	}

	public String readLine() throws IOException {
		return in.readLine();
	}
};

