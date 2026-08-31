import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Round351D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int a = sc.nextInt()-1;
		int b = sc.nextInt()-1;
		int c = sc.nextInt()-1;
		int d = sc.nextInt()-1;
		
		if(k < n+1 || n == 4){
			System.out.println(-1);
			return;
		}
		
		int p1[] = new int[n];
		int p2[] = new int[n];
		
		p1[0] = a;
		p1[n-1] = b;
		p1[1] = c;
		p1[n-2] = d;
		
		
		p2[0] = c;
		p2[n-1] = d;
		p2[1] = a;
		p2[n-2] = b;
		
		
		
		int piv = 0;
		
		int pointsTo[] = new int[n];
		
		
		Arrays.fill(pointsTo, -1);
		pointsTo[a] = c;
		pointsTo[d] = b;
		
		for(int i=2; i<n-2; i++)
		{
			while(piv == a || piv == b || piv == c || piv == d)
				piv++;
			
			p1[i] = piv;
			pointsTo[p1[i-1]] = p1[i];
			piv++;
		}
		int cur = p2[0];
//		System.out.println(Arrays.toString(pointsTo));
		for(int i=2; i<n-2; i++)
		{
//			System.out.println(cur);
			
			if(pointsTo[cur] != -1 && pointsTo[cur] != d)
			{
				p2[i] = pointsTo[cur];
				
			}
			else if(pointsTo[cur] == d)
			{
				p2[i] = pointsTo[pointsTo[cur]];
			}
			else
			{
				p2[i] = pointsTo[a];
			}
			if(p2[i] == c)
				p2[i] = a;
			cur = p2[i];
		}
		
		
		PrintWriter out = new PrintWriter(System.out);
		
		for(int x:p1)
			out.print(x+1+" ");
		out.println();
		for(int x:p2)
			out.print(x+1+" ");
		out.println();
		out.flush();
//		System.out.println(Arrays.toString(p1));
//		System.out.println(Arrays.toString(p2));
	}
	
	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}
