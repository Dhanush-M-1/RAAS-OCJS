import java.util.*;
import java.io.*;
public class B {
	public void solve() throws IOException {
		int n = nextInt();
		int m = nextInt();
		int[] memory = new int[m];
		int[] data = new int[n+1];
		int aloc = 1;
		for(int i = 0; i < n; i++){
	/*		for(int x : memory){
				writer.print(x + " ");
			}
			writer.println();*/
			String str = nextToken();
			if( str.equals("alloc") ){
				int t = nextInt();
				int start = -1;				
				for(int j = 0; j < m; j++){
					if( memory[j] == 0 ){
						if( start < 0 ){
							start = j;
						}
						continue;
					} else {
						if( start >= 0 ){
							if( j-start >= t ){
								break;
							}
							start = -1;
						}
					}					
				}
				if( m-start >= t && start >= 0 ){
					for(int j = start; j < start+t; j++){
						memory[j] = aloc;
					}
					data[aloc] = t;
					writer.println(aloc);
					aloc++;
				} else {
					writer.println("NULL");
				}
			} else if( str.equals("erase") ){
				int t = nextInt();
				boolean flag = true;
				for(int j = 0; j < m; j++){
					if( memory[j] == t ){
						flag = false;
						memory[j] = 0;
					}				
				}
				if( flag || t <= 0 ){
					writer.println("ILLEGAL_ERASE_ARGUMENT");
				}
			} else {
				int start = -1;
				for(int j = 0; j < m; j++){
					if( memory[j] == 0 ){
						if( start < 0 ){
							start = j;
						}
						continue;
					} else if( start >= 0 ){
						int key = memory[j];
						for(int k = start; k < j; k++){
							memory[k] = key;
						}
						for(int k = 0; k < j-start; k++){
							memory[start+data[key]+k] = 0;
							
						}
						start = -1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new B().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() throws IOException {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

}
