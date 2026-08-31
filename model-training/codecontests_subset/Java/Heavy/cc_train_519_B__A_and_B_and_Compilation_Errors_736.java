import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolverB {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		new SolverB().Run();
	}

	BufferedReader br;
	PrintWriter pw;
	StringTokenizer stok;

	public String nextToken() throws IOException {
		while (stok == null || !stok.hasMoreTokens()) {
			stok = new StringTokenizer(br.readLine());
		}
		return stok.nextToken();
	}

	public int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	public void reading() throws NumberFormatException, IOException {
		int n = nextInt();
		int[] m1, m2, m3;
		m1 = new int[n];
		m2=new int[n-1];
		m3=new int[n-2];
		for (int i=0; i<n; i++){
			m1[i]=nextInt();
		}
		for (int i=0; i<n-1; i++){
			m2[i]=nextInt();
		}
		for (int i=0; i<n-2; i++){
			m3[i]=nextInt();
		}
		Arrays.sort(m1);
		Arrays.sort(m2);
		Arrays.sort(m3);
		
		int i;
		for (i=0; i<n-1 && m1[i]==m2[i]; i++);
		
		pw.println(m1[i]);
		
		for (i=0; i<n-2 && m2[i]==m3[i]; i++);
		
		pw.println(m2[i]);
	}

	public void solve() throws NumberFormatException, IOException {
		reading();
	}

	public void Run() throws NumberFormatException, IOException {
//		br = new BufferedReader(new FileReader("input.txt"));
//		pw = new PrintWriter("output.txt");
		br=new BufferedReader(new InputStreamReader(System.in)); pw=new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		pw.flush();
		pw.close();
	}

}
