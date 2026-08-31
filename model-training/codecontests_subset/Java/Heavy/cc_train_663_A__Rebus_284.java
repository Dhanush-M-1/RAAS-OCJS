//package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int pos = 1, neg = 0;
		while (true) {
			char c = sc.next().charAt(0);
			if (c == '+') {
				pos++;
				q.add(1);
			} else if (c == '-') {
				neg++;
				q.add(-1);
			} else if (c == '=')
				break;
		}
		int n = sc.nextInt();
		if(n < -n*neg+pos || n > pos*n-neg)
			out.println("Impossible");
		else{
			out.println("Possible");
			int r = 0;
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()){
				int c = q.poll();
				if(c == 1) pos--;
				else neg--;
				for (int i = 1; i <= n; i++) {
					if(!q.isEmpty() && r + pos - neg*n + c*i <= n && r + c*i + n*pos - neg >= n || q.isEmpty() && r+c*i == n){
						if(sb.length() != 0)
							sb.append(" ").append((c == 1?'+':'-')).append(" ");
						sb.append(i);
						r += c*i;
						break;
					}
				}
			}
			sb.append(" = ").append(n);
			out.println(sb);
		}
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader) {
			br = new BufferedReader(fileReader);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}