import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Main mainObj = new Main();
		mainObj.solve();
	}
	
	int[] openStoreBitArr;
	int[][] benefitArr;
	int n;
	
	public void solve() throws IOException {
		FastScanner fs = new FastScanner();
		n = fs.nextInt();
		openStoreBitArr = new int[n];
		
		for(int i = 0; i < n; i++){
			int storeIBit = 0;
			for(int j = 0; j < 10; j++){
				storeIBit = storeIBit << 1;
				if(fs.nextInt() == 1){
					storeIBit += 1;
				}
			}
			openStoreBitArr[i] = storeIBit;
		}
		
		benefitArr = new int[n][11];
		
		for(int i =0; i < n; i++){
			for(int j = 0; j < 11; j++){
				benefitArr[i][j] = fs.nextInt();
			}
		}
		
//		for(int i =0; i < n; i++){
//			System.out.println(Arrays.toString(benefitArr[i]));
//		}
		System.out.println(dfs(0, 0));
	}

	
	int numOfBit(int n){
		int retVal = 0;
		for(int i = 0; i < 10; i++){
			if(((n>>i) & 1) == 1){
				retVal++;
			}
		}
		return retVal;
	}
	
	int dfs(int bit, int depth){
		if(depth == 10){
			return calcBenefit(bit);
		}
		
		return Math.max(dfs(bit<<1, depth+1), dfs((bit<<1)+1, depth+1));
	}
	
	int calcBenefit(int bit){
		if(bit == 0){
			return -1000000001;
		}
		int benefit = 0;
		for(int i = 0; i < n; i++){
			benefit += benefitArr[i][numOfBit(bit & openStoreBitArr[i])];
		}
		return benefit;
	}
	

	public class FastScanner {

		BufferedReader reader;
		private StringTokenizer st;

		public FastScanner() {
			st = null;
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() throws IOException {
			if (st == null || !st.hasMoreElements()) {
				st = new StringTokenizer(reader.readLine());
			}
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			st = null;
			String readLine = null;
			readLine = reader.readLine();
			return readLine;
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		public int[] nextIntArr(int n) throws NumberFormatException, IOException {
			int[] retArr = new int[n];
			for (int i = 0; i < n; i++) {
				retArr[i] = nextInt();
			}
			return retArr;
		}

		public long[] nextLongArr(int n) throws NumberFormatException, IOException {
			long[] retArr = new long[n];
			for (int i = 0; i < n; i++) {
				retArr[i] = nextLong();
			}
			return retArr;
		}

		public void close() throws IOException {
			reader.close();
		}
	}

}
