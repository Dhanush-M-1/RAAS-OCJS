import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class problemB implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;
	public static void main(String[] args) {
		new Thread(new problemB()).start();
	}
	
	void solve() throws IOException {
		int t = nextInt(), m = nextInt();
		int[] a = new int[m];
		int last = 1;
		LinkedHashMap<Integer, Integer> kol = new LinkedHashMap<Integer, Integer>();
		for(int i = 0; i < t; ++i) {
			String s = nextLine();
			if(s.startsWith("alloc")) {
				int k = Integer.parseInt(s.substring(6, s.length()));
				boolean found = false;
				for(int j = 0; j < m; ++j) {
					int beg = j;
					while(j < m && a[j] == 0) ++j;
					int len = j - beg;
					if(len >= k) {
						for(int p = beg; p < beg + k; ++p) {
							a[p] = last;
						}
						kol.put(last, k);
						last++;
						found = true;
						break;
					}
				}
				if(found) System.out.println(last - 1);
				else System.out.println("NULL");
			}
			else if(s.startsWith("erase")) {				
				int k = Integer.parseInt(s.substring(6, s.length()));
				if(!kol.containsKey(k)) System.out.println("ILLEGAL_ERASE_ARGUMENT");
				else {
					for (int j = 0; j < a.length; j++) {
						if(a[j] == k) {
							for(int p = 0; p < kol.get(k); ++p)
								a[j + p] = 0;
							kol.remove(k);
							break;
						}
						
					}
				}
			} else {// defragment
				int ind = 0;
				int zero = 0;
				for(ind = 0; ind < m; ++ind) {
					boolean ok = false;
					while(ind < m && a[ind] != 0) {
						ok = true;
						int temp = a[ind];
						a[ind++] = 0;
						a[zero++] = temp;
					}
					if(ok) --ind;
				}
			}
		}
	}
	
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			//in = new BufferedReader(new FileReader(new File("input.txt")));
			tok = new StringTokenizer(in.readLine());			
			out = new PrintWriter(System.out);
			// out = new PrintWriter(new File("output.txt"));
			solve();
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	String nextLine() throws IOException {
		return in.readLine();
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	String next() throws IOException {
		while(!tok.hasMoreTokens() && in.ready())
			tok = new StringTokenizer(in.readLine());
		return tok.nextToken();
	}
	
}
