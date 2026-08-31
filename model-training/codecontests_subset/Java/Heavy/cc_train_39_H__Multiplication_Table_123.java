import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class H {
	
	static class Scanner{
		BufferedReader br=null;
		StringTokenizer tk=null;
		public Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() throws IOException{
			while(tk==null || !tk.hasMoreTokens())
				tk=new StringTokenizer(br.readLine());
			return tk.nextToken();
		}
		public int nextInt() throws NumberFormatException, IOException{
			return Integer.valueOf(next());
		}
		public double nextDouble() throws NumberFormatException, IOException{
			return Double.valueOf(next());
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner sc =  new Scanner();
		int K = sc.nextInt();
		int[] base = new int[K - 1];
		for(int i = 0; i < K - 1; i++)
			base[i] = i + 1;
		for(int m = 1; m < K; m++){
			for(int j = 0; j < K - 1; j++)
				System.out.print(Integer.toString(base[j] * m, K)+ " ");
			System.out.println();
		}
	}

}
