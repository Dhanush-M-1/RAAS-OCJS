/**  _ _
 * \(^.^\)
 *  ( 8 ;)
 *  ( __;)
 *   V  V
 * by Abril
 */

import java.io.*;
import java.util.*;

public class Main {
	
	void solve() {
		int n = in.nextInt();
		String s = in.next();
		boolean respuesta = false;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '*') {
				for (int j = i + 1; j < n; j++) {
					if (s.charAt(j) == '*') {
						int largo = j - i, contador = 1;
						int k = j;
						while (true) {
							if (k + largo < n && s.charAt(k + largo) == '*') {
								k += largo;
								contador++;
							} else {
								break;
							}
						}
						if (contador >= 4) respuesta = true;
					}
				}
			}
		}
		out.println(respuesta ? "yes" : "no");
	}
	
	void run() {
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	InputReader in;
	PrintWriter out;
	
	class InputReader {
		BufferedReader br;
		StringTokenizer st;
		
		InputReader(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			st = null;
		}
		
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}