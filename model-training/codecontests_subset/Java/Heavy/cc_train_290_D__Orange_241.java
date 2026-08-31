import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solver {

	public static void main(String[] Args) throws NumberFormatException,
			IOException {
		new Solver().Run();
	}

	PrintWriter pw;
	StringTokenizer Stok;
	BufferedReader br;

	public String nextToken() throws IOException {
		while (Stok == null || !Stok.hasMoreTokens()) {
			Stok = new StringTokenizer(br.readLine());
		}
		return Stok.nextToken();
	}

	public int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	public long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}

	public void Run() throws NumberFormatException, IOException {
		//br = new BufferedReader(new FileReader("input.txt"));
		//pw = new PrintWriter("output.txt");
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new OutputStreamWriter(System.out));
		char[] wrd = nextToken().toLowerCase().toCharArray();
		char c;
		int k = nextInt();
		for(int i = 0; i< wrd.length; i++){
			c = wrd[i];
			if ((int)c<k+97){
				wrd[i] = Character.toUpperCase(c);
			} else {
				wrd[i] = Character.toLowerCase(c);
			}
		}
		for(char d:wrd){
			pw.print(d);
		}
		pw.flush();
		pw.close();
	}

}