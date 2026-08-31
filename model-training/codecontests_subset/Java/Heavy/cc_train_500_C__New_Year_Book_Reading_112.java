import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NewYearReading {

	public static void main(String[] args) {
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt(), k = scan.nextInt();
		Stack<Book> temp = new Stack<>();
		int[] w = new int[n], o = new int[k];
		for(int i = 0; i < n; i++) w[i] = scan.nextInt();
		TreeSet<Integer> u = new TreeSet<>();
		
		for(int i = 0; i < k; i++){
			int x = scan.nextInt()-1;
			if(!u.contains(x)) temp.push(new Book(x, w[x]));
			u.add(x);
			o[i] = x;
		}
		Stack<Book> s = new Stack<>(), q = new Stack<>();
		while(!temp.isEmpty()) s.push(temp.pop());
		int res = 0;
		for(int i = 0; i < k; i++){
			int idx = o[i];
			int add = 0;
			while(s.peek().i != idx){
				add += s.peek().w;
				q.push(s.pop());
			}
			Book read = s.pop();
			res += add;
			while(!q.isEmpty()) s.push(q.pop());
			s.push(read);
		}
		out.println(res);
		out.close();
	}

	static class Book {
		int i, w;
		public Book(int a, int b){
			i = a;
			w = b;
		}
	}
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}

		public int nextInt() {return Integer.parseInt(next());}

		public long nextLong() {return Long.parseLong(next());}

		public double nextDouble() {return Double.parseDouble(next());}
		
		public String nextLine() {
			String line = "";
			try {line = br.readLine();} 
			catch (Exception e) {e.printStackTrace();}
			return line;
		}
		
		public int[] nextArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
	
}
