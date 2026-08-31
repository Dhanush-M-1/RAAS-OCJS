

import java.util.*;
import java.io.*;

public class CF1334D {
	static FastReader in = new FastReader();

	public static void main(String[] args) {
		int t = in.nextInt();
		while(t-- > 0) solve();
	}

	static void solve() {
		int n = in.nextInt();
		long l = in.nextLong();
		long r = in.nextLong();
		int idx = 1;
        long curr = 0;
        while(curr + (n - idx) * 2 < l){
            if(idx == n){
                break;
            }
 
            curr += (n - idx) * 2;
            idx += 1;
        }
        List<Integer> cycle = new ArrayList<>();
        while(cycle.size() < r - curr + 1){
            if(idx == n){
                break;
            }
 
            for(int i = idx + 1; i <= n; i++){
                cycle.add(idx);
                cycle.add(i);
            }
            idx += 1;
        }
        cycle.add(1);
 
        StringBuilder sb = new StringBuilder();
        for(long i = l; i <= r; i++){
            sb.append(cycle.get((int)(i - curr - 1)));
            sb.append(' ');
        }

        System.out.println(sb.toString());
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}



