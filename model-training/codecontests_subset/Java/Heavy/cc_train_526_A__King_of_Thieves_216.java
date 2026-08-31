import java.io.*;
import java.util.*;

public class Main {
	
	static class Assert {
		
		static void check(boolean e) {
			if (!e) {
				throw new Error();
			}
		}
	}
	
	static class Scanner {
		
		StreamTokenizer in;
		
		Scanner(Reader r) {
			in = new StreamTokenizer(new BufferedReader(r));
			in.resetSyntax();
			in.whitespaceChars(0, 32);
			in.wordChars(33, 255);
		}
		
		String next() {
			try {
				in.nextToken();
				Assert.check(in.ttype == in.TT_WORD);
				return in.sval;
			} catch (IOException e) {
				throw new Error(e);
			}
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
	}

	static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) throws IOException {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                System.err.println(e);
                System.exit(1);
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
	
	FastScanner in;
	
	//Scanner in;

	PrintWriter out;
	
	void solve() {
		int n = in.nextInt();
		char s[] = in.next().toCharArray();
		boolean f = false;
		for (int i = 0; i < n - 4; ++i) {
			if (s[i] != '*') {
				continue;
			}
			for (int j = i + 1; j < n - 3; ++j) {
				if (s[j] != '*') {
					continue;
				}
				for (int p = j + 1; p < n - 2; ++p) {
					if (s[p] != '*') {
						continue;
					}
					for (int z = p + 1; z < n - 1; ++z) {
						if (s[z] != '*') {
							continue;
						}
						for (int x = z + 1; x < n; ++x) {
							if (s[x] != '*') {
								continue;
							}
							if (x - z == z - p && z - p == p - j && p - j == j - i) {
								f = true;
							}
						}
					}
				}
			}
		}
		out.println(f ? "yes" : "no");
	}
	
	void run() {
		try {
			in = new FastScanner(System.in);
			out = new PrintWriter(System.out);
			//in = new Scanner(new FileReader("input.txt"));
			//out = new PrintWriter(new FileWriter("output.txt"));
		} catch (IOException e) {
			throw new Error(e);
		}
		try {
			solve();
		} finally {
			out.close();
		}
	}
	
	public static void main(String args[]) {
		new Main().run();
	}
}