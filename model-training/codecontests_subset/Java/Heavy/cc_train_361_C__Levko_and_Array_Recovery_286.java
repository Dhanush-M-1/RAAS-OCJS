import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.text.ChangedCharSetException;


public class ProblemC {
	

	InputReader in;
	PrintWriter out;

	private void runIO() throws IOException {
//		in = new InputReader(new File("file.in"));
//		out = new PrintWriter(new File("file.out"));
		in  = new InputReader(System.in);
		out = new PrintWriter(System.out);
	}

	private void closeIO() {
		out.close();
	}

	class InputReader {
		BufferedReader bf;
		StringTokenizer st;

		InputReader(File f) throws FileNotFoundException {
			bf = new BufferedReader(new FileReader(f));
		}

		InputReader(InputStream s) {
			bf = new BufferedReader(new InputStreamReader(s));
		}

		private String next() throws IOException {
			while (st == null || !st.hasMoreElements()) {
				String s;
				try {
					s = bf.readLine();
				} catch (IOException e) {
					return null;
				}
				if (s == null)
					return null;
				st = new StringTokenizer(s);
			}
			return st.nextToken();
		}

		private int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		private long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		private double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

	}

	public static void main(String[] S) throws IOException {
		// long startTime = System.currentTimeMillis();
		Locale.setDefault(Locale.US);
		new ProblemC().run();
		// System.out.println("Time used: "+(System.currentTimeMillis()-startTime)+" ms.");
	}

	private void run() throws IOException {
		runIO();
		solve();
		closeIO();
	}

	public int N, K;
	public int[] Array;
	public int[] WasChangedLast;
	private int[] numOfChangedOnStep;
	private void solve() throws IOException {
		int N = in.nextInt();
		int K = in.nextInt();
		Array = new int[N];
		WasChangedLast = new int[N];
		Arrays.fill(WasChangedLast, -1);
		numOfChangedOnStep = new int[K];
		int[][] Commands = new int[K][4];
		int maxCounter = 0;
		for (int i=K-1;i>=0;i--){
			for (int j=0;j<4;j++){
				Commands[i][j] = in.nextInt();
			}
			if (Commands[i][0]==2) maxCounter = Math.max(maxCounter, Commands[i][3]);
		}
		Arrays.fill(Array, 1000000000);
//		System.out.println(maxCounter);
		
		
		for (int i=0;i<K;i++){
			if (Commands[i][0]==1){
				for (int j=Commands[i][1]-1;j<Commands[i][2];j++)
					Array[j]-=Commands[i][3];
			}
			
			if (Commands[i][0]==2){
				boolean exist = false;
				for (int j=Commands[i][1]-1;j<Commands[i][2];j++) {
					if (Array[j]>=Commands[i][3]){
						exist = true;
						break;
					}
					if (WasChangedLast[j]==-1){
						Array[j] = Commands[i][3]+1;
						exist = true;
						break;
					}
				}
				if (!exist) {
					out.println("NO");
					return;
				}
				for (int j=Commands[i][1]-1;j<Commands[i][2];j++){
					if (Array[j]==Commands[i][3]){
						numOfChangedOnStep[i]++;
					}
					if (Array[j]>Commands[i][3]){
						if (WasChangedLast[j]==-1){
							WasChangedLast[j] = i;
							numOfChangedOnStep[i]++;
							Array[j] = Commands[i][3];
						}
						else {
							if (numOfChangedOnStep[WasChangedLast[j]]!=1){
								numOfChangedOnStep[WasChangedLast[j]]--;
								numOfChangedOnStep[i]++;
								WasChangedLast[j] = i;
								Array[j] = Commands[i][3];
							}
							else {
								out.println("NO");
								return;
							}
							
						}
					}
					
					if (Array[j]<Commands[i][3]&&WasChangedLast[j]==-1) Array[j] = Commands[i][3];
					
				}
				
				
			}
		}
		
		
		
		out.println("YES");
		for (int i=0;i<N;i++){
			if (Array[i]>1000000000)
				Array[i] = 1000000000;
			out.print(Array[i]+" ");
		}

	}
}
