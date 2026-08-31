import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class mas2alatanya {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		skp();
		int n  = nextInt();
		int[]a = new int[n];
		skp();
		long fadel = n;
		int b[] = new int[100000+9];
		for(int i = 0 ; i < n ; i++){
			a[i]=nextInt();
			b[a[i]]++;
		}
		Arrays.sort(a);
		long count = 0;
		for(int i = 0 ; i < n ; i++){
			fadel = fadel - b[a[i]]; 
			if(b[a[i]]==0)continue;
			count = count + fadel*b[a[i]];
			b[a[i]]=0;
		}
		System.out.println(count);
		
		

	}
	
	

	static boolean skp() throws IOException {
		String line = r.readLine();
		if (line == null)
			return false;
		tkn = new StringTokenizer(line);
		return true;
	}

	static int nextInt() {
		return Integer.parseInt(tkn.nextToken());
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(r.readLine());
	}

	static long nextLong() {
		return Long.parseLong(tkn.nextToken());
	}

	static long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(r.readLine());
	}

	static double nextDouble() {

		return Double.parseDouble(tkn.nextToken());
	}

	static BufferedReader r = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer tkn;

}
